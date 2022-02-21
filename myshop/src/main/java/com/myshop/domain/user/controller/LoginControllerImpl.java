package com.myshop.domain.user.controller;

import com.myshop.domain.user.entity.User;
import com.myshop.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginControllerImpl implements LoginController{

    final private UserService userService;

    @Autowired
    LoginControllerImpl(UserService userService){
        this.userService = userService;
    }

    @GetMapping("login")
    public String loginPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) return "login";
        else return "redirect:/home";
    }

    @PostMapping("login.do")
    public String login(@RequestParam String userId,
                        @RequestParam String userPw,
                        RedirectAttributes rttr,
                        HttpServletRequest request){
        StringBuilder msg = new StringBuilder();
        User user = userService.login(userId, userPw, msg);

        if(user == null){
            rttr.addFlashAttribute("msg", msg.toString());
            return "redirect:/login";
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("userId",userId);
            session.setAttribute("user", user);
            return "redirect:/home";
        }
    }

    @GetMapping("logout.do")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("user");
        return "redirect:/home";
    }

}
