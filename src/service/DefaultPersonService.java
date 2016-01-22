package service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PersonDAO;
import model.Person;


@Service
@ManagedBean(name="personService")
@SessionScoped
public class DefaultPersonService implements PersonService {

	private PersonDAO personDAO;

	@Override
	@Transactional
	public void add(Person p) {
		this.personDAO.add(p);
	}

	@Override
	@Transactional
	public List<Person> find() {
		return this.personDAO.find();
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
