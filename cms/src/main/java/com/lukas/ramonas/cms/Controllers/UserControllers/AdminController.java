package com.lukas.ramonas.cms.Controllers.UserControllers;

import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Service.IUserService;
import com.lukas.ramonas.cms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @Autowired
    private com.lukas.ramonas.cms.DAO.UserRepository UserRepository;     // This means to get the bean called user_tableRepository

    @GetMapping(path="/adminIndex")
    public String showAdminIndex(){
        return "adminIndex";
    }

    @GetMapping(path="/users")
    public String showUsers( Model model){
        var userList = (List<User>) userService.findAll();
        model.addAttribute("userList", userList);
        return "users";
    }
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
@ResponseBody
public String deleteStudent(@PathVariable(name = "id") Long id) {
    userService.delete(id);
    return "users";
}

}