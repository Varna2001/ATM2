package smDB;

import java.util.*;

public class CustPg {
	public static void main(String[] args) {
		// Create list of Customers
		List<Cust> customers = new ArrayList();
		customers.add(new Cust(23, "John", 2, 12300));
		customers.add(new Cust(34, "John2", 234, 100));

		// Show Account information
		showAccount(customers);

		boolean authenticated = false;
		Cust currentCustomer = null;

		Scanner scanner = new Scanner(System.in);

		while (!authenticated) {
			System.out.println("Please enter customer ID : ");
			int enteredAccountID = scanner.nextInt();
			for (Cust cs : customers) {
				// Check Account ID
				if (enteredAccountID == cs.getID()) {
					while (!authenticated) {
						System.out.println("Please enter password : ");
						currentCustomer = cs;
						int enteredPassword = scanner.nextInt();
						// Check password
						if (enteredPassword == currentCustomer.getPassword()) {
							currentCustomer = cs;
							authenticated = true;
							break;
						}
						if (!authenticated) {
							System.err.println("Password is incorrect");
						}
					}
				}
			}
			if (!authenticated)
				System.err.println("invalid ID");
		}
		int currentBalance = currentCustomer.getBalance();
		System.out.println("Name: " + currentCustomer.getName());
		System.out.println("Balance: " + currentBalance + " yen");
		authenticated = false;
		while (!authenticated) {
		System.out.println("Wolud you like to withdraw? (Yes/No)");
		String withdrawOrNot = scanner.next();
		// Check withdraw or not
		if (withdrawOrNot.toLowerCase().equals("yes")) {
			authenticated = false;
			while (!authenticated) {
				System.out.println("Please enter withdraw amount : ");
				int enteredAmount = scanner.nextInt();
				// Check withdrawable or not
				if (enteredAmount < currentCustomer.getBalance() && enteredAmount > 0) {
					currentBalance -= enteredAmount;
					System.out.println("Withdraw amount: " + enteredAmount + "yen");
					System.out.println("New balance: " + currentBalance + "yen");
					System.out.println("Thanks for using our Service");
					authenticated = true;
					break;
				} else {
					System.err.println("Invalid Balance!");
				}
			}
		} else if (withdrawOrNot.toLowerCase().equals("no")) {
			System.out.println("Thanks for using our Service");
			authenticated = true;
		}else {
			System.err.println("Invalid input");
		}
		}
		scanner.close();

	}

	// To show formatted account lists
	public static void showAccount(List<Cust> customers) {
		int custno = 1;

		// formatted table header
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("| %-7s | %-7s | %-14s | %-20s | %-16s |%n", "No", "ID", "Name", "passowrd", "Balance");
		System.out.println("--------------------------------------------------------------------------------");

		// Show list of accounts
		for (Cust cs : customers) {
			System.out.printf("| %-7s | %-7s | %-14s | %-20s | %-16s |%n", custno, cs.getID(), cs.getName(),
					cs.getPassword(), cs.getBalance());
			System.out.println("--------------------------------------------------------------------------------");
			custno++;
		}
	}

}
