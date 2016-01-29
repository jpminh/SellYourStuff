package com.geekster.person;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;


@Service
@ManagedBean(name="personService")
@SessionScoped
public class DefaultPersonService implements PersonService {

	private PersonDAO personDAO;

	@Override
	public void add(PersonBean p) {
		this.personDAO.add(p);
	}

	@Override
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
