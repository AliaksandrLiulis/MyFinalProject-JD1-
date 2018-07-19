package by.myProject.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import by.myProject.been.User;
import by.myProject.dao.exception.DAOException;
import by.myProject.service.exception.ServiceException;

public interface IServiceUser {
	User registrUser(List<String> paramsRequest) throws ServiceException;

	User sign_In(String nickName, String password) throws ServiceException;

	void sign_Out(String nickName) ;
	
	ArrayList<User> showAllUsers(String role) ;
	
	boolean doAction(String nickName, int i);

}
