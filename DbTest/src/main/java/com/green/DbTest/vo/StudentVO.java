package com.green.DbTest.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// STUDENT 클래스와 매칭 되는 클래스
@Getter
@Setter
@ToString
public class StudentVO {

    private int stuNo;
    private String stuName;
    private int score;
    private String addr;

}
