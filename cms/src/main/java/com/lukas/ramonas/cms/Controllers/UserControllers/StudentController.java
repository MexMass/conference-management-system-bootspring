package com.lukas.ramonas.cms.Controllers.UserControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(value = "/student")
public class StudentController {

    @GetMapping(path="/studentIndex")
    public String showStudentIndex(){
        return "studentIndex";
    }
}