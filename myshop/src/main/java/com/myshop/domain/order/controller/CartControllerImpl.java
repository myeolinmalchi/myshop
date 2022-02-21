package com.myshop.domain.order.controller;

import com.myshop.domain.order.service.CartService;
import com.myshop.domain.order.service.OrderService;
import com.myshop.domain.product.service.CategoryService;
import com.myshop.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartControllerImpl {

    final private CartService cartService;
    final private OrderService orderService;
    final private CategoryService categoryService;

    @Autowired
    public CartControllerImpl(CartService cartService,
                              OrderService orderService,
                              CategoryService categoryService) {
        this.cartService = cartService;
        this.orderService = orderService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String cartPage(HttpServletRequest request,
                           Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("homeCategories") == null){
            session.setAttribute("homeCategories", categoryService.getHomeCategories());
        }

        return "cart";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Map<String, Object> map,
                         HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer cartId = (Integer)map.get("cartId");

        if(cartId!=null){
            session.setAttribute(
                "user",
                cartService.remCart(
                    cartId,
                    (User) session.getAttribute("user")
                )
            );
        }

        return "cart";
    }

    @PostMapping("/update/quantity")
    public String updateQuantity(@RequestBody Map<String, Object> map,
                                 HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer cartId = (Integer)map.get("cartId");
        int quantity = Integer.parseInt((String)map.get("quantity"));

        if(cartId!=null){
            session.setAttribute(
                    "user",
                    cartService.updateQuantity(
                            cartId,
                            quantity,
                            (User) session.getAttribute("user")
                    )
            );
        }

        return "cart";
    }

}
