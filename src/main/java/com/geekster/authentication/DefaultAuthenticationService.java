package com.geekster.authentication;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ManagedBean(name="authenticationService")
@SessionScoped
public class DefaultAuthenticationService implements AuthenticationService {

	@ManagedProperty("#{defaultAuthenticationDAO}")
	AuthenticationDAO authenticationDAO;

	@Override
	@Transactional
	public String login(AuthenticationBean user) {
		final boolean valid = authenticationDAO.validate(user.getUsername(), user.getPassword());
		if (valid) {
			final HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user.getUsername());
			return AuthenticationEnum.AUTORIZED.getValue();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return AuthenticationEnum.LOGIN.getValue();
		}

	}

	@Override
	@Transactional
	public String logout() {
		final HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";

	}

	public AuthenticationDAO getAuthenticationDAO() {
		return authenticationDAO;
	}

	public void setAuthenticationDAO(AuthenticationDAO authenticationDao) {
		this.authenticationDAO = authenticationDao;
	}



}
