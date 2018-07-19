package by.myProject.controller.command.commandInterfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
