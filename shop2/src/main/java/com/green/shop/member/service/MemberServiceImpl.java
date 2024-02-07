package com.green.shop.member.service;

import com.green.shop.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    SqlSessionTemplate sqlSession;

    @Override
    public void insertMember(MemberVO memberVO) {
        sqlSession.insert("joinMember",memberVO);
    }

    @Override
    public MemberVO loginForm(MemberVO memberVO) {
        return sqlSession.selectOne("memberSelect", memberVO);
    }

}
