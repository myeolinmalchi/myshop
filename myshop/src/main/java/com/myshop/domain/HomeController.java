package com.myshop.domain;

import com.myshop.domain.product.service.CategoryService;
import com.myshop.domain.product.service.CategoryServiceImpl;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    CategoryService categoryService;

    @Autowired
    HomeController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping("/home")
    public String goHome(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("homeCategories") == null){
            session.setAttribute("homeCategories", categoryService.getHomeCategories());
        }

        return "home";
    }


}
