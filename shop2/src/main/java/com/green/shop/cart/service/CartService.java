package com.green.shop.cart.service;

import com.green.shop.cart.vo.CartVO;
import com.green.shop.cart.vo.CartViewVO;
import jakarta.websocket.Session;

import java.util.List;

public interface CartService {
    void insertCart(CartVO cartVO);
    List<CartViewVO> selectCart(CartVO cartVO);
    CartViewVO selectInfo(CartViewVO cartViewVO);
    void updateCnt(CartViewVO cartViewVO);
    void deleteCart(CartVO cartVO);
    void updateCartCnt(CartViewVO cartViewVO);
}
