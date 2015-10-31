package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
     
    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
      
    private SessionFactory sessionFactory;
      
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
  
    @Override
    public void addCustomer(Customer p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Customer saved successfully, Customer Details="+p);
    }
  
    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> listCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customersList = session.createQuery("from Customer").list();
        for(Customer p : customersList){
            logger.info("Customer List::"+p);
        }
        return customersList;
    }
  
}
