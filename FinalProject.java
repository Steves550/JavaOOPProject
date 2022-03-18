
/**
 * This program will display an option list to the user
 * and the user will enter a corresponding number for the
 * option of their choice. The option list will continue to
 * display until the user decides to exit the program.
 * 
 * @author Steven Long 3/6/2022
 */

import java.util.Scanner;

// Create class for storing customer data.
class Customers {

	// Three class attributes of name, id, sales.
	public String name;
	public int id;
	public double sales;

	// Customers constructor.
	public Customers(String name, int id, double sales) {
		this.name = name;
		this.id = id;
		this.sales = sales;
	}

	// Getter methods for name, id, and sales.
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getSales() {
		return sales;
	}

	// Setter methods for name, id, and sales.
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	// toString method for returning a string containing the 3 customer attributes.
	@Override
	public String toString() {
		return "Customer name: " + name + " ID: " + id + " Total sales: " + sales;
	}

} // End Customers class

// FinalProject class will display the program.
public class FinalProject {

	// Activate scanners for integer, string, and double types.
	static Scanner scanInt = new Scanner(System.in);
	static Scanner scanStr = new Scanner(System.in);
	static Scanner scanDub = new Scanner(System.in);

	// Set integer variable for total amount of customers to 0.
	public static int totalCustomers = 0;

	// Customers array will hold up to a max value of 100;
	static Customers[] customerData = new Customers[100];

	// Method for retrieving the a highest and lowest sale range.
	public static void salesRange() {

		// Prompt user for highest and lowest sale to determine range.
		System.out.print("Enter the lowest sale: ");
		double lowSale = scanDub.nextDouble(); // lowSale = users inputed double value for lowest.
		System.out.print("Enter the highest sale: ");
		double highSale = scanDub.nextDouble(); // highSale = users inputed double value for highest.

		/*
		 * for loop will loop through totalCustomers array length to determine which
		 * customer has the lowest and highest value stored in sales for entered range.
		 */
		for (int i = 0; i < totalCustomers; i++) {
			if (customerData[i].getSales() <= highSale && customerData[i].getSales() >= lowSale) {
				System.out.println(customerData[i].toString());
			}
		}
	}

	// Method to pull data for a specific customer.
	public static void retrieveData() {

		// Prompt for an existing customers Id.
		System.out.print("Enter a customers Id: ");
		int enteredId = scanInt.nextInt(); // enteredId = user input integer value.

		/*
		 * for loop to loop through totalCustomers array to determine if any stored
		 * customer Id matches the Id entered from the user. toString() is then called
		 * for displaying the matched customers data.
		 */
		for (int i = 0; i < totalCustomers; i++) {

			if (customerData[i].getId() == enteredId) {
				System.out.println(customerData[i].toString());
			}

		}

	}

	// Method to display all stored customers data in array.
	public static void displayCustomers() {

		// for loop will iterate over all stored customers and display their data.
		for (int i = 0; i < totalCustomers; i++) {
			System.out.print(customerData[i].toString());
			System.out.println("");
		}
	}

	// Method to add a new customer.
	public static void addCustomer() {

		// Prompt user for customer name, 5 digit id, and total sales.
		System.out.print("Enter name of customer: ");
		String name = scanStr.nextLine(); // name = inputed String value.
		System.out.print("Enter 5 digit customer id (12345): ");
		int id = scanInt.nextInt(); // id = inputed integer value.
		if (String.valueOf(id).length() > 5) {
			System.out.print("Please enter a 5 digit number for customer id.");
			System.out.println("");
		}
		System.out.print("Enter customer sales: ");
		double sales = scanDub.nextDouble(); // sales = inputed double value.

		/*
		 * customerData array will store new Customer object for each added customer.
		 * Each iteration will also increment the value of totalCustomers by +1.
		 */
		customerData[totalCustomers] = new Customers(name, id, sales);
		totalCustomers++;

	}

	// Method to retrieve the total amount of customers to be entered.
	public static void customersData() {

		// Prompt for the total number of customers to be entered.
		System.out.print("Enter how many customers to load?: ");
		int numCustomers = scanInt.nextInt(); // numCustomers = inputed integer value.

		/*
		 * The while-loop will run only if the value in numCustomers is not 0. Each
		 * iteration will decrement the count inside numCustomers until the value is 0.
		 * Once each added customer iteration is complete the count will be 0 and loop
		 * stops.
		 */
		while (numCustomers != 0) {

			System.out.println("");

			// Prompt for customer name, id, and sales
			System.out.print("Enter name of customer: ");
			String name = scanStr.nextLine(); // name = inputed String value.
			System.out.print("Enter 5 digit customer id (12345): ");
			int id = scanInt.nextInt(); // id = inputed integer value.
			if (String.valueOf(id).length() > 5) {
				System.out.print("Please enter a 5 digit number for customer id.");
				System.out.println("");
			}
			System.out.print("Enter customer sales: ");
			double sales = scanDub.nextDouble(); // sales = inputed double value.

			/*
			 * customerData array will store new Customer object for each added customer.
			 * Each iteration will also increment the value of totalCustomers by +1 while
			 * also decrementing the count stored inside numCustomers by -1.
			 */
			customerData[totalCustomers] = new Customers(name, id, sales);
			totalCustomers++;
			numCustomers--;
		}

	}

	// Method to display the option menu to the user.
	public static void menuDisplay() {

		System.out.println("Enter a number to display customer data.");
		System.out.println("1. Load customers data. ");
		System.out.println("2. Add a new customer.");
		System.out.println("3. Display all customers data.");
		System.out.println("4. Pull data for a specific customer.");
		System.out.println("5. Pull data for customers within a range of total sales.");
		System.out.println("6. Exit.");

	}

	// Main Method.
	public static void main(String[] args) {

		/*
		 * while-loop for continuous display of menuDisplay method. until option 6 is
		 * selected.
		 */
		while (true) {

			// Call menuDisplay method to display menu list.
			menuDisplay();
			System.out.println("");

			// Prompt user for which option they want to select.
			System.out.print("Enter Number: ");
			int choice = scanInt.nextInt(); // choice = users integer value.
			System.out.println("");

			/*
			 * If statement will check the integer value inside choice. Depending on what #
			 * value is inputed from the user, a corresponding method will be called. option
			 * 6 will break and stop the while-loop. else will notify the user that they
			 * have entered an invalid input.
			 */
			if (choice == 1) {
				customersData();
				System.out.println("");
			} else if (choice == 2) {
				addCustomer();
				System.out.println("");
			} else if (choice == 3) {
				displayCustomers();
				System.out.println("");
			} else if (choice == 4) {
				retrieveData();
				System.out.println("");
			} else if (choice == 5) {
				salesRange();
				System.out.println("");
			} else if (choice == 6) {
				System.out.print("This program will now end. Thank you!");
				break;
			} else
				System.out.print("Please enter a number between 1-6.");

		}

	} // End main method

} // End FinalProject class
