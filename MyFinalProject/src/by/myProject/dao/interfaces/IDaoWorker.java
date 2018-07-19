package by.myProject.dao.interfaces;

import java.util.ArrayList;

import by.myProject.been.Worker;

public interface IDaoWorker {
	boolean addWorker(Worker worker);
	ArrayList<Worker> showWorker(String userNickNameWhoAdded);
	boolean DoActionWithWorker(String name, int i);

}
