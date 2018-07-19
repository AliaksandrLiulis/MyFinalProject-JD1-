package by.myProject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;
import by.myProject.service.interfaces.IServiceUser;

public class Do_remove_User implements ICommand{
	private final String COMAND_NAME = "choose";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String goToPage = null;
		response.setContentType("text/html; charset=utf-8");
		String nickName = request.getParameter(COMAND_NAME);
		int i = 0;
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser iServiceUser = serviceFactory.getServiceUser();
		
		boolean action = iServiceUser.doAction(nickName, i);
		if (action) {
			goToPage = JspPagePath.ADMIN_PAGE_PATH;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {			
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
	}
}
