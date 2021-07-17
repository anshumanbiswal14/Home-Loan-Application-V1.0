package com.cg.homeloan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {

	@Column
	private String adminName;
	@Column
	private String adminContact;

	public Admin() {
		super();
	}

	public Admin(String adminContact,String adminName,String password,int userId, String userName) {
		super(userId,userName,password);
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [ adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}

}
