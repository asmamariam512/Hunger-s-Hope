package com.example.windows.foodish;

/**
 * Created by Windows on 07-Oct-17.
 */

public class Donation {
    private String duid;
    private String rname;
    private String date;


    public Donation() {
    }

    public Donation(String duid, String rname, String date) {
        this.duid = duid;
        this.rname = rname;
        this.date = date;
    }

    public String getDuid() {
        return duid;
    }

    public String getDate() {
        return date;
    }

    public String getRname() {
        return rname;
    }

    public void setDuid(String duid) {
        this.duid = duid;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
