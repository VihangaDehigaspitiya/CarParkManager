package com.company;

import java.util.Scanner;

/**
 * Created by HP on 30/8/2017.
 */
public abstract class Vehicle {

    public static Scanner sc = new Scanner(System.in);

    private String Brand;
    private String IDplate;
    private DateTime entries;
    private String catogaries;

    public String getCatogaries() {
        return catogaries;
    }

    public DateTime getEntries() {
        return entries;
    }

    public Vehicle(String id, String brand,DateTime entries,String catogaries) {
        this.IDplate = id;
        this.Brand = brand;
        this.entries = entries;
        this.catogaries = catogaries;
        setIDplate(id);
        setBrand(brand);


    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getIDplate() {
        return IDplate;
    }

    public void setIDplate(String IDplate) {
        this.IDplate = IDplate;
    }

    public static DateTime addEntries() {

        System.out.print("\nDate : ");
        String date = sc.next();

        System.out.print("\nTime : ");
        String time = sc.next();

        DateTime entries = new DateTime(date, time);
        return entries;
    }
}



