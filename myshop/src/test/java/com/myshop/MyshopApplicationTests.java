package com.myshop;

import com.myshop.domain.order.entity.Order;
import com.myshop.domain.order.mapper.CartMapper;
import com.myshop.domain.order.service.CartService;
import com.myshop.domain.order.mapper.OrderDetailMapper;
import com.myshop.domain.order.mapper.OrderMapper;
import com.myshop.domain.order.service.OrderService;
import com.myshop.domain.product.entity.Product;
import com.myshop.domain.product.entity.Review;
import com.myshop.domain.product.mapper.*;
import com.myshop.domain.product.service.ReviewService;
import com.myshop.domain.product.service.SearchService;
import com.myshop.domain.user.entity.User;
import com.myshop.domain.user.mapper.UserAddressMapper;
import com.myshop.domain.user.mapper.UserMapper;
import com.myshop.domain.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
@WebAppConfiguration
class MyshopApplicationTests {

    @Autowired UserMapper userMapper;
    @Autowired UserAddressMapper userAddressMapper;
    @Autowired
    UserService userService;

    @Test void userDomainTest(){
//        User user = userMapper.selectUserById("minsuk4820");
//        List<UserAddress> userAddressList = userAddressMapper.selectAddressesByUserId("minsuk4820");
//        User user = new User("rkd2274","382274","강민석","rkd2274@pusan.ac.kr","01022743820");
//        userMapper.insertUser(user);
//        userMapper.deleteUser("rkd2274");
//        System.out.println(userService.login("minsuk4820","1234"));
        /*userService.signup(
                new User(
                        "kkk3311",
                        "kkk3311",
                        "홍길동",
                        "abc@naver.com",
                        "010-3949-3820"
                )
        );*/

        userMapper.update(
                new User(
                        "kkk3311",
                        "1234",
                        "홍홍홍",
                        "aaaa@naver.com",
                        "1234"
                )
        );
    }



    @Autowired ProductMapper productMapper;
    @Autowired ProductOptionMapper productOptionMapper;
    @Autowired ReviewMapper reviewMapper;
    @Autowired QnAMapper qnAMapper;

    @Test void productDomainTest(){
//        Product product = productMapper.selectById(1);
//        List<ProductOption> productOptionList = productOptionMapper.selectById(1);
//
//        Review review = reviewMapper.selectByProductId(1);
//        QnA qna = qnAMapper.selectByProductId(1);
//        System.out.println(product.getName());


        List<Product> product = productMapper.selectByCategory("A2");
        product.forEach(System.out::println);
    }

    @Autowired OrderMapper orderMapper;
    @Autowired OrderDetailMapper orderDetailMapper;
    @Autowired OrderService orderService;

    @Test void orderDomainTest(){
//        Order order = orderMapper.selectById(1);
//        List<Order> orderList = orderMapper.selectByUserId("minsuk4820");
//        OrderDetail orderDetail = orderDetailMapper.selectById(1);
//        List<OrderDetail> orderDetailList = orderDetailMapper.selectByOrderId(1);
        /*List<VProduct> list = orderService.getViewProductsByUserId("minsuk4820");
        list.forEach(System.out::println);*/
        List<Order> list = orderService.getOrderList("minsuk4820");
        list.forEach(System.out::println);
    }

    @Autowired CartMapper cartMapper;
    @Autowired CartService cartService;
    @Autowired

    @Test void cartDomainTest(){
//        cartMapper.update(new Cart("minsuk4820",1,1,1));
//        cartService.addCart(new Cart("minsuk4820",1,10,2));

//        cartService.addQuantity(1);
//        cartService.addQuantity(1);
//        List<VProduct> vProducts = cartService.myvCartList("minsuk4820");
//        System.out.println(vProducts.size());
//        vProducts.forEach(System.out::println);

//        String a = cartMapper.selectCartid(4);
//        System.out.println(a);
//        List<vCart> cart = cartMapper.selectvCartByUserId("rkd2274");

//        orderService.orderProducts(cartService.myCartList("minsuk4820"));
    }

    @Autowired ReviewService reviewService;

    @Test void reviewTest(){
        reviewService.writeReview(new Review(
                12,
                "kkk3311",
                6,
                "테스트",
                "리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트리뷰테스트"
        ));
    }

    @Test
    void patterntest(){
        String pattern = "^[a-zA-Z0-9]*$";
        System.out.println(Pattern.matches(pattern, "minsuk4820"));
        System.out.println(Pattern.matches(pattern, "@@@@@"));
        System.out.println(Pattern.matches(pattern, "!!!4820"));
    }

    @Autowired vCategoryMapper vCategoryMapper;

    @Test
    void vCategoryTest(){
        vCategoryMapper.getAllCategories().forEach(System.out::println);
        System.out.println();
        vCategoryMapper.getChildrens("A1").forEach(System.out::println);
    }

    @Autowired SearchService searchService;
    @Test
    void productTest(){
        System.out.println(searchService.searchWithLimit("스바루", "", 30));

        System.out.println(
                searchService.searchWithLimit("스바루", "", 30).stream()
                    .peek(p -> p.setRating(
                            (int) Math.round((double) p.getRating()/p.getReviewCount())))
                    .findAny()
                    .get());


    }

}
