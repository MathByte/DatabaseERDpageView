package com.sk.groupassignment4.Beans;

import com.sk.groupassignment4.DataBaseConnection.DBUtil;

import java.util.List;

public class Ages {



    private int combined;
    private int female;


    public Ages getAllAges2016() {
        return DBUtil.getAllAges2016();
    }
    public Ages getAllAges2021() {
        return DBUtil.getAllAges2021();
    }


    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    private int male;



}
