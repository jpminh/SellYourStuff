package com.geekster.authentication;

public interface AuthenticationDAO {

	/**
	 * verify if the current user is authorized to log in
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean validate(String user, String password);
}