package com.lukas.ramonas.cms.Controllers.UserControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @GetMapping(path="/teacherIndex")
    public String showTeacherIndex(){
        return "teacherIndex";
    }
}