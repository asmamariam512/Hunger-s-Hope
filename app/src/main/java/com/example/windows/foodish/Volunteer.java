package com.example.windows.foodish;

/**
 * Created by Windows on 20-Aug-17.
 */

public class Volunteer {
    private String vname;
    private String vadd;
    private String vphone;
    private String vemail;
    private String vav;
    private String artistId;

    public Volunteer(){

    }

    public Volunteer( String artistId,String vname, String vadd, String vphone, String vemail, String vav) {
        this.artistId = artistId;
        this.vname = vname;
        this.vadd = vadd;
        this.vphone = vphone;
        this.vemail = vemail;
        this.vav = vav;
    }
    public String getArtistId() {
        return artistId;
    }

    public String getVname() {
        return vname;
    }

    public String getVadd() {
        return vadd;
    }

    public String getVphone() {
        return vphone;
    }

    public String getVemail() {
        return vemail;
    }

    public String getVav() {
        return vav;
    }
}
