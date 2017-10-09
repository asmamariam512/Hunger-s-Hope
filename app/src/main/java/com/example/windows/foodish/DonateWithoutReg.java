package com.example.windows.foodish;

/**
 * Created by Windows on 08-Oct-17.
 */

public class DonateWithoutReg {
    String name;
    String loc;
    String contact;

    public DonateWithoutReg() {
    }

    public DonateWithoutReg(String name, String loc, String contact) {
        this.name = name;
        this.loc = loc;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getLoc() {
        return loc;
    }

    public String getContact() {
        return contact;
    }

}
