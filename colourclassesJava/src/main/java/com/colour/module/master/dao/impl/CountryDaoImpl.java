package com.colour.module.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.colour.model.CountryMaster;
import com.colour.module.master.dao.ICountryDao;

@Repository
public class CountryDaoImpl implements ICountryDao {

	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	public List<CountryMaster> displayCountryDao(){
	

		List<CountryMaster> countryList = new ArrayList<CountryMaster>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(CountryMaster.class);
			criteria.add(Restrictions.eq("active", "Y"));
			countryList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}
		return countryList;
	}
	
	@Transactional
	public Boolean insertCountry(CountryMaster countryMaster) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(countryMaster);
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			return false;
		}
		return true;
	}
	
	@Transactional
	public Boolean updateCountry(CountryMaster countryMaster) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(countryMaster);
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			return false;
		}
		return true;
	}

	@Transactional
	public Boolean deleteCountry(CountryMaster countryMaster){
		try{
			Session session = sessionFactory.getCurrentSession();
			session.delete(countryMaster);
		}catch(Exception e){
		e.printStackTrace();
		return false;
		}
		return true;
	}
@Transactional
	public CountryMaster findByCountryId(Integer countryId) {
		CountryMaster countryMaster = new CountryMaster();
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(CountryMaster.class);
			criteria.add(Restrictions.eq("active", "Y"));
			criteria.add(Restrictions.eq("countryId", countryId));
			countryMaster = (CountryMaster) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// throw e;
		}
		return countryMaster;
	}
}
