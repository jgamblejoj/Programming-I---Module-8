import java.util.Scanner;
import java.util.Random;

public class AutomobileClass {
	// Scanner object for user input
	Scanner scr = new Scanner(System.in);
	
	// Random object for stock ID number generation
	Random rand = new Random();
	
	// Attributes
	private int year;
	private String make;
	private String model;
	private int mileage;
	private String stockID;
	
	private int msrp;
	private boolean discount;
	private int discountAmount;
	private int sellingPrice;
	
	private String exteriorColor;
	private String interiorColor;
	private boolean leatherInterior;
	private boolean availability;
	
	// Default Constructor
	public AutomobileClass() {
		year = 2021;
		make = "Honda";
		model = "CR-V EX";
		mileage = 25000;
		stockID = "a123";
		
		msrp = 28000;
		discount = true;
		discountAmount = 5000;
		sellingPrice = 23000;
		
		exteriorColor = "White";
		interiorColor = "Black";
		leatherInterior = false;
		availability = true;
	}
	
	// Parameterized Constructor
	public AutomobileClass(int year, String make, String model, int mileage, String stockID,
							int msrp, boolean discount, int discountAmount, int sellingPrice, 
							String exteriorColor, String interiorColor, boolean leatherInterior, 
							boolean availability) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.stockID = stockID;
		
		this.msrp = msrp;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.sellingPrice = sellingPrice;
		
