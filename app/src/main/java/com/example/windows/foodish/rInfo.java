package com.example.windows.foodish;

/**
 * Created by Windows on 21-Aug-17.
 */

public class rInfo {

    private String rname;
    private String radd;
    private String rpeople;
    private String rphone;
    private String rtype;
   public String receiverId;
    public String uid;
    public String duid;
    public String manPhone;
    public  String nationalId;

    public rInfo(){

    }

    public rInfo(String rname, String radd, String rpeople, String rphone, String receiverId, String rtype,String uid,String duid,String manPhone,String nationalId) {
        this.rname = rname;
        this.radd = radd;
        this.rpeople = rpeople;
        this.rphone = rphone;
        this.receiverId = receiverId;
        this.rtype = rtype;
        this.uid=uid;
        this.duid=duid;
        this.manPhone=manPhone;
        this.nationalId=nationalId;
    }

    public String getRname() {
        return rname;
    }

    public String getRadd() {
        return radd;
    }

    public String getRpeople() {
        return rpeople;
    }

    public String getRphone() {
        return rphone;
    }

    public String getRtype() {
        return rtype;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getUid() {
        return uid;
    }

    public String getDuid() {
        return duid;
    }

    public void setDuid(String duid) {
        this.duid = duid;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setRadd(String radd) {
        this.radd = radd;
    }

    public void setRpeople(String rpeople) {
        this.rpeople = rpeople;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getManPhone() {
        return manPhone;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setManPhone(String manPhone) {
        this.manPhone = manPhone;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
