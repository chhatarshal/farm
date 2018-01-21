package org.farm.base.configure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.farm.base.jsf.viewbeans.Record;

@ManagedBean(name="dtColumnsView")
@ViewScoped
public class ColumnsView implements Serializable {
     
    private final static List<String> VALID_COLUMN_KEYS = Arrays.asList("id", "serialNo", "totalBox", "entryDate","totalEgg");
     
    private String columnTemplate = "id entryDate totalBox totalEgg";
     
    private List<ColumnModel> columns;
     
    private List<Record> eggs;
     
    private List<Record> filteredEggs;
     
    @ManagedProperty("#{eggService}")
    private EggService service;
 
    @PostConstruct
    public void init() {
    	eggs = service.createEggs(1);
        createDynamicColumns();
    }
     
    public List<Record> getEggs() {
    	Context context=new Context();
		BaseDao baseDao=(BaseDao) context.getObject("baseDao");
		System.out.println("=== getting.......eggs=");
		return baseDao.loadAllRecord();
    }
 
    public List<Record> getFilteredEggs() {
        return filteredEggs;
    }
 
    public void setFilteredEggs(List<Record> filteredEggs) {
        this.filteredEggs = filteredEggs;
    }
 
    public void setService(EggService service) {
        this.service = service;
    }
 
    public String getColumnTemplate() {
        return columnTemplate;
    }
 
    public void setColumnTemplate(String columnTemplate) {
        this.columnTemplate = columnTemplate;
    }
 
    public List<ColumnModel> getColumns() {
        return columns;
    }
 
    private void createDynamicColumns() {
        String[] columnKeys = columnTemplate.split(" ");
        columns = new ArrayList<ColumnModel>();   
         
        for(String columnKey : columnKeys) {
            String key = columnKey.trim();
             
            if(VALID_COLUMN_KEYS.contains(key)) {
                columns.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
            }
        }
    }
     
    public void buttonAction() {
       //reset table state
       service.addRecord();
       UIComponent table = FacesContext.getCurrentInstance().getViewRoot().findComponent(":form:eggs");
       if(table != null) {
    	   table.setValueExpression("sortBy", null);
       }
        //update columns
        createDynamicColumns();
    }
    
    
    public void getButtonAction() {
    	
    }
    
/*   public void buttonAction(ActionEvent actionEvent) {
       /// addMessage("Welcome to Primefaces!!");
    	///service.addRecord();
    	System.out.println("==================================taen");
    }*/
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    static public class ColumnModel implements Serializable {
 
        private String header;
        private String property;
 
        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }
 
        public String getHeader() {
            return header;
        }
 
        public String getProperty() {
            return property;
        }
    }
}