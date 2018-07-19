package by.myProject.dao.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.myProject.been.User;
import by.myProject.dao.connectionpool.ConnectionPool;
import by.myProject.dao.exception.DAOException;
import by.myProject.dao.interfaces.IDaoUser;
import resources.Log;

public class SQLUserDAOImpl implements IDaoUser {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public User checkUser(String nickName, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		User user = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(
					"select name, surname, nickName, role, avaliable from users where nickName=? and password=?");
			preparedStatement.setString(1, nickName);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();

			if (result.next()) {
				user = createUser(result.getString(1), result.getString(2), result.getString(3), null, null, null, null,
						result.getString(4), Integer.valueOf(result.getString(5)));
			}

		} catch (SQLException | InterruptedException e) {
			throw new DAOException("message for change" + e);

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
		return user;
	}

	@Override
	public User addUser(List<String> allParams) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		User user = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("select nickName from users where nickName=?");
			preparedStatement.setString(1, allParams.get(2));
			result = preparedStatement.executeQuery();

			if (result.next()) {
				return null;
			} else {
				preparedStatement.close();
				preparedStatement = connection.prepareStatement(
						"INSERT into users (name, surname, nickName, sex, email, speciality, organize, password, role,avaliable ) VALUES (?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, allParams.get(0));
				preparedStatement.setString(2, allParams.get(1));
				preparedStatement.setString(3, allParams.get(2));
				preparedStatement.setString(4, allParams.get(3));
				preparedStatement.setString(5, allParams.get(5));
				preparedStatement.setString(6, allParams.get(6));
				preparedStatement.setString(7, allParams.get(7));
				preparedStatement.setString(8, allParams.get(8));
				preparedStatement.setString(9, allParams.get(6));
				preparedStatement.setInt(10, 0);
				preparedStatement.executeUpdate();

				user = createUser(allParams.get(0), allParams.get(1), allParams.get(2), null, null, null, null,
						allParams.get(8), 0);
			}
		} catch (SQLException | InterruptedException e) {
			// TODO: handle exception
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
		return user;
	}

	@Override
	public ArrayList<User> showAllBase() {
		Log log = new Log();
		log.writeLog("qwer");
		
		log.writeLog("sdfdf");
		ArrayList<User> allUser = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		User user = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("select * from users");
			result = preparedStatement.executeQuery();
			while (result.next()) {

				user = createUser(result.getString(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7), result.getString(8), result.getString(10),
						result.getInt(11));
				allUser.add(user);

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

		return allUser;
	}

	private User createUser(String name, String surname, String nickName, String sex, String email, String speciality,
			String organize, String role, int avaliable) {
		User user = new User(name, surname, nickName, sex, email, speciality, organize, role, avaliable);
		return user;

	}

	@Override
	public boolean DoActionWithUser(String nickName, int i) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement("UPDATE users  SET avaliable=? where nickName=?");
			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, nickName);

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
