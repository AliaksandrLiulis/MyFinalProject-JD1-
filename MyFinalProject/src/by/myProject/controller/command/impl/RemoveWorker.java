package by.myProject.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.myProject.been.Worker;
import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;

import by.myProject.service.interfaces.IServiceWorker;

public class RemoveWorker implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String nickName = request.getParameter("nickName");
		String goToPage = null;
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceWorker iServiceWorker = serviceFactory.getServiceWorker();
		ArrayList<Worker> allWorkers = iServiceWorker.showWorkers(nickName);
		boolean removeWorker = false;
		if (allWorkers != null) {
			removeWorker = true;
			request.setAttribute("allWorkers", allWorkers);
			request.setAttribute("removeWorker", removeWorker);			
			goToPage = JspPagePath.WORKER_PAGE;;
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
