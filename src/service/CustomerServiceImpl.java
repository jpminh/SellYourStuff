package service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDAO;
import model.Customer;
 
 
@Service
@ManagedBean(name="customerService")
@SessionScoped
public class CustomerServiceImpl implements CustomerService {
 
    private CustomerDAO customerDAO;
  
    @Override
    @Transactional
    public void addCustomer(Customer p) {
        this.customerDAO.addCustomer(p);
    }
  
    @Override
    @Transactional
    public List<Customer> listCustomers() {
        return this.customerDAO.listCustomers();
    }

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}  
  
}
