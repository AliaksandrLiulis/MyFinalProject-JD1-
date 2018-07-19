package by.myProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.myProject.been.User;
import by.myProject.dao.DaoFactory;
import by.myProject.dao.exception.DAOException;
import by.myProject.dao.interfaces.IDaoUser;
import by.myProject.service.exception.ServiceException;
import by.myProject.service.interfaces.IServiceUser;

public class ServiseUserImpl implements IServiceUser {

	@Override
	public User sign_In(String nickName, String password) throws ServiceException {
		User user = null;
		if (!nickName.trim().isEmpty() && !password.trim().isEmpty()) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory();
			IDaoUser daoUser = daoFactory.getDaoUser();

			try {
				user = daoUser.checkUser(nickName, password);
			} catch (DAOException e) {
				throw new ServiceException("message" + "change" + e);
			}

		} else {
			user = new User();
			user.setRole("NONE");
		}

		return user;
	}

	@Override
	public User registrUser(List<String> paramsRequest) throws ServiceException {
		User user = null;
		String name = paramsRequest.get(0);
		String surName = paramsRequest.get(1);
		String nickName = paramsRequest.get(2);
		String sex = paramsRequest.get(3);
		String age = paramsRequest.get(4);
		String email = paramsRequest.get(5);
		String specialty = paramsRequest.get(6);
		String organize = paramsRequest.get(7);
		String password = paramsRequest.get(8);
		String allow = paramsRequest.get(9);

		DaoFactory daoFactory = DaoFactory.getDaoFactory();
		IDaoUser daoUser = daoFactory.getDaoUser();
		if (!name.trim().isEmpty() && !surName.trim().isEmpty() && !nickName.trim().isEmpty() && !sex.trim().isEmpty()
				&& !age.trim().isEmpty() && !email.trim().isEmpty() && !specialty.trim().isEmpty()
				&& !organize.trim().isEmpty() && !password.trim().isEmpty() && !allow.trim().isEmpty()) {
			user = daoUser.addUser(paramsRequest);
			if (user == null) {
				return null;
			} else {
				return user;
			}

		} else {
			throw new ServiceException("Param's isn't correct");
		}
	}
	
	

	@Override
	public void sign_Out(String nickName) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<User> showAllUsers(String role) {
		if (role.toUpperCase().equals("ADMIN")) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory();
			IDaoUser daoUser = daoFactory.getDaoUser();
			ArrayList<User> allUsers = daoUser.showAllBase();
			if(allUsers.size() == 0) {
				return null;
			}
			return allUsers;
		}		
		return null;
	}

	@Override
	public boolean doAction(String nickName, int i) {
		boolean action = false;
		if (nickName.trim() != null) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory();
			IDaoUser daoUser = daoFactory.getDaoUser();
			return action = daoUser.DoActionWithUser(nickName, i);
		}
		return action;
		
	}
}
