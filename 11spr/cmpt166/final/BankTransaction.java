/** BankTransaction: represents a single deposit/withdrawal record
 * Demo for CMPT166
 * @author Sean Ho
 */

package com.seanho;

import java.text.NumberFormat;
import java.util.Date;

public class BankTransaction {
	private int account;
	private Date date;
	private double amount;
	private boolean type;
	
	// Not needed for exam purposes
	public static final boolean DEPOSIT = false;
	public static final boolean WITHDRAWAL = true;
	
	// Main Constructor
	public BankTransaction(int account, Date date, double amount, boolean type) {
		setAccount( account );
		setDate( date );
		setAmount( amount );
		setType( type );
	}
	
	// Alternate Constructors (with default values)
	public BankTransaction(int account, Date date, double amount) {
		this(account, date, amount, DEPOSIT);
	}
	public BankTransaction(int account, Date date) {
		this(account, date, 0.);
	}
	public BankTransaction(int account) { this(account, new Date()); }
	public BankTransaction() { this(0); }

	// Getters
	public int getAccount() { return account; }
	public Date getDate() { return date; }
	public double getAmount() { return amount; }
	public boolean isDeposit() { return (type == DEPOSIT); }
	public boolean isWithdrawal() { return (type == WITHDRAWAL); }

	// Setters (with input checking, not necessary for exam purposes)
	public void setAccount(int account) {
		this.account = account;
	}
	public void setDate(Date date) {
		if (date != null) this.date = date;
	}
	public void setAmount(double amount) {
		if (amount >= 0.) this.amount = amount;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	
	// Not necessary for exam purposes
	@Override
	public String toString() {
		String str = "";
		if (getDate() != null) str += getDate();
		str += ": Account " + getAccount();
		if (isDeposit()) str += " DEPOSIT  ";
		if (isWithdrawal()) str += " WITHDRAW ";

	    NumberFormat money = NumberFormat.getCurrencyInstance();
	    str += money.format(getAmount());
	    
		return str;
	}

	// Small testbed, not necessary for exam purposes
	public static void main( String args[] ) {
		BankTransaction b = new BankTransaction(1259);
		b.setAmount(200.);
		System.out.println(b);
		b.setType(BankTransaction.WITHDRAWAL);
		System.out.println(b);
	}
}
