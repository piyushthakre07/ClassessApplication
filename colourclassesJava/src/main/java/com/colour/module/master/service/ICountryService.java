package com.colour.module.master.service;

import java.util.List;

import com.colour.beans.CountryBean;

public interface ICountryService {

	public List<CountryBean> displayCountry(); 
	
	public Boolean insertCountry(CountryBean countryBean);
	
	public Boolean updateCountry(CountryBean countryBean);
	
	public Boolean deleteCountry(Integer countryId);
	
	public CountryBean findByCountryId(Integer countryId);
}
