package by.myProject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;
import by.myProject.service.interfaces.IServiceWorker;

public class AddNewWorker implements ICommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String goToPage = JspPagePath.ADD_WORKER_PAGE;
		String nickName = request.getParameter("nickName");	
		String message = null;
		
		if (request.getParameter("name") != null && request.getParameter("surname") != null) {
			
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");		
		String profession = request.getParameter("profession");
		String age = request.getParameter("age");
		String experience = request.getParameter("experience");
		String salary = request.getParameter("salary");
		String admission = request.getParameter("admission");
		
			
			ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
			IServiceWorker iServiceWorker = serviceFactory.getServiceWorker();
			message = iServiceWorker.addWorker(name, surname, profession, age, experience, salary,
					admission, nickName);
			}
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		else {
			request.setAttribute("nickName", nickName);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
