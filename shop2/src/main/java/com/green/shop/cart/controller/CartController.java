package com.green.shop.cart.controller;

import com.green.shop.cart.service.CartService;
import com.green.shop.cart.vo.CartVO;
import com.green.shop.cart.vo.CartViewVO;
import com.green.shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Resource(name="cartService")
    CartService cartService;


    @PostMapping("/insert")
    @ResponseBody
    public void insertCart(CartVO cartVO, HttpSession session, CartViewVO cartViewVO ){
       MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
       cartVO.setMemberId(loginInfo.getMemberId());
       cartViewVO.setMemberId(loginInfo.getMemberId());
       CartViewVO cart = cartService.selectInfo(cartViewVO);
       if(cart == null){
           cartService.insertCart(cartVO);

       }
       else{
           cartService.updateCnt(cartViewVO);
       }



    }

    @GetMapping("/list")
    public String list(CartVO cartVO, Model model, HttpSession session ){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        cartVO.setMemberId(loginInfo.getMemberId());
        List<CartViewVO> list = cartService.selectCart(cartVO);
        model.addAttribute("cartList", list);
        return "content/cart/cart_list";
    }
    @GetMapping("delete")
    public String deleteCart(CartVO cartVO, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        cartVO.setMemberId(loginInfo.getMemberId());
        cartService.deleteCart(cartVO);

        return "redirect:/cart/list";

    }
    @PostMapping("updateCartCnt")
    @ResponseBody
    public void updateCartCnt(CartViewVO cartViewVO, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");

        cartViewVO.setMemberId(loginInfo.getMemberId());

        cartService.updateCartCnt(cartViewVO);






    }




}
