package com.vote.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
public class Admin {

	
	@Column(name = "PS_Number")
	int adminId;
	@Column(name = "CandidateName")
	String name;
	@Id
	String email;
	String password;
	
	String symbol;
	
	String partyName;
	@OneToMany(mappedBy = "umaidwar")
	List<Candidate> voters;
	
	
	public Admin(List<Candidate> voters) {
		super();
		this.voters = voters;
	}
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String name, String symbol, String partyName, List<Candidate> voters) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.symbol = symbol;
		this.partyName = partyName;
		this.voters = voters;
	}
	
	public Admin(int adminId, String name, String email, String password, String symbol, String partyName) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.symbol = symbol;
		this.partyName = partyName;
		
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public List<Candidate> getVoters() {
		return voters;
	}
	public void setVoters(List<Candidate> voters) {
		this.voters = voters;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", symbol=" + symbol + ", partyName=" + partyName + "]";
	}

	
	
	
	
	
	
}
