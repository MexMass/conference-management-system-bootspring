package com.lukas.ramonas.cms.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller // This means that this class is a Controller
public class MainController {
/*
The following defaultRoot redirects any request from "/" to the respective index pages based on ROLE
 */
    @RequestMapping("/")
    public String defaultRoot(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/adminIndex";
        }
        else if (request.isUserInRole("ROLE_STUDENT")) {
            return "redirect:/student/studentIndex";
        }
        else if (request.isUserInRole("ROLE_TEACHER")) {
            return "redirect:/teacher/teacherIndex";
        }
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/test")
    public String showTest() {
        return "testy";
    }


}