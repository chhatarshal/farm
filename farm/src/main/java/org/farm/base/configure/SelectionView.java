package org.farm.base.configure;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.farm.base.model.Slot;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

 
@ManagedBean(name="dtSelectionView")
@ViewScoped
public class SelectionView implements Serializable {
     
    private List<Slot> slot;   
    private Slot selectedSlot;
    private List<Slot> selectedSlots;
    
    @ManagedProperty("#{carService}")
    private SlotService service;
     
    @PostConstruct
    public void init() {
        slot = service.createSlots(10);
    }
 
    public List<Slot> getSlots() {
        return slot;
    }
 
    public void setService(SlotService service) {
        this.service = service;
    }
 
    public Slot getSelectedSlot() {
        return selectedSlot;
    }
 
    public void setSelectedSlot(Slot selectedSlot) {
        this.selectedSlot = selectedSlot;
    }
 
    public List<Slot> getSelectedSlots() {
        return selectedSlots;
    }
 
    public void setSelectedSlots(List<Slot> selectedSlots) {
        this.selectedSlots = selectedSlots;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Slot Selected", ((Slot) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Slot Unselected", ((Slot) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void selectedSlot() {
    	System.out.println("=========its booked===");
    }
}