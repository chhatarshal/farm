package org.farm.base.jsf.viewbeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.farm.base.configure.BaseDao;
import org.farm.base.configure.Context;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@Entity
@Table(name = "user_")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	
	public User( ) {
		
	}
	
	public User(String userName,String firstName,String lastName ) {
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 
	public void loginCheck() {
		System.out.println("=234232=====");
		 Authentication authentication =
			        SecurityContextHolder.getContext().getAuthentication();

		Context context=new Context();
		BaseDao baseDao=(BaseDao) context.getObject("baseDao");
		Map<String,Object> properties=new HashMap<String,Object>();
		properties.put("firstName", this.getFirstName());
		List searchList=baseDao.findByProperties(properties,User.class);
		if(searchList != null && searchList.size()>0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("success"));
		}
		///baseDao.createEntity(new User("",this.getFirstName(),this.getLastName()),User.class);
		////FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've registered"));
	}
	
	public List<User> getUsers() {
		Context context=new Context();
		BaseDao baseDao=(BaseDao) context.getObject("baseDao");
		return baseDao.loadAllEntities(this);
	}

}
