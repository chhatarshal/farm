package org.farm.base.jsf.viewbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Summary {
	@Id
	private Integer id;
	private Integer totalEgg;
	private Integer totalDays;
	private List<SummaryEntry> summaryRow =new ArrayList<SummaryEntry>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTotalEgg() {
		return totalEgg;
	}
	public void setTotalEgg(Integer totalEgg) {
		DateFormat df = new SimpleDateFormat("MMddyyyy");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		this.setId(Integer.parseInt(reportDate));
		this.totalEgg = totalEgg;
	}
	public Integer getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}
	public List<SummaryEntry> getSummaryRow() {
		return summaryRow;
	}
	public void setSummaryRow(List<SummaryEntry> summaryrows) {
		this.summaryRow = summaryrows;
	}
	public void addSummaryRow(SummaryEntry summaryrow) {
		this.summaryRow.add(summaryrow);
	}
	
	

}
