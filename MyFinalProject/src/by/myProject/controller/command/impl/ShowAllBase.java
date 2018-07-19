package by.myProject.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myProject.been.User;
import by.myProject.been.Worker;
import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;
import by.myProject.service.interfaces.IServiceUser;
import by.myProject.service.interfaces.IServiceWorker;

public class ShowAllBase implements ICommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String nickName = request.getParameter("nickName");	
		String goToPage = null;
		String message = null;
		ServiceFactory factory = ServiceFactory.getServiceFactory();
		IServiceWorker iServiceWorker = factory.getServiceWorker();
		ArrayList<Worker> allWorkers = iServiceWorker.showWorkers(nickName);
		if (allWorkers != null) {			
			request.setAttribute("allWorkers", allWorkers);
			if (nickName.equals("admin")) {
				goToPage = JspPagePath.ADMIN_PAGE_PATH;
			}else if (nickName.equals("Boss")) {
				goToPage = JspPagePath.BOSS_PAGE;
			}else {
				goToPage = JspPagePath.WORKER_PAGE;
			}
			
		}else {
			goToPage = JspPagePath.WORKER_PAGE;
			message = "Workers not found";
			request.setAttribute("message", message);
			request.setAttribute("nickName", nickName);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
		
		
	}		
	

}
