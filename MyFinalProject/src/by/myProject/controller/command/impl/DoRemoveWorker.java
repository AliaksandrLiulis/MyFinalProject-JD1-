package by.myProject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;
import by.myProject.service.interfaces.IServiceUser;
import by.myProject.service.interfaces.IServiceWorker;

public class DoRemoveWorker implements ICommand{
	
	private final String COMAND_NAME = "choose";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String goToPage = null;
		boolean action = false;
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter(COMAND_NAME);
		int i = 0;
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceWorker iServiceWorker = serviceFactory.getServiceWorker();
		action = iServiceWorker.removeWorker(name, i);
		if (action) {
			goToPage = JspPagePath.WORKER_PAGE;
		}		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {			
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
	
	}

}
