package com.green.shop.admin.service;

import com.green.shop.item.vo.ImgVO;
import com.green.shop.item.vo.ItemVO;

import java.util.List;

public interface AdminService {
    void insertItem (ItemVO itemVO);
    //상품 이미지 등록

    int selectNextItemCode();
}
