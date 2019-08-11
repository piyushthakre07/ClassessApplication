package com.colour.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRYMASTER")
public class CountryMaster {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="is_active")
	private String active;
	
	@Column(name="is_default")
	private String isdefault;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy="countryMaster")
   // @OrderColumn(name = "countryId")
	List<StateMaster> StateMasterList;
	
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public List<StateMaster> getStateMasterList() {
		return StateMasterList;
	}

	public void setStateMasterList(List<StateMaster> stateMasterList) {
		StateMasterList = stateMasterList;
	}


	
	
	
	
	
}
