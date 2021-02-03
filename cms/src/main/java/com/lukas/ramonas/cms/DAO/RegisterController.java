package com.lukas.ramonas.cms.DAO;

import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller // This means that this class is a Controller
public class RegisterController {

    // ++++++++++++++++++ The below ModelandView might be not correct LOOK INTO THIS IN THE FUTURE IF STUFF DOESNT WORK
    // ==================
    ModelAndView mav = new ModelAndView("registerUserAccount");

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto userDto,
             HttpServletRequest request, Errors errors) {

        try {
            /* ++++++++++++++++ WATCH OUT FOR THIS USERSERVICE AS IT MIGHT NOT BE IN THE RIGHT PLACE
            *  Followed example online on baeldung.com although they did not use UserService UserService = new UserService();
            * in this example.
            * */
            UserService UserService = new UserService();
            User registered = UserService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }

        return new ModelAndView("successRegister", "user", userDto);
    }

}
