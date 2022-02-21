package com.myshop.domain.product.controller;

import com.myshop.domain.product.service.CategoryService;
import com.myshop.domain.product.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
public class SearchControllerImpl {

    final private SearchService searchService;
    final private CategoryService categoryService;

    @Autowired
    public SearchControllerImpl(SearchService searchService, CategoryService categoryService){
        this.searchService = searchService;
        this.categoryService = categoryService;
    }

    @GetMapping("/search.do")
    public String searchPage(@RequestParam String category,
                             @RequestParam String name,
                             HttpServletRequest request,
                             Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("homeCategories") == null){
            session.setAttribute("homeCategories", categoryService.getHomeCategories());
        }

        model.addAttribute(
                "products",
                searchService.searchWithLimit(name, category, 30).stream()
                        .peek(p -> p.setRating((p.getReviewCount()==0)?
                                0:(int)Math.round((double)p.getRating()/p.getReviewCount())))
                        .collect(Collectors.toList()));

        model.addAttribute("name", name);

        return "search";
    }
}
