package com.lukas.ramonas.cms.Controllers.UserControllers;

import com.lukas.ramonas.cms.DAO.ConferenceDto;
import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.Exceptions.ConferenceAlreadyExistException;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.Conference;
import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Service.IConferenceService;
import com.lukas.ramonas.cms.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IConferenceService conferenceService;

    @GetMapping(path="/teacherIndex")
    public String showTeacherIndex(){
        return "teacherIndex";
    }

    @GetMapping(path="/configure")
    public String showConfigurePage(Model model){
        List<Conference> conferenceList = conferenceService.findAll();
        model.addAttribute("conferenceList", conferenceList);
        return "configure";
    }

    @GetMapping("/createNewConference")
    public String showRegistrationForm(WebRequest request, Model model) {
        ConferenceDto conferenceDto = new ConferenceDto();
        model.addAttribute("conference", conferenceDto);
        return "/createNewConference";
    }

    @PostMapping("/createNewConference")
    public ModelAndView registerUserAccount(
            @ModelAttribute("conference") @Valid ConferenceDto conferenceDto, BindingResult result,
            HttpServletRequest request ) {

        if(result.hasErrors()){
            return new ModelAndView("createNewConference", "conference", conferenceDto);
        }

        try {
            Conference newConference = conferenceService.createNewConference(conferenceDto);
        } catch (ConferenceAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView("createNewConference","conference",conferenceDto);
            mav.addObject("message", uaeEx.getMessage());
            return mav;
        }

        ModelAndView mav = new ModelAndView("configure");
        mav.addObject("message", "Successfully created new conference.");
        return mav;
    }

    @GetMapping(path="/users")
    public String showUsers( Model model){
        List<User> userList = userService.findAllByRoles("ROLE_STUDENT");
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping(value = "/update/{id}")
    public String updateConfirmed(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
        userService.updateConfirmed(id);
        redirectAttributes.addFlashAttribute("message", "User successfully updated");
        return "redirect:/teacher/users";
    }
}