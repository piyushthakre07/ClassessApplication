package com.colour.module.master.dao;

import java.util.List;

import com.colour.beans.CountryBean;
import com.colour.model.CountryMaster;

public interface ICountryDao {

	public List<CountryMaster> displayCountryDao();

	Boolean insertCountry(CountryMaster countryMaster);
	
	public Boolean updateCountry(CountryMaster countryMaster);
	
	public Boolean deleteCountry(CountryMaster countryMaster);
	
	public CountryMaster findByCountryId(Integer countryId);
}
