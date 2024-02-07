package com.green.Board2.sevice;

import com.green.Board2.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public int insertMember(MemberVO memberVO) {
        sqlSession.insert("memberMapper.insertMember",memberVO);
        return 0;
    }

    @Override
    public MemberVO login(MemberVO memberVO) {

        return sqlSession.selectOne("memberMapper.login", memberVO);
    }
}
