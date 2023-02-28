package com.sk.groupassignment4.Module;






public class GeoGraphicArea {

    private int geoGraphicAreaId;
    private int code;
    private int level;
    private String name;
    private int alternativeCode;


    public int getGeoGraphicAreaId() {
        return geoGraphicAreaId;
    }

    public void setGeoGraphicAreaId(int id) {
        this.geoGraphicAreaId = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlternativeCode() {
        return alternativeCode;
    }

    public void setAlternativeCode(int alternativeCode) {
        this.alternativeCode = alternativeCode;
    }
}