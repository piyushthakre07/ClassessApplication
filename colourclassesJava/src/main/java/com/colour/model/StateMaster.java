package com.colour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;





	@Entity
	@Table(name="STATE_MASTER")
	public class StateMaster {
		
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="state_id")
		private Integer stateId;
		
		@Column(name="state_name")
		private String stateName;
		
		@Column(name="is_active")
		private String active;
		
		@Column(name="is_default")
		private String isdefault;
		
		//@OneToOne(fetch = FetchType.EAGER, mappedBy = "countryId")
		 @OneToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "country_Id")
		private CountryMaster countryMaster;

		public Integer getStateId() {
			return stateId;
		}

		public void setStateId(Integer stateId) {
			this.stateId = stateId;
		}

		public String getStateName() {
			return stateName;
		}

		public void setStateName(String stateName) {
			this.stateName = stateName;
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

		public CountryMaster getCountryMaster() {
			return countryMaster;
		}

		public void setCountryMaster(CountryMaster countryMaster) {
			this.countryMaster = countryMaster;
		}

		
		//hibernate lazy
		//jpa default rule
		//one to many lazy
		//many to 1 egar
		
		
	}

