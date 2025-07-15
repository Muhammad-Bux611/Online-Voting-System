package com.vote.DAO;

import java.util.List;

import com.vote.Entity.Admin;

public interface AdminDao  {

	public boolean registerForElection(Admin admin);
	
	public boolean loginToSeeVoters(Admin admin);
	
	public List<Admin> candidates();
	
	
}
