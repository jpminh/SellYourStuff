package authentication;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultAuthenticationDAO implements AuthenticationDAO {

	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public boolean validate(String user, String password) {
		final Session session = this.sessionFactory.getCurrentSession();
		final List<AuthenticationBean> userList = session.createQuery("from AuthenticationBean").list();
		for(final AuthenticationBean userInDb : userList){
			if(userInDb.getUsername().equals(user) && userInDb.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
