package person;

import java.util.List;


public interface PersonService {
	/**
	 * saves a person
	 * @param person
	 */
	public void add(PersonBean person);

	/**
	 *
	 * @return the list of existing persons
	 */
	public List<PersonBean> find();

}
