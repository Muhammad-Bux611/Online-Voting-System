package com.vote.DAO;

import java.util.List;

import com.vote.Entity.Candidate;

public interface CandidateDao {
	
	public boolean registerForVote(Candidate candidate);
	public boolean LoginForVote(Candidate candidate);
	public Candidate getVoterById(int voterId);
	public List<Candidate> getAllVoters();
	public boolean UpdateVoter(Candidate voter);
	public Candidate getVoterByEmail(String email);
	public List<Candidate> seeVoterByCandidateEmail(String candidateEmail);

}
