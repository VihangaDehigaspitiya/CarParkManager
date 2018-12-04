package com.company;

/**
 * Created by HP on 30/8/2017.
 */
public class Motorbike extends Vehicle {

    static WestminsterCarParkManager get3 = new WestminsterCarParkManager();

    private double e_capacity;
    private static final String catogaries = "Motorbike";

    public double getE_capacity() {
        return e_capacity;
    }

    public void setE_capacity(double e_capacity) {
        this.e_capacity = e_capacity;
    }

    public Motorbike(String id, String brand, double e_capacity, DateTime entry_details,String catogaries) {
        super(id, brand, entry_details,catogaries);
        this.e_capacity = e_capacity;

        setE_capacity(e_capacity);
    }

    public static void addMotorbike() {

        String id;
        String brand;
        double e_capacity;
        DateTime entry_datails;
        int index;
        boolean validity;
        int slotNo;

        System.out.println("\n=================================");
        System.out.println("       MOTORBIKE DETAILS            ");
        System.out.println("=================================");

        System.out.print("\nID Plate of the Motorbike  : ");
        id = WestminsterCarParkManager.sc.next();
        System.out.print("\nMotorbike entry details : ");
        entry_datails = addEntries();
        System.out.print("\nBrand of the Motorbike : ");
        brand = WestminsterCarParkManager.sc.next();
        System.out.print("\nEngine Capacity : ");
        e_capacity = WestminsterCarParkManager.sc.nextDouble();

        Vehicle motorbike = new Motorbike(id, brand, e_capacity, entry_datails,catogaries);

        get3.viewEmptyslots();

        System.out.print("\nSlot No   : ");
        slotNo = sc.nextInt();

        validity = false;
        for (int i = 0; i < WestminsterCarParkManager.slots.length; i++) {
            if (slotNo == i) {
                WestminsterCarParkManager.slots[i] = motorbike;
                WestminsterCarParkManager.all_vehicles.add('m');
                WestminsterCarParkManager.lastparked = motorbike;
                i++;
                WestminsterCarParkManager.totcount++;
                validity = false;
                System.out.println("you successfully parked");
                break;

            } else {
                validity = true;
            }
        }


        if (validity == true) {
            System.out.println("\n	    ====================================");
            System.out.println("		*******       Invalid ID       *****");
            System.out.println("		====================================\n");
        }

    }

}
