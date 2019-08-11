package com.colour.beans;

import java.io.Serializable;
import java.util.List;

import com.colour.model.StateMaster;

public class CountryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8264284453288689450L;
	private Integer countryId;
	private String countryName;
	private String active;
	private String isdefault;
	List<StateBean> StateBeanList;
	
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
	public List<StateBean> getStateBeanList() {
		return StateBeanList;
	}
	public void setStateBeanList(List<StateBean> stateBeanList) {
		StateBeanList = stateBeanList;
	}
	

	

}
