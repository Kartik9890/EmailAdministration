//9.56
package emailapp;

import java.util.*;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int emailboxCapacity = 500;
	private int defaultPasswordLength =10;
	private String alternateEmail;
	private String companySuffix = "anycompany.com";

	// Constructor to receive the firstname and lastname
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		System.out.println("email created: " + this.firstName + " " + this.lastName);
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);

		// Call a method that returns the random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is" + this.password);
	
	//Combine elements to generate email
		this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+ companySuffix;
		System.out.println("Your Email Is:"+ email);
	}

	// Ask for the department
	private String setDepartment() {
		System.out.println(
				"Enter the department\n1 for sales\n2 for development\n3 for Accounting\n0 for none\nEnter department code:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);

		}
		return new String(password);
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.emailboxCapacity = capacity;
	}

	//set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	
	//change password
	public void changePassword(String password) {
		this.password =password;
	}
	public int getMailBoxCapacity(){
		return emailboxCapacity;
	}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
public String showInfo() {
	return "DISPLAY NAME: "+ firstName + " "+ lastName +
			"COMPANY EMAIL: "+ email +
			"MAILBOX CAPACITY: "+ emailboxCapacity + "mb";
}

}
