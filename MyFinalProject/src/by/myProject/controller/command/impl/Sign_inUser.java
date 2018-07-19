package by.myProject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.myProject.been.User;
import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.service.ServiceFactory;
import by.myProject.service.exception.ServiceException;
import by.myProject.service.interfaces.IServiceUser;

public class Sign_inUser implements ICommand {
	private static final String COMAND_NICKNAME_NAME = "nickName";
	private static final String COMAND_PASSWORD_NAME = "password";
	private static final String COMMAND_WITHOUT_VALUE = "NONE";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		String nickName = request.getParameter(COMAND_NICKNAME_NAME);
		String password = request.getParameter(COMAND_PASSWORD_NAME);
		ServiceFactory factory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = factory.getServiceUser();
		User user = null;
		String goToPage = null;

		try {
			user = serviceUser.sign_In(nickName, password);
			if (user != null && user.getRole().equals(COMMAND_WITHOUT_VALUE)) {
				request.setAttribute("errorMessage", "Params isn't correct");
				goToPage = JspPagePath.MAIN_PAGE_PATH;

			} else if (user != null) {
				request.getSession(true).setAttribute("user", user);
				if (user.getAvaliable() == 1) {
					goToPage = JspPagePath.ADMIN_PAGE_PATH;
				}else {
					request.setAttribute("errorMessage", "Please expect while administrator will check Your data.");
					goToPage = JspPagePath.MAIN_PAGE_PATH;
				}				
			} else {
				request.setAttribute("errorMessage", "Incorrect login or password.User not found.");
				goToPage = JspPagePath.MAIN_PAGE_PATH;
			}
		} catch (ServiceException e) {
			// goToPage = JspPagePath.ERR_PAGE_PATH;
			// log
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
