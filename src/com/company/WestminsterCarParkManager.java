package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by HP on 30/8/2017.
 */
public class WestminsterCarParkManager implements CarParkManager {


    private String parkornot;

    public static Scanner sc = new Scanner(System.in);

    public static int totcount = 0;

    public static Vehicle lastparked = null;

    public static Vehicle[] slots = new Vehicle[20];

    public static ArrayList<Character> all_vehicles = new ArrayList<Character>();

    public static ArrayList<Vehicle> vehicles_percentage = new ArrayList<>();

    public static ArrayList<Vehicle> list_vehicle = new ArrayList<>();


    public String getParkornot() {

        for (int i = 0; i < slots.length; i++) {
            //slotsIndex++;
            if (slots[i] != null) {
                System.out.println(i + "                " + "Parked");
            } else {
                System.out.println(i + "                " + "Slot is free");
            }

        }
        return parkornot;
    }

    public void setParkornot(String parkornot) {

        this.parkornot = parkornot;
    }


    @Override
    public void viewParkedvehicles() {
        System.out.println("\n==============================================================================================");
        System.out.println("                                    PARKED VEHICLE LIST           ");
        System.out.println("==============================================================================================");
        System.out.println("|\tBrand   |\t\t|\tParking Date   |\t\t|\tParking Time   |\t\t|\tVehicle ID   |");
        System.out.println("==============================================================================================");


        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null) {

                System.out.println("\n\t" + slots[i].getBrand() + "\t\t\t\t\t" + slots[i].getEntries().getDate() + "\t\t\t\t\t\t\t" + slots[i].getEntries().getTime() + "\t\t\t\t\t\t\t" + slots[i].getIDplate());

            } else {
                System.out.println("Empty Slot");
            }


            System.out.println("\n==============================================================================================");
        }
    }

    @Override
    public void viewEmptyslots() {

        System.out.println("\n=================================");
        System.out.println("   SLOT NO   " + "    PARKED OR NOT   ");
        System.out.println("=================================");

        System.out.println(getParkornot());

    }

    @Override
    public void deleteVehicle() {
        String id;
        String depTime;
        String depDate;
        String catogary;

        System.out.println("Enter ID : ");
        id = sc.next();
        System.out.println("Depature Date(yy:mm:dd) :");
        depDate = sc.next();
        System.out.println("Depature TIme(hh:mm) :");
        depTime = sc.next();

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null) {
                if (id.equals(slots[i].getIDplate())) {

                    slots[i].getEntries().setDepature_time(depTime);
                    slots[i].getEntries().setDepature_date(depDate);
                    catogary = slots[i].getCatogaries();
                    list_vehicle.add(slots[i]);
                    slots[i] = null;

                    System.out.println(catogary + " is left");

                }


            }
        }
    }

    @Override
    public void carPrecentage() {

        int noCars = 0;
        double car_percentage;

        if (WestminsterCarParkManager.all_vehicles.isEmpty()) {
            System.out.println("");
        } else {
            for (int i = 0; i < WestminsterCarParkManager.all_vehicles.size(); i++) {
                if (all_vehicles.get(i).equals('c')) {
                    noCars++;
                    //totcount++;
                }
            }
            car_percentage = Math.round(((double) noCars / totcount) * 100);
            System.out.println(car_percentage);
        }
    }

    @Override
    public void vanPrecentage() {

        int noVans = 0;
        double van_percentage;

        if (WestminsterCarParkManager.all_vehicles.isEmpty()) {
            System.out.println("");
        } else {
            for (int i = 0; i < WestminsterCarParkManager.all_vehicles.size(); i++) {
                if (all_vehicles.get(i).equals('v')) {
                    noVans++;
                    //totcount++;
                }
            }
            van_percentage = Math.round(((double) noVans / totcount) * 100);
            System.out.println(van_percentage);
        }
    }

    @Override
    public void motorbikePrecentage() {

        int noMotorbike = 0;
        double motorbike_percentage;

        if (WestminsterCarParkManager.all_vehicles.isEmpty()) {
            System.out.println("NO slots");
        } else {
            for (int i = 0; i < all_vehicles.size(); i++) {
                if (all_vehicles.get(i).equals('m')) {
                    noMotorbike++;
                   // totcount++;
                }
            }
            motorbike_percentage = Math.round(((double) noMotorbike / totcount) * 100);
            System.out.println(motorbike_percentage);
        }
    }


    @Override
    public void lastVehicle() {

        System.out.println("Vehicle ID     : " + lastparked.getIDplate());
        System.out.println("/nVehicle Type : " + lastparked.getCatogaries());
        System.out.println("/Entry Date    : " + lastparked.getEntries().getDate());
        System.out.println("/Entry Time    : " + lastparked.getEntries().getTime());
    }

    @Override
    public void parkingCharges() {

        int time_duration;
        int price = 0;

        for (Vehicle v : list_vehicle) {
            time_duration = (int) calDuration(v);

            if (time_duration <= 3) {
                if (time_duration == 0) {
                    price = 3;
                } else {
                    price = 3 * time_duration;
                }
            } else if (time_duration > 3) {
                price = 9 + (time_duration - 3);
            }

            System.out.println(v.getCatogaries() +  " ID " + v.getIDplate() + " is charged " + price);
        }
    }

    public static double calDuration(Vehicle v) {
        double time_duration;
        int inday;
        int outday;
        double intime;
        double outtime;

        inday = Integer.parseInt(v.getEntries().getDate().substring(3, 5)) * 24;
        outday = Integer.parseInt(v.getEntries().getDepature_date()) * 24;

        intime = conHours(v.getEntries().getTime()) + inday;
        outtime = conHours(v.getEntries().getDepature_time()) + outday;

        time_duration = outtime - intime;

        return time_duration;
    }

    public static double conHours(String t) {
        int hours;
        int minutes;
        double hourtime;

        hours = Integer.parseInt(t.substring(0, 2));
        minutes = Integer.parseInt(t.substring(2, 4));

        hourtime = hours + (double) minutes / 60;

        return hourtime;
    }

    public static String longestParked() {

        double longest_duration = 0;
        double time_duration;
        Vehicle longest_park;
        String result;

        longest_park = list_vehicle.get(0);

        for (Vehicle v : list_vehicle) {
            time_duration = calDuration(v);

            if (time_duration > longest_duration) {
                longest_duration = time_duration;
                longest_park = v;
            }
        }

        result = "Vehicle ID   : " + longest_park.getIDplate() +
                "Vehicle Type :  " + longest_park.getCatogaries() +
                "Entry Time :  " + longest_park.getEntries().getTime() +
                "Entry DAte :  " + longest_park.getEntries().getDate();

        return result;
    }

}
