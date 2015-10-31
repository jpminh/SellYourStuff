package service;

import java.util.List;

import model.Customer;

  
public interface CustomerService {
	/**
	 * saves a customer in the database
	 * @param p
	 */
    public void addCustomer(Customer p);
    
    /**
     * 
     * @return the list of existing customer in the DB
     */
    public List<Customer> listCustomers();
      
}
