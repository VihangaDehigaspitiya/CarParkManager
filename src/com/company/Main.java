package com.company;

import java.util.Scanner;

public class Main {

    //Creating object in WestministerCarParkManager
    static WestminsterCarParkManager get = new WestminsterCarParkManager();

    //Making scanner as constant
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        functionMenu();

    }


    //printing the main menu
    public static void printMenu() {

        // Print main menu
        System.out.println(
                "		        =============================================================================================\n"
                        + "				|				                 Select one of the given options	  	            		 |\n"
                        + "		        =============================================================================================\n"
                        + "				|  Enter V to Add a vehicle         	    		     	                                 |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter D to Delete a vehicle                                                               |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VP to View parked vehicles         			                                     |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VC to View parking percentage of cars        	   					                 |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VV to View parking percentage of vans         	                                     |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VB to View parking percentage of motorbikes         	                             |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VT to View the vehicle that is parked for the longest time                          |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VL to View the last vehicle that was parked    			                         |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter VM to View the parking charges        	   					                         |\n"
                        + "				---------------------------------------------------------------------------------------------\n"
                        + "				|  Enter E to Exit       	                                                                 |\n"
                        + "				---------------------------------------------------------------------------------------------\n");

    }

    //printing the sub menu
    public static void printsubMenu() {
        System.out.println("\n=================================");
        System.out.println("           VEHICLE TYPES           ");
        System.out.println("=================================");
        System.out.println("|  Enter C to Add a car         |");
        System.out.println("---------------------------------");
        System.out.println("|  Enter V to Add a van         |");
        System.out.println("---------------------------------");
        System.out.println("|  Enter M to Add a motorbike   |");
        System.out.println("---------------------------------");
    }

    //Calling the methods in main menu
    public static void functionMenu() {

        String choose = "";


        //Getting the user input
        boolean breakloop = false;
        do {

            printMenu();

            System.out.print("Enter Option : ");
            choose = sc.next();
            switch (choose) {
                case "V":
                    functionSubmenu();
                    break;

                case "D":
                    get.deleteVehicle();
                    break;

                case "VP":
                    get.viewParkedvehicles();
                    break;

                case "VC":
                    get.carPrecentage();
                    break;

                case "VV":
                    get.vanPrecentage();
                    break;

                case "VB":
                    get.motorbikePrecentage();
                    break;

                case "VT":
                    System.out.println(WestminsterCarParkManager.longestParked());
                    break;

                case "VL":
                    get.lastVehicle();
                    break;

                case "VM":
                    get.parkingCharges();
                    break;

                case "E":
                    System.exit(1);
                    break;

                default:
                    System.out.println("\n INVALID INPUT !!!!");
                    System.out.print("\nPlease enter a valid input : ");
                    choose = sc.next();

            }

        } while (true);
    }

    //calling the methods in sub menu
    public static void functionSubmenu() {

        String select = "";

        printsubMenu();

        System.out.print("Enter Option : ");
        select = sc.next();
        switch (select) {
            case "C":
                Car.addCar();
                break;

            case "V":
                Van.addVan();
                break;

            case "M":
                Motorbike.addMotorbike();
                break;

            default:
                System.out.println("\n INVALID INPUT !!!!");
                System.out.print("\nPlease enter a valid input : ");
                select = sc.next();
        }

    }
}
