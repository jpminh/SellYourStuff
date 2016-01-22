package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import model.Person;

@Repository
public class DefaultPersonDAO implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(DefaultPersonDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Person person) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("Person saved successfully, person Details="+person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> find() {
		final Session session = this.sessionFactory.getCurrentSession();
		final List<Person> personList = session.createQuery("from Person").list();
		return personList;
	}

}
