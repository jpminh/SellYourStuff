package com.geekster.authentication;

public interface AuthenticationService {

	public String login(AuthenticationBean user);

	public String logout();

}
