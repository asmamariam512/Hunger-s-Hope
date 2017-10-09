package com.example.windows.foodish;

/**
 * Created by Windows on 20-Aug-17.
 */

public class Donor {
    private String dname;
    private String dadd;
    private String dcity;
    private String dphone;
    private String dtype;
    private String donorId;
    private String uid;
    private String road;
    private  String postal;
    private  String district;
    private  String manName;
    private  String manPhone;
    private  String nationalId;
    public Donor(){

    }

    public Donor(String dname, String dadd, String dcity, String dphone, String dtype, String donorId, String uid, String road, String postal, String district, String manName, String manPhone, String nationalId) {
        this.dname = dname;
        this.dadd = dadd;
        this.dcity = dcity;
        this.dphone = dphone;
        this.dtype = dtype;
        this.donorId = donorId;
        this.uid = uid;
        this.road = road;
        this.postal = postal;
        this.district = district;
        this.manName = manName;
        this.manPhone = manPhone;
        this.nationalId = nationalId;
    }

    public String getDname() {
        return dname;
    }

    public String getDadd() {
        return dadd;
    }

    public String getDcity() {
        return dcity;
    }

    public String getDphone() {
        return dphone;
    }

    public String getDtype() {
        return dtype;
    }

    public String getDonorId() {
        return donorId;
    }

    public String getUid() {
        return uid;
    }

    public String getRoad() {
        return road;
    }

    public String getPostal() {
        return postal;
    }

    public String getDistrict() {
        return district;
    }

    public String getManName() {
        return manName;
    }

    public String getManPhone() {
        return manPhone;
    }

    public String getNationalId() {
        return nationalId;
    }
}
