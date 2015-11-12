package scm.web.entity;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import scm.web.model.Customer;
import scm.web.util.HibernateUtil;

public class CustomerDao {
 
    public String addCustomer(Customer cust) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(cust);
            session.getTransaction().commit();
            return "success";
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return "fail";
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public void deleteCustomer(int custid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Customer cust = (Customer) session.load(Customer.class, new Integer(custid));
            session.delete(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public void updateCustomer(Customer cust) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public List<Customer> getAllCustomers() {
        List<Customer> users = new ArrayList<Customer>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("select concat(first_name, ' ', last_name) as name from Customer").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
    public List<Customer> getCustomerById(String custid) {
        System.out.println(custid);
//        Customer cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Customer where concat(first_name, ' ', last_name) = :id";
            Query query = session.createQuery(queryString);
            query.setString("id", custid);
            //cust = (Customer) query.uniqueResult();
            List<Customer> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
    
    public static boolean validate(String user, String password) {
        
    	Customer targetCustormer = new Customer();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("Select userName, password from Customer where username = :user and password = :password");
            query.setString("user", user);
            query.setString("password", password);
            List<Customer> list = query.list();
            
            if (list.size() > 0) {
                return true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        } finally {
            session.flush();
            session.close();
        }
        return false;
    	
    	
    }
}