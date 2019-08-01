package com.colour.module.master.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colour.beans.CountryBean;
import com.colour.beans.StatusBean;
import com.colour.module.master.service.ICountryService;
import com.colour.module.master.validator.ValidatorContryUtil;

@Controller
@RequestMapping(path = "/master", produces = "application/json")
public class CountryController {

	@Autowired
	ICountryService countryService;

	@RequestMapping(value = { "/showCountry" }, method = RequestMethod.GET)
	  public String driverMaster() {
	      return "master/countryMaster";
	  }
	
	@RequestMapping("/displayAllCountry")
	public ResponseEntity<?> showTransporter(HttpServletRequest request) {
		StatusBean statusBean=new StatusBean();
		try {
			List<CountryBean> countryBeanList = countryService.displayCountry();
			if (countryBeanList != null && !countryBeanList.isEmpty()) {
				return new ResponseEntity<List<CountryBean>>(countryBeanList, HttpStatus.OK);
			} else {
				statusBean.setMessage("No Record Found");
				statusBean.setSatusCode("501");
				statusBean.setStatus(true);
				return new ResponseEntity<StatusBean>(statusBean, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			statusBean.setMessage("Error While Processing");
			statusBean.setSatusCode("404");
			statusBean.setStatus(false);
			return new ResponseEntity<StatusBean>(statusBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/insertCountry", method = RequestMethod.POST)
	public ResponseEntity<?> insertCountry(HttpServletRequest request, @RequestBody CountryBean countryBean) {
		String message = "";
		StatusBean statusBean=new StatusBean();
		try {
			//check request bean is null or not
			//field validation check active and default value is Y or N 
			//if default is Y then check any other entity having default Y or Not if Y then update to N
			
			ValidatorContryUtil validatorContryUtil=new ValidatorContryUtil();
			statusBean=validatorContryUtil.countryFieldValidation(countryBean);
			if(!statusBean.getStatus()){
				return new ResponseEntity<StatusBean>(statusBean, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			Boolean status = countryService.insertCountry(countryBean);
			if (status) {
				message = "Success";
				return new ResponseEntity<StatusBean>(statusBean, HttpStatus.OK);
				
			} else {
				message = "Fail";
			}
			return new ResponseEntity<String>(message, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateCountry", method = RequestMethod.POST)
	public ResponseEntity<String> updateCountry(HttpServletRequest request, @RequestBody CountryBean countryBean) {
		String message = "";
		try {
			Boolean status = countryService.updateCountry(countryBean);
			if (status) {
				message = "Successfully updated";
			} else {
				message = "Failed to update";
			}
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCountry(HttpServletRequest request, @RequestBody CountryBean country) {
		String message = "";
		try {
			Boolean status = countryService.deleteCountry(country.getCountryId());
			if (status) {
				message = "Successfully deleted";
			} else {
				message = "Failed to delete";
			}
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/findByCountryId", method = RequestMethod.POST)
	public ResponseEntity<?> findByCountryId(HttpServletRequest request, @RequestBody CountryBean country) {
		CountryBean countryBean = null;
		StatusBean statusBean=new StatusBean();
		try {
			countryBean = countryService.findByCountryId(country.getCountryId());
			if (countryBean != null) {
				statusBean.setMessage("Success");
				statusBean.setSatusCode("501");
				statusBean.setStatus(true);
				return new ResponseEntity<CountryBean>(countryBean, HttpStatus.OK);
			} else {
				statusBean.setMessage("No Record Found");
				statusBean.setSatusCode("501");
				statusBean.setStatus(true);
				return new ResponseEntity<StatusBean>(statusBean, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			statusBean.setMessage("Error While Processing");
			statusBean.setSatusCode("404");
			statusBean.setStatus(false);
			return new ResponseEntity<StatusBean>(statusBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