		this.exteriorColor = exteriorColor;
		this.interiorColor = interiorColor;
		this.leatherInterior = leatherInterior;
		this.availability = availability;
	}
	
	// Methods
	
	// Add New Vehicles
	public void addVehicle() {
		System.out.println("Enter vehicle year: ");
		System.out.println("(Use a 4-digit format)");
		year = scr.nextInt();
		scr.nextLine();
		
		System.out.println("Enter vehicle make: ");
		make = scr.nextLine();
		
		System.out.println("Enter vehicle model: ");
		model = scr.nextLine();
		
		System.out.println("Enter vehicle mileage: ");
		mileage = scr.nextInt();
		scr.nextLine();
		
		// Option to generate or manually enter stock ID number
		System.out.println("Generate stock ID number?");
		System.out.println("(Press (Y)es or (N)o)");
		String userInput = scr.nextLine();
		
		if (userInput.equalsIgnoreCase("y")) {
			String alpha = "abcdefghijklmnopqrstuvwxyz";
			StringBuilder gen = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				int idNum = rand.nextInt(9999);
				int index = rand.nextInt(alpha.length());
				char randomChar = alpha.charAt(index);
				gen.append(randomChar);
				String idLet = gen.toString();
				stockID = idLet + idNum;
			}
			System.out.println("Stock ID generated: " + stockID);
		} 
		
		if (userInput.equalsIgnoreCase("n")) {
			System.out.println("Enter stock ID number:");
			System.out.println("(Use a 3-letter and 4-digit format, ex. abc1234)");
			stockID = scr.nextLine();
		}
		
		System.out.println("Enter vehicle msrp: ");
		msrp = scr.nextInt();
		scr.nextLine();
		
		System.out.println("Is the vehicle discounted?");
		System.out.println("(Enter 'true' for yes or 'false' for no)");
		discount = scr.nextBoolean();
		scr.nextLine();
		
		System.out.println("Enter vehicle discount amount: ");
		System.out.println("(If no discount, enter 0)");
		discountAmount = scr.nextInt();
		scr.nextLine();
		
		System.out.println("Enter vehicle selling price: ");
		sellingPrice = scr.nextInt();
		scr.nextLine();
		
		System.out.println("Enter vehicle exterior color: ");
		exteriorColor = scr.nextLine();
		
		System.out.println("Enter vehicle interior color: ");
		interiorColor = scr.nextLine();
		
		System.out.println("Does the vehicle have a leather interior? ");
		System.out.println("(Enter 'true' for yes or 'false' for no)");
		leatherInterior = scr.nextBoolean();
		scr.nextLine();
		
		System.out.println("Is the vehicle available? ");
		System.out.println("(Enter 'true' for yes or 'false' for no)");
		availability = scr.nextBoolean();
		scr.nextLine();
	}
	
	// List Vehicle Info
	public String listInfo() {
		return "\tYear: " + year + ", Make: " + make + ", Model: " + model + ", Mileage: " + mileage + ", Stock ID: " + stockID + "\n" +
				"\tMSRP: " + msrp + ", Discount: " + discount + ", Discount Amount: " + discountAmount + ", Selling Price: " + sellingPrice + "\n" +
				"\tExterior color: " + exteriorColor + ", Interior color: " + interiorColor + ", Leather interior: " + leatherInterior + ", Availability: " + availability;
	}
	
	// Clear Vehicle Attribute
	public void removeVehicleAttribute() {
		System.out.println();
		System.out.println("\tEnter attribute name to clear");
		System.out.println("\t(Ex. enter 'make' to clear the Make attribute or 'stock id' to clear the Stock ID attribute)");
		
		String userInput = scr.nextLine();
		
		switch (userInput.toLowerCase()) {
			case "year":
				year = -1;
				System.out.println("Vehicle year has been cleared");
				System.out.println("Updated list--");
				break;
			case "make":
				make = null;
				System.out.println("Vehicle make has been cleared");
				System.out.println("Updated list--");
				break;
			case "model":
				model = null;
				System.out.println("Vehicle model has been cleared");
				System.out.println("Updated list--");
				break;
			case "mileage":
				mileage = -1;
				System.out.println("Vehicle mileage has been cleared");
				System.out.println("Updated list--");
				break;
			case "stock id":
				stockID = null;
				System.out.println("Vehicle stock ID has been cleared");
				System.out.println("Updated list--");
				break;
			case "msrp":
				msrp = -1;
				System.out.println("Vehicle msrp has been cleared");
				System.out.println("Updated list--");
				break;
			case "discount":
				discount = false;
				System.out.println("Vehicle discount has been set to false");
				System.out.println("Updated list--");
				break;
			case "discount amount":
				discountAmount = -1;
				System.out.println("Vehicle discount amount has been cleared");
				System.out.println("Updated list--");
				break;
			case "selling price":
				sellingPrice = -1;
				System.out.println("Vehicle selling price has been cleared");
				System.out.println("Updated list--");
				break;
			case "exterior color":
				exteriorColor = null;
				System.out.println("Vehicle exterior color has been cleared");
				System.out.println("Updated list--");
				break;
			case "interior color":
				interiorColor = null;
				System.out.println("Vehicle interior color has been cleared");
				System.out.println("Updated list--");
				break;
			case "leather interior":
				leatherInterior = false;
				System.out.println("Vehicle leather interior has been set to false");
				System.out.println("Updated list--");
				break;
			case "availability":
				availability = false;
				System.out.println("Vehicle availability has been set to false");
				System.out.println("Updated list--");
				break;
			default:
				System.out.println("Error, try again");
				break;				
		}
		
	}
	
	// Update Vehicle
	public void updateVehicleAttribute() {
		System.out.println();
		System.out.println("\tEnter attribute name to update");
		System.out.println("\t(Ex. enter 'make' to update the Make attribute or 'stock id' to update the Stock ID attribute)");
		
		String userInput = scr.nextLine();
		
		if (userInput.equals("year")) {
			System.out.println();
			System.out.println("Enter new value:");
			int updatedValue = scr.nextInt();
			year = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle year has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("make")) {
			System.out.println();
			System.out.println("Enter new value:");
			String updatedValue = scr.nextLine();
			make = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle make has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("model")) {
			System.out.println();
			System.out.println("Enter new value:");
			String updatedValue = scr.nextLine();
			model = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle model has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("mileage")) {
			System.out.println();
			System.out.println("Enter new value:");
			int updatedValue = scr.nextInt();
			mileage = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle mileage has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("stock id")) {
			System.out.println();
			System.out.println("Enter new value:");
			String updatedValue = scr.nextLine();
			stockID = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle stock ID has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("msrp")) {
			System.out.println();
			System.out.println("Enter new value:");
			int updatedValue = scr.nextInt();
			msrp = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle msrp has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("discount")) {
			System.out.println();
			System.out.println("Enter new value:");
			boolean updatedValue = scr.nextBoolean();
			discount = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle discount has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("discountAmount")) {
			System.out.println();
			System.out.println("Enter new value:");
			int updatedValue = scr.nextInt();
			discountAmount = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle discount amount has been updated");
			System.out.println("Updated list--");
			System.out.println();
		}
		
		if (userInput.equals("selling price")) {
			System.out.println();
			System.out.println("Enter new value:");
			int updatedValue = scr.nextInt();
			sellingPrice = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle selling price has been updated");
			System.out.println("Updated list--");
			System.out.println();
		}
		
		if (userInput.equals("exterior color")) {
			System.out.println();
			System.out.println("Enter new value:");
			String updatedValue = scr.nextLine();
			exteriorColor = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle exterior color has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("interior color")) {
			System.out.println();
			System.out.println("Enter new value:");
			String updatedValue = scr.nextLine();
			interiorColor = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle interior color has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("leather interior")) {
			System.out.println();
			System.out.println("Enter new value:");
			boolean updatedValue = scr.nextBoolean();
			leatherInterior = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle leather interior has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		
		if (userInput.equals("availability")) {
			System.out.println();
			System.out.println("Enter new value:");
			boolean updatedValue = scr.nextBoolean();
			availability = updatedValue;
			
			System.out.println();
			System.out.println("Vehicle availability has been updated");
			System.out.println("Updated list--");
			System.out.println();
		} 
		 			
		
	}
	
}