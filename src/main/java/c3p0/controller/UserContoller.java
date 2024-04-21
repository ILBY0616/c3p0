package c3p0.controller;

import c3p0.dao.Impl.UserDaoImpl;
import c3p0.dao.UserDao;
import c3p0.pojo.User;

import java.sql.SQLException;

public class UserContoller {
	public static void main(String[] args) throws SQLException {
		UserDao userDao = new UserDaoImpl();

		userDao.addUser(new User(4, "赵六", "654321", "消费者", "正常"));
		userDao.addUser(new User(5, "钱七", "123456", "消费者", "正常"));
		for(User user:userDao.findAllUser()){
			System.out.println(user);
		}

		userDao.deleteUser(5);
		userDao.updateUser(new User(4, "赵六", "123456", "消费者", "正常"));
		for(User user:userDao.findAllUser()){
			System.out.println(user);
		}
	}
}
