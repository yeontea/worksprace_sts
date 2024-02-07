package com.green.FetchStudent.service;

import com.green.FetchStudent.vo.ClassVO;
import com.green.FetchStudent.vo.StuVO;
import com.green.FetchStudent.vo.StudentVO;

import java.util.List;

public interface StuService {
    List<StuVO>selectStu(StuVO stuVO);
    List<ClassVO>selectClass();
    StuVO iDetail(StuVO stuVO);
    StudentVO sDetail(StudentVO studentVO);
    void insertStu(StudentVO studentVO);


}
