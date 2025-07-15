package com.vote.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vote.Entity.Admin;
import com.vote.Entity.Candidate;
@Component
public class CandidateDaoImpl implements CandidateDao{
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	@Transactional
	public boolean registerForVote(Candidate candidate) {
		// TODO Auto-generated method stub
		boolean isRegistered = false;
		Candidate insertCandidate  = hibernateTemplate.get(Candidate.class,candidate.getVoteId());
		if (insertCandidate==null) {
//			
		Candidate checkEmailCandidate = getVoterByEmail(candidate.getVoterEmail());
		if (checkEmailCandidate!=null) {
			isRegistered=false;
		}else {
		int canVote =(Integer)hibernateTemplate.save(candidate);
		
		
		if (canVote!=0) {
			isRegistered =true;
		}else {
		
		isRegistered =false;
		}
	}
		}else {
			int canVote =(Integer)hibernateTemplate.save(candidate);
			
			
			if (canVote!=0) {
				isRegistered =true;
			}else {
			
			isRegistered =false;
			}
		}
		return isRegistered;
		
		
//		List<Candidate> voters = getAllVoters();
//		if (voters!=null ) {
//			Candidate isPresent = getVoterById(candidate.getVoteId());
//			if (isPresent==null) {
//			for (Candidate voter : voters) {
//				if ((voter.getVoterEmail().equals(candidate.getVoterEmail()))) {
//					isRegistered=false;
//				}
//			}
//		}else {
//			int inserted =(Integer)hibernateTemplate.save(candidate);
//			if (inserted!=0) {
//				isRegistered=true;
////				return true;
//			}else {
//				isRegistered=false;
////				return false;
//			}
//			
//		}
//			
//		}else {
//			int inserted =(Integer)hibernateTemplate.save(candidate);
//			isRegistered=true;
////			return true;
//		}
//		return isRegistered;
	}
	
	public boolean LoginForVote(Candidate candidate) {
		boolean isLogin = false;
		List<Candidate> voters = getAllVoters();
		if (voters!=null) {
			for (Candidate voter : voters) {
				if (voter.getVoterEmail().equals(candidate.getVoterEmail()) && voter.getVoterPassword().equals(candidate.getVoterPassword())) {
					isLogin= true;
				}
			}
		}
		else {
			isLogin= false;
		}
		return isLogin;
	}


	@Override
	public Candidate getVoterById(int voterId) {
		// TODO Auto-generated method stub
		Candidate voter = hibernateTemplate.get(Candidate.class,voterId);
		return voter;
		
	}


	@Override
	public List<Candidate> getAllVoters() {
		
		// TODO Auto-generated method stub
		
List<Candidate> voters = hibernateTemplate.loadAll(Candidate.class);
		
		return voters;		
	}


	@Override
	@Transactional
	public boolean UpdateVoter(Candidate voter) {
		// TODO Auto-generated method stub
		boolean isVoted = false;
		Candidate voterCandidate = getVoterById(voter.getVoteId());
		if (voterCandidate!=null) {
			hibernateTemplate.delete(voterCandidate);
			int updated=(Integer)hibernateTemplate.save(voter);
			if (updated!=0) {
				isVoted=true;
			}else {
				isVoted= false;
			}
		}
		
		
		return isVoted;
	}


	@Override
	public Candidate getVoterByEmail(String email) {
		// TODO Auto-generated method stub
		
		List<Candidate> voters = getAllVoters();
		if (voters!=null) {
			for (Candidate voter : voters) {
				if (voter.getVoterEmail().equals(email)) {
					return voter;
				}
			}
		}else {
			return null;
		}
		
		return null;
	}


	@Override
	public List<Candidate> seeVoterByCandidateEmail(String candidateEmail) {
		// TODO Auto-generated method stub
		List<Candidate> votedBy = new ArrayList<Candidate>();
		List<Candidate> voters = getAllVoters();
		if (voters!=null) {
//			
			for (Candidate voter : voters) {

				if (voter.getUmaidwar()!=null) {
					
				
				if (voter.getUmaidwar().getEmail().equals(candidateEmail)) {
				votedBy.add(voter);
				}
//				
			}
		}
		}
		else {
			return null;
		}
		
		return votedBy;
	}
	}



