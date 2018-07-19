package by.myProject.dao.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.myProject.been.User;
import by.myProject.been.Worker;
import by.myProject.dao.connectionpool.ConnectionPool;
import by.myProject.dao.interfaces.IDaoWorker;

public class SQLWorkerDAOImpl implements IDaoWorker {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean addWorker(Worker worker) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int id = 0;

		String name = worker.getName();
		String surname = worker.getSurname();
		String profession = worker.getProfession();
		int age = worker.getAge();
		int experience = worker.getExperience();
		double salary = worker.getSalary();
		int yearOfAdmission = worker.getYearOfAdmission();
		String userNickNameWhoAdded = worker.getUserNickNameWhoAdded();

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("select * from users where nickName=?");
			preparedStatement.setString(1, userNickNameWhoAdded);

			result = preparedStatement.executeQuery();

			if (result.next()) {
				id = result.getInt(1);
			} else {
				return false;
			}
			preparedStatement.close();

			preparedStatement = connection.prepareStatement(
					"INSERT into workers (name, surname, profession, age, experience, salary, yearOfadmission, avaliable, users_id) VALUES (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, profession);
			preparedStatement.setInt(4, experience);
			preparedStatement.setInt(5, age);
			preparedStatement.setDouble(6, salary);
			preparedStatement.setInt(7, yearOfAdmission);
			preparedStatement.setInt(8, 1);
			preparedStatement.setInt(9, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (InterruptedException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// logError
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// logError
			}
		}
		return false;
	}

	@Override
	public ArrayList<Worker> showWorker(String userNickNameWhoAdded) {
		ArrayList<Worker> allWorker = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Worker worker = null;
		int id = 0;
		int avaliable = 1;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("select * from users where nickName=?");
			preparedStatement.setString(1, userNickNameWhoAdded);

			result = preparedStatement.executeQuery();

			if (result.next()) {
				id = result.getInt(1);
			}
			preparedStatement.close();
			connection.close();
			System.out.println(userNickNameWhoAdded);
			connection = connectionPool.takeConnection();
			if (userNickNameWhoAdded.equals("Boss") || userNickNameWhoAdded.equals("admin")) {
				preparedStatement = connection.prepareStatement("select * from workers");
			}else {
				preparedStatement = connection.prepareStatement("select * from workers where users_id=? ");
				preparedStatement.setInt(1, id);
			}
						
			result = preparedStatement.executeQuery();
			while (result.next()) {
				
				if (result.getInt(9) == avaliable) {
					worker = new Worker(result.getString(2), result.getString(3), result.getString(4), result.getInt(5),
							result.getInt(6), result.getDouble(7), result.getInt(8), userNickNameWhoAdded);
					allWorker.add(worker);
				}				
			}
		} catch (InterruptedException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// logError
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// logError
			}
		}

		return allWorker;
	}

	@Override
	public boolean DoActionWithWorker(String name, int i) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("UPDATE workers SET avaliable=? where surname=?");
			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, name);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// logError
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// logError
			}
		}
		return false;
	}
}
