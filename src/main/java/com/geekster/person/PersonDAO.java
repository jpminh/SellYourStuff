package com.geekster.person;

import java.util.List;


public interface PersonDAO {
	/**
	 * saves a Person in the database
	 * @param p
	 */
	public void add(PersonBean person);

	/**
	 *
	 * @return the list of existing Persons
	 */
	public List<PersonBean> find();
}