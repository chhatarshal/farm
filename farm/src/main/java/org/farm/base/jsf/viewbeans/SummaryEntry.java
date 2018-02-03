package org.farm.base.jsf.viewbeans;

import javax.persistence.Entity;
import javax.persistence.Id;


public class SummaryEntry {
	@Id
	private Integer id;
	private String shadeName;
	private Integer totalEgg;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShadeName() {
		return shadeName;
	}
	public void setShadeName(String shadeName) {
		this.shadeName = shadeName;
	}
	public Integer getTotalEgg() {
		return totalEgg;
	}
	public void setTotalEgg(Integer totalEgg) {
		this.totalEgg = totalEgg;
	}
	
	
	

}
