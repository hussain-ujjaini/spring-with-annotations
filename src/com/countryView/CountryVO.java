package com.countryView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="countryMaster")
public class CountryVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int countryId;
	private String countryName;
	public CountryVO(CountryVO vo) {
		countryId=vo.getCountryId();
		countryName=vo.getCountryName();
	}
	public CountryVO() {
	
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
