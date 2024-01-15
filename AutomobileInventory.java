import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String userInput;
        int intInput;
        boolean programRunning = false;
        boolean mainMenu = false;
        boolean innerMenu = false;

        ArrayList<AutomobileClass> inventory = new ArrayList<>();

        // System Interface
        System.out.println("Automobile Inventory System");
        System.out.println();
        System.out.println("\tBegin?");
        System.out.println("\tPress (Y)es or (N)o");

        // Program start
        userInput = scr.nextLine();

        if (userInput.equals("Y") || userInput.equals("y")) {
            programRunning = true;
            System.out.println();
            System.out.println("Welcome");
        } else if (userInput.equals("N") || userInput.equals("n")) {
            programRunning = false;
            System.out.println("Goodbye");
        }

        // System Menu
        while (programRunning == true) {
            if (inventory.isEmpty()) {
                AutomobileClass car = new AutomobileClass();
                System.out.println();
                System.out.println("\tNo data found");
                System.out.println("\tPlease add a vehicle to continue...");
                System.out.println();
                car.addVehicle();
                inventory.add(car);
                System.out.println("Vehicle added successfully");
            }

            if (inventory.size() >= 1) {
                mainMenu = true;
                while (mainMenu == true) {
                    System.out.println();
                    System.out.println("Select an option to continue: ");
                    System.out.println("\t(A)dd new vehicle, (L)ist vehicles, (Q)uit");

                    userInput = scr.nextLine();
                    switch (userInput.toLowerCase()) {
                        case "a":
                            AutomobileClass car = new AutomobileClass();
                            car.addVehicle();
                            inventory.add(car);
                            System.out.println("Vehicle added successfully");
                            break;

                        case "l":
                        	innerMenu = true;
                            while (innerMenu == true) {  // Inner loop for list operations
                                iterationLoop(inventory);
                                if (inventory.size() > 0) {
                                    System.out.println("Select an option or Enter '0' to return to the Main Menu");
                                    System.out.println("\t(C)lear vehicle attribute, (U)pdate vehicle attribute, (R)emove vehicle, (S)ave list to file");
                                    userInput = scr.nextLine();

                                    if (userInput.equalsIgnoreCase("C")) {
                                    	System.out.println();
                                        System.out.println("To clear vehicle attributes please enter vehicle number:");
                                        System.out.println("(Ex. Vehicle 1 = '1')");
                                        System.out.println();

                                        intInput = scr.nextInt();
                                        scr.nextLine();
                                        
                                        if (inventory.size() >= 0) {
                                        	System.out.println("Vehicle " + intInput + " has been selected");
                                        	System.out.println();
                                        	
                                        	for (int i = 0; i == 0; i++) {
                                        		System.out.println(inventory.get(intInput - 1).listInfo());
                                        	}
                                        	
                                    	System.out.println();
                                        inventory.get(intInput - 1).removeVehicleAttribute();
                                        }
                                    } 
                                    if (userInput.equalsIgnoreCase("U")) {
                                    	System.out.println();
                                        System.out.println("To update vehicle attributes please enter vehicle number:");
                                        System.out.println("(Ex. Vehicle 1 = '1')");
                                        System.out.println();

                                        intInput = scr.nextInt();
                                        scr.nextLine();
                                        
                                        if (inventory.size() >= 0) {
                                        	System.out.println("Vehicle " + intInput + " has been selected");
                                        	System.out.println();
                                        	
                                        	for (int i = 0; i == 0; i++) {
                                        		System.out.println(inventory.get(intInput - 1).listInfo());
                                        	}
                                        	
                                        	inventory.get(intInput - 1).updateVehicleAttribute();
                                        }
                                    } 
                                    if (userInput.equalsIgnoreCase("R")) {
                                    	System.out.println("To remove a vehicle please enter vehicle number:");
                                    	System.out.println("(Ex. Vehicle 1 = '1')");
                                    	System.out.println();
                                    	intInput = scr.nextInt();
                                    	
                                    	if (intInput > 0) {
                                    		inventory.remove(intInput - 1);
                                    		System.out.println();
                                    		System.out.println("Vehicle " + intInput + " removed successfully");
                                    		System.out.println("Updated list--");
                                    		System.out.println();
                                    	}
                                    } 
                                    if (userInput.equals("S")) {
                                    	writeToFile(inventory);
                                    }
                                    if (userInput.equals("0")) {
                                        break;  // Exit the inner loop
                                    } 
                                } else if (userInput != "R" || userInput != "U" || userInput != "C") {
                                    System.out.println("Invalid selection, please try again.");
                                } else {
                                    System.out.println("No vehicles in inventory.");
                                    break; // Exit the inner loop if inventory is empty
                                }
                            }
                            break;

                        case "q":
                        	System.out.println("Goodbye");
                        	innerMenu = false;
                        	mainMenu = false;
                            programRunning = false;
                            break;

                        default:
                            System.out.println("Invalid selection, try again");
                            break;
                    }
                }
            }
        }
        scr.close();
    }

    public static void iterationLoop(ArrayList<AutomobileClass> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("\tVehicle " + (i + 1) + ":");
            System.out.println(inventory.get(i).listInfo());
            System.out.println();
        }
    }
    
    private static void writeToFile(ArrayList<AutomobileClass> inventory) {
        String filePath = "C:\\Users\\Public\\Documents.txt";  
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (AutomobileClass car : inventory) {
                writer.write(car.listInfo() + "\n");
            }
            System.out.println("Data successfully written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}
