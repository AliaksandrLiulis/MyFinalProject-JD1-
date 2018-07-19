package by.myProject.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myProject.been.User;
import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.dao.exception.DAOException;
import by.myProject.service.ServiceFactory;
import by.myProject.service.exception.ServiceException;
import by.myProject.service.interfaces.IServiceUser;

public class RegisterUser implements ICommand {
	
	private final String COMAND_NICKNAME_NAME = "nickName"; 
	private final String COMAND_NAME_NAME = "name"; 
	private final String COMAND_SURNAME_NAME = "surName"; 
	private final String COMAND_SEX_NAME = "gender"; 
	private final String COMAND_AGE_NAME = "age"; 
	private final String COMAND_EMAIL_NAME = "email"; 
	private final String COMAND_SPECIALITY_NAME = "special"; 
	private final String COMAND_ORGANIZE_NAME = "organize"; 
	private final String COMAND_PASSWORD_NAME = "password"; 
	private final String COMAND_ALLOW_NAME = "terms"; 

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		
		
		String name = request.getParameter(COMAND_NAME_NAME);
		String surName = request.getParameter(COMAND_SURNAME_NAME);
		String nickName = request.getParameter(COMAND_NICKNAME_NAME);
		String sex = request.getParameter(COMAND_SEX_NAME);
		String age = request.getParameter(COMAND_AGE_NAME);
		String email = request.getParameter(COMAND_EMAIL_NAME);
		String specialty = request.getParameter(COMAND_SPECIALITY_NAME);
		String organize = request.getParameter(COMAND_ORGANIZE_NAME);
		String pass = request.getParameter(COMAND_PASSWORD_NAME);
		String allow = request.getParameter(COMAND_ALLOW_NAME);
		List<String> allRequest = new ArrayList<>();
		allRequest.add(name);
		allRequest.add(surName);
		allRequest.add(nickName);
		allRequest.add(sex);
		allRequest.add(age);
		allRequest.add(email);
		allRequest.add(specialty);
		allRequest.add(organize);
		allRequest.add(pass);
		allRequest.add(allow);

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser iServiceUser = serviceFactory.getServiceUser();
		String goToPage = null;
		User user = null;
		
		
			try {
				user = iServiceUser.registrUser(allRequest);
				if (user == null) {		
					request.setAttribute("errorMessage", "Such User exists");
					goToPage = JspPagePath.REGISTER_PAGE_PATH;
				}else {
					request.getSession(true).setAttribute("user", user);
					goToPage = JspPagePath.EXPECT_PAGE_PATH;
				}		
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
					
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}						
	}
}
