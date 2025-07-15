package com.vote.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vote.Entity.Admin;
@Component
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	public HibernateTemplate hibernate;
	

	public HibernateTemplate getHibernate() {
		return hibernate;
	}


	public void setHibernate(HibernateTemplate hibernate) {
		this.hibernate = hibernate;
	}


	@Override
	@Transactional
	public boolean registerForElection(Admin admin) {
		// TODO Auto-generated method stub
	hibernate.save(admin).toString();
	return true;
	}

	@Override
	public boolean loginToSeeVoters(Admin admin) {
		// TODO Auto-generated method stub
		List<Admin> checkAdmins = candidates();
		
		
		if (checkAdmins!=null) {
			for (Admin admin2 : checkAdmins) {
				if (admin2.getEmail().equals(admin.getEmail()) && admin2.getPassword().equals(admin.getPassword())) {
					return true;
				}
			}
		}else {
			return false;
		}
		return false;
	}

	
	

	@Override
	public List<Admin> candidates() {
		// TODO Auto-generated method stub
		
		List<Admin> candidates = hibernate.loadAll(Admin.class);
		
		return candidates;
	}

}
