package com.colour.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colour.beans.CountryBean;
import com.colour.model.CountryMaster;
import com.colour.module.master.dao.ICountryDao;
import com.colour.module.master.service.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	ICountryDao countryDao;

	public List<CountryBean> displayCountry() {

		List<CountryBean> countryBeanList = new ArrayList<CountryBean>();
		try {
			List<CountryMaster> countryMasterList = countryDao.displayCountryDao();
			for (CountryMaster countryMaster : countryMasterList) {
				CountryBean countryBean = new CountryBean();
				countryBean.setCountryName(countryMaster.getCountryName());
				countryBean.setCountryId(countryMaster.getCountryId());
				countryBean.setActive(countryMaster.getActive());
				countryBean.setIsdefault(countryMaster.getIsdefault());
				countryBeanList.add(countryBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryBeanList;
	}

	public Boolean insertCountry(CountryBean countryBean) {
		try{
			CountryMaster countryMaster=new CountryMaster();
			countryMaster.setCountryId(countryBean.getCountryId());
			countryMaster.setCountryName(countryBean.getCountryName());
			countryMaster.setActive(countryBean.getActive());
			countryMaster.setIsdefault(countryBean.getIsdefault());
			countryDao.insertCountry(countryMaster);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean updateCountry(CountryBean countryBean) {
		try{
			CountryMaster countryMaster=new CountryMaster();
			countryMaster.setCountryId(countryBean.getCountryId());
			countryMaster.setCountryName(countryBean.getCountryName());
			countryMaster.setActive(countryBean.getActive());
			countryMaster.setIsdefault(countryBean.getIsdefault());
			countryDao.updateCountry(countryMaster);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public Boolean deleteCountry(Integer countryId){
		
		try{
			CountryMaster countryMaster = new CountryMaster();
			countryMaster.setCountryId(countryId);
			countryDao.deleteCountry(countryMaster);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public CountryBean findByCountryId(Integer countryId) {
		
		CountryBean countryBean= new CountryBean();
		try{
			CountryMaster countryMaster= countryDao.findByCountryId(countryId);
			if(countryMaster!=null){
			countryBean.setCountryId(countryMaster.getCountryId());
			countryBean.setCountryName(countryMaster.getCountryName());
			countryBean.setActive(countryMaster.getActive());
			countryBean.setIsdefault(countryMaster.getIsdefault());
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			//return null;
		}
		return countryBean;
	}
	
	


}
