package com.example.Payroll;

import java.util.Objects;
import javax.persistence.*;

@Entity
public class Customer {

	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String customerRole;
	private int cardNumber;
	private Membership membership;
	
	Customer () {};

	Customer(String firstName, String lastName, String customerRole, int cardNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerRole = customerRole;
		this.cardNumber = cardNumber;
		this.membership = Membership.STANDARD;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public void setName(String name) {
		String[] parts = name.split(" ");
		this.firstName = parts[0];
		this.lastName = parts[1];
	}

	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String role) {
		this.customerRole = role;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Customer)) 
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(this.id, customer.id) && Objects.equals(this.firstName, customer.firstName) && Objects.equals(this.lastName, customer.lastName)
				&& Objects.equals(this.customerRole, customer.customerRole) && Objects.equals(this.cardNumber, customer.cardNumber) && Objects.equals(this.membership, customer.getMembership());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.firstName, this.lastName, this.customerRole, this.cardNumber, this.membership);
	}
	
	@Override
	public String toString() {
		return "Customer{" + "id=" + this.id + ", first name='" + this.firstName + ", last name='" + this.lastName + '\'' + ", role='" + this.customerRole + '\'' + ", card number='" + this.cardNumber + '\'' + ", membership: " + this.membership + '}';
	}
}
