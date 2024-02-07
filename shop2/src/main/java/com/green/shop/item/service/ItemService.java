package com.green.shop.item.service;

import com.green.shop.item.vo.CategoryVO;
import com.green.shop.item.vo.ItemVO;

import java.util.List;

public interface ItemService {
    List<CategoryVO> select ();

    List<ItemVO> selectItemList();

    ItemVO selectDetail(ItemVO itemVO);

}

