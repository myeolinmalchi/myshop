package com.myshop.domain.order.controller;

import com.myshop.domain.order.entity.vCart;
import com.myshop.domain.order.service.OrderService;
import com.myshop.domain.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderControllerImpl {

    private final OrderService orderService;
    private final CategoryService categoryService;

    @Autowired
    public OrderControllerImpl(OrderService orderService, CategoryService categoryService) {
        this.orderService = orderService;
        this.categoryService = categoryService;
    }

    @GetMapping("order")
    public String orderPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("homeCategories") == null){
            session.setAttribute("homeCategories", categoryService.getHomeCategories());
        }

        return "order";
    }

    @PostMapping("order.do")
    public String order(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        List<vCart> products = (List<vCart>)model.getAttribute("products");
        orderService.orderProducts(products);
        return null;
    }
}
 