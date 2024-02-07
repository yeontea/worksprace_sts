package com.green.shop.admin.service;

import com.green.shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    SqlSessionTemplate session;

    @Override
    @Transactional(rollbackFor = Exception.class)
    // 메소드 내부의 쿼리 실행은  모든 쿼리 성공 시 커밋!
    // 쿼리 중 하나라도 실패 시 롤백!
    public void insertItem(ItemVO itemVO) {
        session.insert("insertItem",itemVO);
        session.insert("insertImgs", itemVO);
    }



    @Override
    public int selectNextItemCode() {
        return session.selectOne("selectNextItemCode");
    }

}
