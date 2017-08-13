package WebAssess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import WebAssess.dao.IUserDao;
import WebAssess.domain.Apply;
import WebAssess.domain.Info;
import WebAssess.domain.Results;
import WebAssess.domain.User;
import WebAssess.exception.DaoException;
import WebAssess.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {

	public void add(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String insertsql = "INSERT INTO person(id,username,userpass,usernick,age,sex,grade,direction,phone,email) VALUES (?,?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(insertsql);
			st.setString(1, user.getId());
			st.setString(2, user.getusername());
			st.setString(3, user.getUserpass());
			st.setString(4, user.getUsernick());	
			st.setString(5, user.getAge());
			st.setString(6, user.getSex());
			st.setString(7, user.getGrade());
			st.setString(8, user.getDirection());
			st.setString(9, user.getPhone());
			st.setString(10, user.getEmail());
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("注册用户失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public User find(String username, String userpass) {
		Connection conn = null;
		PreparedStatement st = null; // PreparedStatement预防SQL注入
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM person WHERE username=? and userpass=?";
			st = conn.prepareStatement(selectsql); // 预编译这条sql语句
			st.setString(1, username);
			st.setString(2, userpass);
			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setusername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setUsernick(rs.getString("usernick"));
				user.setUseridentity(rs.getString("useridentity"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setGrade(rs.getString("grade"));
				user.setDirection(rs.getString("direction"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public List findAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list=new ArrayList(); 
		try {
			
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM person";
			st = conn.prepareStatement(selectsql);
			rs = st.executeQuery();
			int count=0;
			while(rs.next()) {
				User user=new User(); 
				System.out.println("count="+count++);
				user.setusername(rs.getString("username"));
				user.setUsernick(rs.getString("usernick"));
				user.setUseridentity(rs.getString("useridentity"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setGrade(rs.getString("grade"));
				user.setDirection(rs.getString("direction"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				list.add(user);
		   }
			return list;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

	@Override
	public User find(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM person WHERE username=?";
			st = conn.prepareStatement(selectsql);
			st.setString(1, username);
			rs = st.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setusername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setUsernick(rs.getString("usernick"));
				user.setUseridentity(rs.getString("useridentity"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setGrade(rs.getString("grade"));
				user.setDirection(rs.getString("direction"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	@Override
	public List find1(String direction) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list=new ArrayList();
		try {
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM person WHERE direction=?";
			st = conn.prepareStatement(selectsql);
			st.setString(1, direction);
			rs = st.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setusername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setUsernick(rs.getString("usernick"));
				user.setUseridentity(rs.getString("useridentity"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setGrade(rs.getString("grade"));
				user.setDirection(rs.getString("direction"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}
	@Override
	public List find2(String useridentity) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list=new ArrayList();
		try {
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM person WHERE useridentity=?";
			st = conn.prepareStatement(selectsql);
			st.setString(1, useridentity);
			rs = st.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setusername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setUsernick(rs.getString("usernick"));
				user.setUseridentity(rs.getString("useridentity"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setGrade(rs.getString("grade"));
				user.setDirection(rs.getString("direction"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	@Override
	public void update(String username,String usernick,String age,String sex,String grade,String direction,String phone,String email) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String updatesql = "UPDATE person SET  usernick=?,age=?,sex=?,grade=?,direction=?,phone=?,email=?  WHERE username=?";
			st = conn.prepareStatement(updatesql);
			st.setString(1, usernick);
			st.setString(2, age);
			st.setString(3,sex);
			st.setString(4, grade);
			st.setString(5, direction);
			st.setString(6, phone);
			st.setString(7, email);
			st.setString(8, username);
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("修改信息失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public void delete(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String deletesql = "DELETE  FROM person WHERE username=?";
			st = conn.prepareStatement(deletesql);
			st.setString(1, username);
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("删除信息失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public void update1(String username, String useridentity) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String updatesql = "UPDATE  person SET  useridentity=? WHERE username=?";
			st = conn.prepareStatement(updatesql);
			st.setString(1, useridentity);
			st.setString(2, username);
			int num = st.executeUpdate();
			if (num < 1) {
				throw new DaoException("设置身份失败！！！");			
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}
	
	@Override
	public void update2(String username, String userpass) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String updatesql = "UPDATE person SET userpass=?  WHERE username=?";
			st = conn.prepareStatement(updatesql);
			st.setString(1, userpass);
			st.setString(2, username);
			int num = st.executeUpdate();		
			if (num < 1) {
				throw new DaoException("修改信息失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

	@Override
	public void add(Apply apply) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String insertsql = "INSERT INTO apply(id,username,applyidentity) VALUES (?,?,?)";
			st = conn.prepareStatement(insertsql);
			st.setString(1, apply.getId());
			st.setString(2, apply.getUsername());
			st.setString(3, apply.getApplyidentity());
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("注册用户失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

	@Override
	public List Applyall() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list=new ArrayList(); 
		try {
			
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM apply";
			st = conn.prepareStatement(selectsql);
			rs = st.executeQuery();
			int count=0;
			while(rs.next()) {
				Apply apply=new Apply(); 
				apply.setId(rs.getString("id"));
				apply.setUsername(rs.getString("username"));
				apply.setApplyidentity(rs.getString("applyidentity"));
				list.add(apply);
		   }
			return list;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public void add(Info info) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String insertsql = "INSERT INTO info(id,information) VALUES (?,?)";
			st = conn.prepareStatement(insertsql);
			st.setString(1, info.getId());
			st.setString(2, info.getInformation());
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("发布消息失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

	@Override
	public List Infoall() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list=new ArrayList(); 
		try {
			
			conn = JdbcUtils.getConnection();
			String selectsql = "SELECT * FROM info";
			st = conn.prepareStatement(selectsql);
			rs = st.executeQuery();
			int count=0;
			while(rs.next()) {
				Info info=new Info(); 
				info.setId(rs.getString("id"));
				info.setInformation(rs.getString("information"));
				list.add(info);
		   }
			return list;
		} catch (Exception e) {
			// 异常直接往上面抛，除了给上层带来麻烦，没有任何好处，所以可将异常转型然后往业务层抛
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public void add(Results results) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String insertsql = "INSERT INTO results(username,NO1,NO2,NO3,NO4,NO5,NO6,NO7) VALUES (?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(insertsql);
			st.setString(1, results.getUsername());
			st.setString(2, results.getNO1());
			st.setString(3, results.getNO2());
			st.setString(4, results.getNO3());	
			st.setString(5, results.getNO4());
			st.setString(6, results.getNO5());
			st.setString(7, results.getNO6());
			st.setString(8, results.getNO7());
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("录入成绩失败！！！");
			}
		} catch (Exception e) {

			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

	
}