package com.green.FetchStudent.service;

import com.green.FetchStudent.vo.ClassVO;
import com.green.FetchStudent.vo.StuVO;
import com.green.FetchStudent.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService{
    @Autowired
    SqlSessionTemplate sqlSession;

    @Override
    public List<StuVO> selectStu(StuVO stuVO) {
        return sqlSession.selectList("selectStu",stuVO);
    }

    @Override
    public List<ClassVO> selectClass() {
        return sqlSession.selectList("selectClass");
    }

    @Override
    public StuVO iDetail(StuVO stuVO) {
        return sqlSession.selectOne("iDetail",stuVO);
    }

    @Override
    public StudentVO sDetail(StudentVO studentVO) {
        return sqlSession.selectOne("sDetail", studentVO);
    }

    @Override
    public void insertStu(StudentVO studentVO) {
        sqlSession.insert("insert",studentVO);
    }
}
