package com.green.shop.admin.service;

import com.green.shop.buy.vo.BuyVO;
import com.green.shop.item.vo.ImgVO;
import com.green.shop.item.vo.ItemVO;

import java.util.List;

public interface AdminService {

    //상품 등록 + 이미지 등록
    void insertItem(ItemVO itemVO);

    //다음에 들어갈 ITEM_CODE 조회
    int selectNextItemCode();

    // 구매 목록 조회 관리자용
    List<BuyVO> selectBuyList();

    BuyVO selectModal(BuyVO buyVO);


}
