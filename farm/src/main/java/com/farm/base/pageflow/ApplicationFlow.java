package com.farm.base.pageflow;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.farm.base.jsf.viewbeans.Application;
import org.primefaces.event.FlowEvent;

 
@ManagedBean
@ViewScoped
public class ApplicationFlow implements Serializable {
 
    private Application application = new Application();
     
    private boolean skip;
     
    public Application getApplication() {
        return application;
    }
 
    public void setUser(Application application) {
        this.application = application;
    }
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + application.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}