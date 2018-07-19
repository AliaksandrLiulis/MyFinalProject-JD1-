package by.myProject.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import by.myProject.been.User;
import by.myProject.dao.exception.DAOException;

public interface IDaoUser {
	User checkUser(String nickName, String password) throws DAOException;
	User addUser(List<String> allParams);
	ArrayList<User> showAllBase();
	boolean DoActionWithUser(String nickName, int i);
	
}
