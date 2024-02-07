package com.green.StudentManager.service;

import com.green.StudentManager.vo.StuVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public int insertStu( StuVO stuVO) {
        sqlSession.insert("insertStu",stuVO);

        return 0;

    }


    @Override
    public List<StuVO> selectStuList() {
        List<StuVO> list = sqlSession.selectList("selectStuList");
        return sqlSession.selectList("selectStuList");
    }

    @Override
    public StuVO selectStu(int stuNo) {
        return sqlSession.selectOne("selectStu",stuNo);
    }

    @Override
    public int deleteStu(int stuNo) {
        sqlSession.delete("deleteStu",stuNo);
        return 0;
    }
}
