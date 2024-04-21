package c3p0.dao.Impl;

import c3p0.dao.UserDao;
import c3p0.util.c3p0Util;
import c3p0.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
	private QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());

	@Override
	public Boolean addUser(User user) throws SQLException {
		String sql = "insert into user value(?,?,?,?,?)";
		Object[] params = {
				user.getUid(), user.getName(),
				user.getPassword(), user.getRole(),
				user.getStatus()
		};
		return queryRunner.update(sql, params) > 0;
	}

	@Override
	public Boolean deleteUser(int uid) throws SQLException {
		String sql = "delete from user where uid = ?";
		return queryRunner.update(sql, uid) > 0;
	}

	@Override
	public Boolean updateUser(User user) throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("update user set name = ?,password = ?,role = ?,status = ? where uid = ?");
		Object[] params = {
				user.getName(), user.getPassword(),
				user.getRole(), user.getStatus(),
				user.getUid()
		};
		return queryRunner.update(sb.toString(), params) > 0;
	}

	@Override
	public User findUser(int uid) throws SQLException {
		String sql = "select * from user where uid = ?";
		return queryRunner.query(sql, new BeanHandler<User>(User.class), uid);
	}

	@Override
	public List<User> findAllUser() throws SQLException {
		String sql = "select * from user";
		return queryRunner.query(sql, new BeanListHandler<>(User.class));
	}
}
