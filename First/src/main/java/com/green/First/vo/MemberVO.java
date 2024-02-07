package com.green.First.vo;

import java.util.Arrays;

public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String[] tel;
    private String em;
    private String br;
    private String telA;
    private String lesson;
    private String yesNo;
    private String intro;

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getYesNo() {
        return yesNo;
    }

    public void setYesNo(String yesNo) {
        this.yesNo = yesNo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTelA() {
        return telA;
    }

    public void setTelA(String telA) {
        this.telA = telA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTel() {
        return tel;
    }

    public void setTel(String[] tel) {
        this.tel = tel;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", tel=" + Arrays.toString(tel) +
                ", em='" + em + '\'' +
                ", br='" + br + '\'' +
                ", telA='" + telA + '\'' +
                ", lesson='" + lesson + '\'' +
                ", yesNo='" + yesNo + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
