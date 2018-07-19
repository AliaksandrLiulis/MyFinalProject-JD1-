package by.myProject.service;

import by.myProject.service.impl.ServiceWorkerImpl;
import by.myProject.service.impl.ServiseUserImpl;
import by.myProject.service.interfaces.IServiceUser;
import by.myProject.service.interfaces.IServiceWorker;

public class ServiceFactory {
	private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
	
	private ServiceFactory() {}
	
	private IServiceUser serviceUser = new ServiseUserImpl();
	private IServiceWorker serviceWorker = new ServiceWorkerImpl();

	public IServiceUser getServiceUser() {
		return serviceUser;
	}

	public static ServiceFactory getServiceFactory() {
		return SERVICE_FACTORY;
	}

	public IServiceWorker getServiceWorker() {
		return serviceWorker;
	}	
	
	
}
