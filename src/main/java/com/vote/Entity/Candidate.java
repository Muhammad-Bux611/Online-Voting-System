package com.vote.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Voter")
public class Candidate {

	@Id
	int voteId;
	String voterName;
	String voterEmail;
	String voterPassword;
	String voterAddress;
	
	@ManyToOne
	Admin umaidwar;
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int voteId, Admin umaidwar) {
		super();
		this.voteId = voteId;
		this.umaidwar = umaidwar;
	}
	public Candidate(int voteId, String voterName, String voterAddress, Admin umaidwar) {
		super();
		this.voteId = voteId;
		this.voterName = voterName;
		this.voterAddress = voterAddress;
		this.umaidwar = umaidwar;
	}
	
	
	
	public Candidate(String voterEmail, String voterPassword) {
		super();
		this.voterEmail = voterEmail;
		this.voterPassword = voterPassword;
	}
	public Candidate(int voteId, String voterName, String voterEmail, String voterPassword, String voterAddress) {
		super();
		this.voteId = voteId;
		this.voterName = voterName;
		this.voterEmail = voterEmail;
		this.voterPassword = voterPassword;
		this.voterAddress = voterAddress;
	}
	public Candidate(int voteId, String voterName, String voterEmail, String voterPassword, String voterAddress,
			Admin umaidwar) {
		super();
		this.voteId = voteId;
		this.voterName = voterName;
		this.voterEmail = voterEmail;
		this.voterPassword = voterPassword;
		this.voterAddress = voterAddress;
		this.umaidwar = umaidwar;
	}
	
	public String getVoterEmail() {
		return voterEmail;
	}
	public void setVoterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}
	public String getVoterPassword() {
		return voterPassword;
	}
	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public String getVoterAddress() {
		return voterAddress;
	}
	public void setVoterAddress(String voterAddress) {
		this.voterAddress = voterAddress;
	}
	public Admin getUmaidwar() {
		return umaidwar;
	}
	public void setUmaidwar(Admin umaidwar) {
		this.umaidwar = umaidwar;
	}
	@Override
	public String toString() {
		return "Candidate [voteId=" + voteId + ", voterName=" + voterName + ", voterAddress=" + voterAddress
				+ ", umaidwar=" + umaidwar + "]";
	}
	
	
}
