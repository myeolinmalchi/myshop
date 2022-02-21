package com.myshop.domain.user.controller;

import com.myshop.domain.user.entity.User;
import com.myshop.domain.user.entity.UserValidator;
import com.myshop.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class RegisterControllerImpl {

    final private UserService userService;

    @Autowired
    RegisterControllerImpl(UserService userService){
        this.userService = userService;
    }

    @GetMapping("register")
    public String registerPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        if(userId == null) return "register";
        else return "redirect:/home";
    }

    @PostMapping("register.do")
    public String register(@RequestParam Map<String, String> param){
        userService.register(new User(
                param.get("userId"),
                param.get("userPw"),
                param.get("name"),
                param.get("email"),
                param.get("phonenumber")
        ));
        return "redirect:/home";
    }

    @ResponseBody
    @PostMapping("register/valid/{type}")
    public Map<String, Object> valid(@RequestBody Map<String, Object> map,
                                     @PathVariable("type") String type){
        String value = map.get("value").toString();
        System.out.println(value);

        return new HashMap<>(){{
            put("msg", UserValidator.valueOf(type.toUpperCase()).test(value));
        }};
    }
}
