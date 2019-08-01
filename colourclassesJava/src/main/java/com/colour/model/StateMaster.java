package com.colour.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

		
		//hibernate lazy
		//jpa default rule
		//one to many lazy
		//many to 1 egar
		
		
	}

