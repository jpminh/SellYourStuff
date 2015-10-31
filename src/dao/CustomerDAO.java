package dao;
 
import java.util.List;

import model.Customer;
 
  
public interface CustomerDAO {
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