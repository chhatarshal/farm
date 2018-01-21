package org.farm.base.jsf.viewbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.farm.base.configure.BaseDao;
import org.farm.base.configure.Context;
@ManagedBean
@Entity
public class Record {
	public final Integer EGG_IN_BOX=28;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer serialNo;
	private Integer dateId;
	private Integer totalBox;	
	private Date entryDate;
	@Id
	private Integer id;
	
	@Transient private Integer totalEgg;
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDateId() {
		return dateId;
	}

	public void setDateId(Integer dateId) {
		this.dateId = dateId;
	}

	public Record() {	
	}
	
	public Record(Integer id,Integer serialNo,Integer totalBox) {
		this.id=id;
		this.serialNo=serialNo;
		this.totalBox=totalBox;
	}
	
	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getTotalBox() {
		return totalBox;
	}

	public void setTotalBox(Integer totalBox) {
		this.totalBox = totalBox;
		DateFormat df = new SimpleDateFormat("MMddyyyy");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);		
		this.setId(Integer.parseInt(reportDate));
	}

	public Date getEntryDate() {
		return new Date();
	}

	public Integer getTotalEgg() {
		return getTotalBox()*EGG_IN_BOX;
	}
	
	
	public void saverecord( ) {
		Context context=new Context();
		BaseDao baseDao=(BaseDao) context.getObject("baseDao");
		baseDao.createEntity(this,Record.class);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've registered"));
	}


	
	
}
