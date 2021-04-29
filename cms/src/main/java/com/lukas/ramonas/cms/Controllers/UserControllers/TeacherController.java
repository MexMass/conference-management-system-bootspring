package com.lukas.ramonas.cms.Controllers.UserControllers;

import com.lukas.ramonas.cms.DAO.ConferenceDto;
import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.Exceptions.ConferenceAlreadyExistException;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.Conference;
import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Service.IConferenceService;
import com.lukas.ramonas.cms.Service.IUserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public String showConfigurePage(Authentication authentication, Model model){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(loggedInUser.getName());
        List<Conference> conferenceList = conferenceService.findAllByCreator(user);
        model.addAttribute("conferenceList", conferenceList);
        return "configure";
    }

    @GetMapping("/createNewConference")
    public String showConferenceCreationForm(WebRequest request, Model model) {
        ConferenceDto conferenceDto = new ConferenceDto();
        model.addAttribute("conference", conferenceDto);
        return "/createNewConference";
    }

    @PostMapping("/createNewConference")
    public ModelAndView createNewConference(
            @ModelAttribute("conference") @Valid ConferenceDto conferenceDto, BindingResult result) {

        if(result.hasErrors()){
            return new ModelAndView("createNewConference","conferenceDto", conferenceDto);
        }

        try {
            conferenceService.createNewConference(conferenceDto);
        } catch (ConferenceAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView("createNewConference","conferenceDto", conferenceDto);
            mav.addObject("message", uaeEx.getMessage());
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:/teacher/configure");
        mav.addObject("message", "Successfully created new conference.");
        return mav;
    }

    @GetMapping(path = "/updateConference/{id}")
    public ModelAndView showUpdateConferenceForm(@PathVariable(name = "id") Long id){
        Optional<Conference> conference = conferenceService.findById(id);
        ModelAndView mav = new ModelAndView("updateConference");
        mav.addObject("conference",conference.get());
        return mav;
    }

    @PostMapping("/updateConference/{id}")
    public ModelAndView updateConference(
            @ModelAttribute("conference") @Valid ConferenceDto conferenceDto, Conference conference, BindingResult result, @PathVariable Long id) {

        if(result.hasErrors()){
            return new ModelAndView("updateConference","conferenceDto", conferenceDto);
        }

        try {
//            conferenceService.updateConference(conferenceDto, id); // I have not implemented this method yet
        } catch (ConferenceAlreadyExistException uaeEx) {        // Dont really know how to handle this exception if I am changing the conference but want to keep the same name
            ModelAndView mav = new ModelAndView("updateConference","conferenceDto", conferenceDto);
            mav.addObject("message", uaeEx.getMessage());
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:/teacher/configure");
        mav.addObject("message", "Successfully modified conference.");
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