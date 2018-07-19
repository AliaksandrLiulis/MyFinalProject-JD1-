package by.myProject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.myProject.controller.command.CommandsProvider;
import by.myProject.controller.command.commandInterfaces.ICommand;
import resources.Log;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_NAME = "command";
	private CommandsProvider provider = new CommandsProvider();
	
  
    public ControllerServlet() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String commandName = request.getParameter(COMMAND_NAME);
		ICommand command = provider.getCommand(commandName);
		command.execute(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}
