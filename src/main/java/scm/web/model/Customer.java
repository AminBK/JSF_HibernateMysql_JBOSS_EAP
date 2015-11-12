package scm.web.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import scm.web.entity.CustomerDao;
import scm.web.util.SessionBean;;

@ManagedBean
@SessionScoped
public class Customer implements java.io.Serializable {
	
    private Integer custId;
    
    @NotNull
    private String userName;
	@NotNull
    private String firstName;
	@NotNull
    private String lastName;
	@NotEmpty @Email
    private String email;
	
	public String password;
    
	@DateTimeFormat(pattern="dd-MM-yyyy")
    @NotNull @Past
    private Date dob;
	
    private String sd, msg, selectedname;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
 
    public Customer() {
    }
 
    public Customer(String userName, String firstName, String lastName, String email, String password, Date dob) {
    	this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }
 
    public String getSd() {
        return sd;
    }
 
    public void setSd(String sd) {
        this.sd = sd;
    }
 
    public Integer getCustId() {
        return this.custId;
    }
 
    public void setCustId(Integer custId) {
        this.custId = custId;
    }
    
    public String getUserName() {
        return this.userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getFirstName() {
        return this.firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return this.lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return this.email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
    public Date getDob() {
        return this.dob;
    }
 
    public void setDob(Date dob) {
        this.dob = dob;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public String getSelectedname() {
        return selectedname;
    }
 
    public void setSelectedname(String selectedname) {
        this.selectedname = selectedname;
    }
 
    public String saveCustomer() {
        try {
            Date d = sdf.parse(sd);
            System.out.println(d);
            this.dob = d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CustomerDao dao = new CustomerDao();
        String status = dao.addCustomer(this);
        this.msg = "Member Info Saved Successfull!";
        clearAll();
        if(status.equals("success"))
    		return "success";
        else
        	return "unsuccess";
    }
    
    public void updateCustomer() {
        try {
            Date d = sdf.parse(sd);
            System.out.println(d);
            this.dob = d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CustomerDao dao = new CustomerDao();
        dao.updateCustomer(this);
        this.msg = "Member Info Update Successfull!";
        clearAll();
    }
    public void deleteCustomer() {
        CustomerDao dao = new CustomerDao();
        dao.deleteCustomer(custId);
        this.msg = "Member Info Delete Successfull!";
        clearAll();
    }
 
    public List<Customer> getAllCustomers() {
    	List<Customer> users = new ArrayList<Customer>();
    	try
    	{
	        
	        CustomerDao dao = new CustomerDao();
	        users = dao.getAllCustomers();
    	}
    	catch (Throwable ex) {
            System.err.println("GetAllCustomers error:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    	finally
    	{
    		return users;
    	}
    }
 
    public void fullInfo() {
        CustomerDao dao = new CustomerDao();
        List<Customer> lc = dao.getCustomerById(selectedname);
        System.out.println(lc.get(0).firstName);
        this.custId = lc.get(0).custId;
        this.userName = lc.get(0).userName;
        this.firstName = lc.get(0).firstName;
        this.lastName = lc.get(0).lastName;
        this.password = lc.get(0).password;
        this.email = lc.get(0).email;
        this.dob = lc.get(0).dob;
        this.sd = sdf.format(dob);
    }
 
    private void clearAll() {
    	this.userName = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.sd = "";
        this.email = "";
        this.custId=0;
    }
    
    //validate login
    public String login() {
    	CustomerDao dao = new CustomerDao();
        boolean valid = dao.validate(userName, password);
        if (valid) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", userName);
            return "output";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Please enter correct username and Password"));
            return "invalid";
        }
    }
    
    public void logout() {  
        FacesContext.getCurrentInstance().getExternalContext()  
                .invalidateSession();  
        FacesContext.getCurrentInstance()  
                .getApplication().getNavigationHandler()  
                .handleNavigation(FacesContext.getCurrentInstance(), null, "/login.xhtml");  
    }  
}