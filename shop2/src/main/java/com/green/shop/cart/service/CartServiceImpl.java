package com.green.shop.cart.service;

import com.green.shop.cart.vo.CartVO;
import com.green.shop.cart.vo.CartViewVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService{
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void insertCart(CartVO cartVO) {
        sqlSessionTemplate.insert("insertCart", cartVO);
    }

    @Override
    public List<CartViewVO> selectCart(CartVO cartVO) {
        return sqlSessionTemplate.selectList("selectCart", cartVO);
    }

    @Override
    public CartViewVO selectInfo(CartViewVO cartViewVO) {
        return sqlSessionTemplate.selectOne("selectInfo", cartViewVO);
    }

    @Override
    public void updateCnt(CartViewVO cartViewVO) {
        sqlSessionTemplate.update("updateCnt", cartViewVO);

    }

    @Override
    public void deleteCart(CartVO cartVO) {
        sqlSessionTemplate.delete("deleteCart",cartVO);
    }

    @Override
    public void updateCartCnt(CartViewVO cartViewVO) {
        sqlSessionTemplate.update("updateCartCnt",cartViewVO);
    }
}
