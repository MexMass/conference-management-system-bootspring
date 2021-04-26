package com.lukas.ramonas.cms.Controllers.UserControllers;

import com.lukas.ramonas.cms.Model.Role;
import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Service.IUserService;
import com.lukas.ramonas.cms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Collections;
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
        List<User> userList = userService.findAllByRoles("ROLE_STUDENT");
        userList.addAll(userService.findAllByRoles("ROLE_TEACHER"));
        model.addAttribute("userList", userList);
        return "users";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
    userService.delete(id);
    redirectAttributes.addFlashAttribute("message", "User successfully deleted");
    return "redirect:/admin/users";
}

    @GetMapping(value = "/update/{id}")
    public String updateConfirmed(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
        userService.updateConfirmed(id);
        redirectAttributes.addFlashAttribute("message", "User successfully updated");
        return "redirect:/admin/users";
    }

}