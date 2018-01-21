package org.farm.base.configure;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.farm.base.jsf.viewbeans.Record;
import org.farm.base.model.Car;

@ManagedBean(name = "eggService")
@ApplicationScoped
public class EggService {
	
	private List<Record> totalRecords=new ArrayList<Record>();
	
	   public List<Record> records(int size) {
	        return totalRecords;
	    }
	   
	   public void addRecord() {
		   totalRecords.add(new Record(22,10,10000));
		   System.out.println("Size of list   ="+totalRecords.size());
	   }

	public List<Record> createEggs(int size) {	
			totalRecords.clear();
	        for(int i = 0 ; i < size ; i++) {
	        	totalRecords.add(new Record(i,12,10000));
	        }	         
	        return totalRecords;
	}
}
