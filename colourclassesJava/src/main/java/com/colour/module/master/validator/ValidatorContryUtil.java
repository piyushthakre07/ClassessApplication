package com.colour.module.master.validator;

import java.util.regex.Pattern;

import com.colour.beans.CountryBean;
import com.colour.beans.StatusBean;

public class ValidatorContryUtil {

	public StatusBean countryFieldValidation(CountryBean countryBean){
		StatusBean statusBean=new StatusBean();
	try{
		if(countryBean==null){
			statusBean.setMessage("Invalid request");
			statusBean.setSatusCode("404");
			statusBean.setStatus(false);
			return statusBean;
		}
		else if(!((countryBean.getActive().contains("Y")||countryBean.getActive().contains("N")))){
			statusBean.setMessage("Invalid value of active flag.");
			statusBean.setSatusCode("404");
			statusBean.setStatus(false);
			return statusBean;	
		}
		else if(!((countryBean.getIsdefault().contains("Y")||countryBean.getIsdefault().contains("N")))){
			statusBean.setMessage("Invalid value of Default flag.");
			statusBean.setSatusCode("404");
			statusBean.setStatus(false);
 			return statusBean;	
		}
		
		Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        java.util.regex.Matcher matcher = pattern.matcher(countryBean.getCountryName());
		if(!matcher.matches()){
			statusBean.setMessage("Invalid value of Country Name.");
			statusBean.setSatusCode("404");
			statusBean.setStatus(false);
			return statusBean;	
		}
	
	}catch(Exception e){
		statusBean.setMessage("Error While Processing");
		statusBean.setSatusCode("404");
		statusBean.setStatus(false);
		return statusBean;
	}
	    statusBean.setStatus(true);	
		return statusBean;
	}
}
