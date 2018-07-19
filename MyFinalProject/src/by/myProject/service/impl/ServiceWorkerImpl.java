package by.myProject.service.impl;

import java.util.ArrayList;

import by.myProject.been.Worker;
import by.myProject.dao.DaoFactory;
import by.myProject.dao.interfaces.IDaoUser;
import by.myProject.dao.interfaces.IDaoWorker;
import by.myProject.service.interfaces.IServiceWorker;

public class ServiceWorkerImpl implements IServiceWorker {

	@Override
	public String addWorker(String name, String surname, String profession, String age, String experience,
			String salary, String admission, String userNickNameWhoAdded) {

		String message = null;

		if (name.trim() != null && surname.trim() != null && profession.trim() != null && age.trim() != null
				&& experience.trim() != null && salary.trim() != null && admission.trim() != null
				&& userNickNameWhoAdded.trim() != null) {
			try {
				Integer.parseInt(age);
				Integer.parseInt(experience);
				Double.parseDouble(salary);
				Integer.parseInt(admission);
			} catch (Exception e) {
				message = "Params Age, Salary, Experience or Admmission aren't correct";
				return message;
			}
			if (Integer.parseInt(age) > 18 && Double.parseDouble(salary) > 0 && Integer.parseInt(experience) >= 0
					&& Integer.parseInt(admission) >= 2018) {
				Worker worker = new Worker(name, surname, profession, Integer.parseInt(age),
						Integer.parseInt(experience), Double.parseDouble(salary), Integer.parseInt(admission),
						userNickNameWhoAdded);
				DaoFactory daoFactory = DaoFactory.getDaoFactory();
				IDaoWorker daoWorker = daoFactory.getDaoWorker();
				if (daoWorker.addWorker(worker)) {
					message = "Worker added";
				}

			} else {
				message = "Params Age, Experience, Salary or Admmission aren't correct";
			}
		} else {
			// Exception
		}
		return message;
	}

	@Override
	public ArrayList<Worker> showWorkers(String userNickNameWhoAdded) {
		ArrayList<Worker> allWorkers = null;
		if (userNickNameWhoAdded.trim() != null) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory();
			IDaoWorker daoWorker = daoFactory.getDaoWorker();
			allWorkers = daoWorker.showWorker(userNickNameWhoAdded);
			if (allWorkers != null) {
				return allWorkers;
			}
		}
		return null;
	}

	@Override
	public boolean removeWorker(String name, int i) {
		boolean action = false;
		if (name.trim() != null) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory();
			IDaoWorker daoWorker = daoFactory.getDaoWorker();
			return action = daoWorker.DoActionWithWorker(name, i);
		}
		return action;
	}
}
