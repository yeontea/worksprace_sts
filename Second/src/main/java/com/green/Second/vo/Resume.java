package com.green.Second.vo;

import java.util.Arrays;

public class Resume {
    private String name;
    private String tel;
    private String school;
    private String schoola;
    private String aa;
    private String[] bb;
    private String[] cc;

    private String intro;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoola() {
        return schoola;
    }

    public void setSchoola(String schoola) {
        this.schoola = schoola;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }



    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String[] getBb() {
        return bb;
    }

    public void setBb(String[] bb) {
        this.bb = bb;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", school='" + school + '\'' +
                ", schoola='" + schoola + '\'' +
                ", aa='" + aa + '\'' +
                ", bb=" + Arrays.toString(bb) +
                ", cc=" + Arrays.toString(cc) +
                ", intro='" + intro + '\'' +
                '}';
    }
}
