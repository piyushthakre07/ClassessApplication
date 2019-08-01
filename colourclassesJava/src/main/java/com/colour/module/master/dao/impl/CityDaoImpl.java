package com.colour.module.master.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.colour.model.CityMaster;
import com.colour.module.master.dao.ICityDao;

@Repository
public class CityDaoImpl implements ICityDao {

/*	@Autowired
	SessionFactory sessionFactory;*/
	
	@Transactional
	public List<CityMaster> displayCityDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
