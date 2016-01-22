package dao;

import java.util.List;

import model.Person;


public interface PersonDAO {
	/**
	 * saves a Person in the database
	 * @param p
	 */
	public void add(Person person);

	/**
	 *
	 * @return the list of existing Persons
	 */
	public List<Person> find();
}