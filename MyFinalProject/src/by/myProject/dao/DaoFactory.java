package by.myProject.dao;

import by.myProject.dao.iml.SQLUserDAOImpl;
import by.myProject.dao.iml.SQLWorkerDAOImpl;
import by.myProject.dao.interfaces.IDaoUser;
import by.myProject.dao.interfaces.IDaoWorker;

public class DaoFactory {
	private static final DaoFactory DAO_FACTORY = new DaoFactory();
	
	private DaoFactory() {}
	
	private IDaoUser daoUser = new SQLUserDAOImpl();
	private IDaoWorker daoWorker = new SQLWorkerDAOImpl();
	
	
	public IDaoUser getDaoUser() {
		return daoUser;
	}

	public static DaoFactory getDaoFactory() {
		return DAO_FACTORY;
	}

	public IDaoWorker getDaoWorker() {
		return daoWorker;
	}	
}
