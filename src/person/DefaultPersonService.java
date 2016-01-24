package person;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@ManagedBean(name="personService")
@SessionScoped
public class DefaultPersonService implements PersonService {

	private PersonDAO personDAO;

	@Override
	@Transactional
	public void add(PersonBean p) {
		this.personDAO.add(p);
	}

	@Override
	@Transactional
	public List<PersonBean> find() {
		return this.personDAO.find();
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
