package com.company;

/**
 * Created by HP on 30/8/2017.
 */
public class Van extends Vehicle {

    static WestminsterCarParkManager get3 = new WestminsterCarParkManager();

    private double volume;
    private static final String catogaries = "Van";

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Van(String id, String brand, double volume, DateTime entry_details,String catogaries) {
        super(id, brand, entry_details,catogaries);
        this.volume = volume;

        setVolume(volume);
    }

    public static void addVan() {

        String id;
        String brand;
        double volume;
        DateTime entry_details;
        int index;
        boolean validity;
        int slotNo;

        System.out.println("\n=================================");
        System.out.println("            VAN DETAILS            ");
        System.out.println("=================================");

        System.out.print("\nID Plate of the Van  : ");
        id = WestminsterCarParkManager.sc.next();
        System.out.print("\nBrand of the Van : ");
        brand = WestminsterCarParkManager.sc.next();
        System.out.print("\nVan entry details : ");
        entry_details = addEntries();
        System.out.print("\nCargo Volume : ");
        volume = WestminsterCarParkManager.sc.nextDouble();

        Vehicle van = new Van(id, brand, volume, entry_details,catogaries);

        get3.viewEmptyslots();

        System.out.print("\nSlot No   : ");
        slotNo = sc.nextInt();

        validity = false;
        for (int i = 0; i < WestminsterCarParkManager.slots.length; i++) {
            if (slotNo == i) {
                WestminsterCarParkManager.slots[i] = van;
                WestminsterCarParkManager.all_vehicles.add('v');
                WestminsterCarParkManager.lastparked = van;
                i = i + 2;
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
