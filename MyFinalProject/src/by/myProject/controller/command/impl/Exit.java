package by.myProject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myProject.controller.command.commandInterfaces.ICommand;

public class Exit implements ICommand {
	String goToPage  = JspPagePath.EXIT;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
		
	}

}
