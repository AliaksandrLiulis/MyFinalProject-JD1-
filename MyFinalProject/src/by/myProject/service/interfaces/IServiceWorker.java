package by.myProject.service.interfaces;

import java.util.ArrayList;

import by.myProject.been.Worker;

public interface IServiceWorker {
	String addWorker(String name, String surname, String profession, String age, String experience, String salary,
			String admission, String userNickNameWhoAdded);
			ArrayList<Worker> showWorkers(String nickName);
			boolean removeWorker(String name, int i);
}
