package smDB;

public class Cust {
	private int ID;
	private String name;
	private int password;
	private int balance;
	public int getID() {
		return ID;
	}
	public Cust(int ID, String name, int password, int balance) {
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
