package service;

import java.util.List;

import model.Person;


public interface PersonService {
	/**
	 * saves a person
	 * @param person
	 */
	public void add(Person person);

	/**
	 *
	 * @return the list of existing persons
	 */
	public List<Person> find();

}
