package by.myProject.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myProject.been.User;
import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;
import by.myProject.service.interfaces.IServiceUser;

public class Remove_User implements ICommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String roleUser = request.getParameter("role");
		String goToPage = null;
		ServiceFactory factory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = factory.getServiceUser();
		ArrayList<User> allUsers = serviceUser.showAllUsers(roleUser);
		boolean removeUser = false;
		if (allUsers != null) {
			removeUser = true;
			request.setAttribute("allUsers", allUsers);
			request.setAttribute("removeUser", removeUser);			
			goToPage = JspPagePath.ADMIN_PAGE_PATH;
		}else {
			
//			error
		}		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
		
	}

}
