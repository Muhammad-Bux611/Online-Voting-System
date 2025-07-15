package com.vote.OnlineVotiongSystem;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vote.Config.Config;
import com.vote.DAO.AdminDao;
import com.vote.DAO.AdminDaoImpl;
import com.vote.DAO.CandidateDao;
import com.vote.DAO.CandidateDaoImpl;
import com.vote.Entity.Admin;
import com.vote.Entity.Candidate;


/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AdminDao adminDao = context.getBean(AdminDao.class);
		CandidateDao candidateDao = context.getBean(CandidateDao.class);
		
		Admin admin;
		Candidate candidate;
		
		
		boolean isActive =true;
		
		while (isActive) {
			System.out.println("1. Register For Election:");
			System.out.println("2.Login For See Your Voter:");	
			System.out.println("3.Register For Vote:");
			System.out.println("4.Login for vote (if registered already)");
			System.out.println("5. Exit");
			
			int key = sc.nextInt();
			int voterId;
			switch (key) {
			case 1:
				System.out.println("Enter the Ps Number :");
				int ps = sc.nextInt();
				System.out.println("Enter  the Candidate Name:");
				sc.nextLine();
				String candidateName= sc.nextLine();
				
				System.out.println("Enter Your Email Address");
				String candidateEmail = sc.nextLine();
				
				System.out.println("Enter your password:");
				String candidatePassword= sc.nextLine();
				
				System.out.println("Enter the Symbol");
				String symbol = sc.nextLine();
				
				System.out.println("Enter the Party Name");
				String partyName= sc.nextLine();
				
				admin = new Admin(ps, candidateName, candidateEmail, candidatePassword, symbol, partyName);
				boolean registerForElection = (boolean)adminDao.registerForElection(admin);
				if (registerForElection) {
					System.out.println("Welcome...");
				}else {
					System.out.println("Sorry....");
				}
				
				System.out.println("You are registered for election");
				break;
			case 2:
				System.out.println("Enter Your Email Address");
				 sc.nextLine();
				 candidateEmail = sc.nextLine();
				
				System.out.println("Enter your password:");
				 candidatePassword= sc.nextLine();
				
				 System.out.println("Login successful .. Now you can See your voters");
				try {
				 List<Candidate> votedBy = candidateDao.seeVoterByCandidateEmail(candidateEmail);
				 if (votedBy.size()!=0) {
					 for (Candidate voter : votedBy) {
						System.out.println(voter);
					}
					 break;
				}else {
					System.out.println("There is no vote yet");
				}
				}catch (Exception e) {
					// TODO: handle exception
					
					System.out.println(e.getMessage());
				}
				 
				break;
			case 3:
				System.out.println("Enter the Voter Id :");
			voterId = sc.nextInt();
				System.out.println("Enter  the Voter Name:");
				sc.nextLine();
				String voterName= sc.nextLine();
				
				System.out.println("Enter Your Voter Email Address");
				String voterEmail = sc.nextLine();
				
				System.out.println("Enter your voter's password:");
				String voterPassword= sc.nextLine();
				
				System.out.println("Enter the voter Address");
				String voterAddress = sc.nextLine();
				
				candidate = new Candidate(voterId, voterName, voterEmail, voterPassword, voterAddress);
				
				boolean isRegistered = candidateDao.registerForVote(candidate);
				if (isRegistered) {
					System.out.println("Congrualations");
					
				}else {
					System.out.println("Something went to wrong......");
				}
				

				break;
			case 4:
				System.out.println("Enter Your voter Email Address");
				sc.nextLine();
				 voterEmail = sc.nextLine();
				
				System.out.println("Enter your voter password:");
				 voterPassword= sc.nextLine();
				
				 candidate = new Candidate(voterEmail, voterPassword);
				 
				 boolean islogin= candidateDao.LoginForVote(candidate);
				 while (islogin) {
					
					 List<Admin> candidates = adminDao.candidates();
						boolean  isVote= true;
						
						if (isVote && candidates.size()!=0) {
							for (int i = 0; i < candidates.size(); i++) {
								
							
							System.out.println(i+1+". For "+candidates.get(i).getSymbol());
							
						}
							System.out.println(candidates.size()+1+" Exit");
							int selectChioce = sc.nextInt();
							String choicePartyForVote = null;
							if (selectChioce<=candidates.size()) {
								
							
							choicePartyForVote=candidates.get(selectChioce-1).getSymbol();
							}
							for (Admin admin2 : candidates) {
								if (admin2.getSymbol().equalsIgnoreCase(choicePartyForVote)) {
									System.out.println("You have voted:"+choicePartyForVote);
									
									Candidate fetchedCandidate = candidateDao.getVoterByEmail(voterEmail);
									candidate = new Candidate(fetchedCandidate.getVoteId(),
											fetchedCandidate.getVoterName(), voterEmail, voterPassword, 
											fetchedCandidate.getVoterAddress(), admin2);
									
									boolean isVoted = candidateDao.UpdateVoter(candidate);
									if (isVoted) {
										System.out.println("You have successsfully voted");
									}else {
										System.out.println("not yet..");
									}
								}
							}
							
//						}else {
//							isVote = false;
//						}
			


					 
					 
					 
				
				 
//				System.out.println("Login Successfully now you can vote");
//				
//				boolean islogin=true;
//				while (islogin) {
//					System.out.println("1.Vote for candidate1");
//					System.out.println("2.vote for candidate2");
//					System.out.println("3. Politics is Harram in Islam(Exit)");
//					int selectChoice =sc.nextInt();
							
//					switch (selectChioce) {
//				
//					case 1:
//						System.out.println("Thanks ! You have voted candidate1");
//						islogin=false;
//						break;
//					
//					case 2:
//						System.out.println("Thanks ! You have voted candidate2");
//						islogin =false;
//						break;
//					case 3:
//						System.out.println("Very Well! I gather that you have fully followed Islam");
//						islogin=false;
//						break;
//
//					default:
//						System.out.println("Sorry.. your choice is not correct.. ");
//						break;
//					}
							
					for (int i = 1; i <=candidates.size(); i++) {
						if (selectChioce==i) {
							System.out.println("Thanks You have voted candidate "+i);
							islogin=false;
						}
						if (selectChioce==i+1) {
							System.out.println("Thank You for Reaching the code ");
							islogin=false;
						}
					}
					
				}
				 }

				break;
			case 5:
				System.out.println("Thanks For Registration and also reaching...");
				isActive=false;
				break;

			default:
				System.out.println("Sorry.. You have Entered Wrong Value");
				break;
			}
		}
		
		
		System.out.println("Thanks for Using my web Application");
	}
	
  }
