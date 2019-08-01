package com.colour.beans;

import java.io.Serializable;

public class CityBean implements Serializable {

	private static final long serialVersionUID = 6695195154471729772L;
		private Integer cityId;
		public Integer getCityId() {
			return cityId;
		}
		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		private String cityName;
}
