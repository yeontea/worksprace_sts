package com.green.shop.item.service;

import com.green.shop.item.vo.CategoryVO;
import com.green.shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
    @Autowired
    SqlSessionTemplate sqlSession;

    @Override
    public List<CategoryVO> select() {
        return sqlSession.selectList("selectItem");
    }

    @Override
    public List<ItemVO> selectItemList() {
        return sqlSession.selectList("selectItemList");
    }

    @Override
    public ItemVO selectDetail(ItemVO itemVO) {

        return sqlSession.selectOne("selectDetail",itemVO);
    }
}
