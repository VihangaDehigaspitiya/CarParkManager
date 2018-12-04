package com.company;

/**
 * Created by HP on 30/8/2017.
 */
public class Car extends Vehicle {

    private int Doors;
    private String Color;
    private static final String catogaries = "Car";

    static WestminsterCarParkManager get2 = new WestminsterCarParkManager();

    public Car(String id, String brand, int doors, String color, DateTime entry_details,String catogaries) {
        super(id, brand, entry_details, catogaries);

        this.Doors = doors;
        this.Color = color;

        setDoors(doors);
        setColor(color);
    }


    public int getDoors() {
        return Doors;
    }

    public void setDoors(int Doors) {
        this.Doors = Doors;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public static void addCar() {

        String id;
        String brand;
        int door;
        String color;
        DateTime entry_datails;
        int index;
        int slotNo;
        boolean validity;

        System.out.println("\n=================================");
        System.out.println("            CAR DETAILS            ");
        System.out.println("=================================");

        System.out.print("\nID Plate of the Car  : ");
        id = WestminsterCarParkManager.sc.next();
        System.out.print("\nBrand of the Car : ");
        brand = WestminsterCarParkManager.sc.next();
        System.out.print("\nCar entry details ");
        entry_datails = addEntries();
        System.out.print("\nNo of Doors : ");
        door = WestminsterCarParkManager.sc.nextInt();
        System.out.print("\nColor of the Car : ");
        color = WestminsterCarParkManager.sc.next();

        Vehicle car = new Car(id, brand, door, color, entry_datails,catogaries);

        get2.viewEmptyslots();

        System.out.print("\nSlot No   : ");
        slotNo = sc.nextInt();
        validity = false;
        for (int i = 0; i < WestminsterCarParkManager.slots.length; i++) {
            if (slotNo == i) {
                WestminsterCarParkManager.slots[i] = car;
                WestminsterCarParkManager.all_vehicles.add('c');
                WestminsterCarParkManager.vehicles_percentage.add(car);
                WestminsterCarParkManager.lastparked = car;
                WestminsterCarParkManager.totcount++;
                i++;
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
