package com.lukas.ramonas.cms.Controllers;

import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller // This means that this class is a Controller
public class RegisterController {

    @Autowired
    UserService userService = new UserService();

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "/register";
    }

    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto, BindingResult result,
            HttpServletRequest request ) {

        if(result.hasErrors()){
            return new ModelAndView("register", "user", userDto);
        }

        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView("register","user",userDto);
            mav.addObject("message", uaeEx.getMessage());
            return mav;
        }

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("message", "Succesfully registered new user. Please keep in mind that your new account must be verified by a teacher or admin before you can login.");
        return mav;
    }
}
