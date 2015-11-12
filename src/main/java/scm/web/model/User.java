package scm.web.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@RequestScoped
public class User implements Serializable{
	
	private int userId;
	private String username;
	private int age;
	private String createdBy;
	private Date createdDate;
	private String status;

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
		
	public String getCreatedBy() {
	 	return createdBy;
	}
	 
	public void setCreatedBy(String createdBy) {
	 	this.createdBy = createdBy;
	}
	 
	public Date getCreatedDate() {
	 	return createdDate;
	}
	 
	public void setCreatedDate(Date createdDate) {
	 	this.createdDate = createdDate;
	}
	
	public String getStatus() {
	 	return this.status = "pass";
	}
}




