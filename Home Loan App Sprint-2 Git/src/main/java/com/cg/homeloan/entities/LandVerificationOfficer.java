package com.cg.homeloan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "land_officer")
public class LandVerificationOfficer extends User {
	
	@Column
	private String officerName;
	@Column
	private String officerContact;

	public LandVerificationOfficer() {
		super();
	}

	public LandVerificationOfficer(int userId,String username,String password, String officerName, String officerContact) {
		super(userId,username,password);
		this.officerName = officerName;
		this.officerContact = officerContact;
	}

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public String getOfficerContact() {
		return officerContact;
	}

	public void setOfficerContact(String officerContact) {
		this.officerContact = officerContact;
	}

	@Override
	public String toString() {
		return "LandVerificationOfficer [officerName=" + officerName + ", officerContact="
				+ officerContact + "]";
	}

}
