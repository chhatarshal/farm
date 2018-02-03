package org.farm.base.configure;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.farm.base.model.Slot;


@ManagedBean(name = "carService")
@ApplicationScoped
public class SlotService {

	 public List<Slot> createSlots(int size) {
	        List<Slot> list = new ArrayList<Slot>();
	        list.add(new Slot("1","8AM-9AM"));
	        list.add(new Slot("2","9AM-10AM"));
	        list.add(new Slot("3","10AM-11AM"));
	        list.add(new Slot("4","11AM-12AM"));
	        list.add(new Slot("5","12PM-1PM"));
	        list.add(new Slot("6","1PM-2PM"));
	        list.add(new Slot("7","2PM-3PM"));
	        list.add(new Slot("8","3PM-4PM"));
	        list.add(new Slot("9","4PM-5PM"));
	        list.add(new Slot("10","5PM-6PM"));
	        list.add(new Slot("11","6PM-7PM"));
	        list.add(new Slot("12","8PM-9PM"));
	        return list;
	    }

}
