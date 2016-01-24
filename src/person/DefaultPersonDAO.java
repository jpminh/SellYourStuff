package person;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultPersonDAO implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(DefaultPersonDAO.class);

	private SessionFactory sessionFactory;

	@Override
	public void add(PersonBean person) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("Person saved successfully, person Details="+person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonBean> find() {
		final Session session = this.sessionFactory.getCurrentSession();
		final List<PersonBean> personList = session.createQuery("from PersonBean").list();
		return personList;
	}


	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
