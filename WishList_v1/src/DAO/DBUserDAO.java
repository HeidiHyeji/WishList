package DAO;

import java.sql.*;
import java.util.ArrayList;

public class DBUserDAO implements IDAO {

	private static Connection con;
	private static Statement stmt;

	private static DBUserDAO uniqueInstance;
	
	public static DBUserDAO getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new DBUserDAO();
		}
		return uniqueInstance;
	}
	
	public DBUserDAO() {
		con = Connectivity.getConnection("properties/wishlist.properties");
	}
	public static Connection getConnection() {
		return con;
	}
	private void disconnect() {
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void addObject(Object user) {
		// TODO Auto-generated method stub
		
		String sql="insert into user values('"
				+((UserBean) user).getUser_name()+"','"
				+((UserBean) user).getUser_id()+"', '"
				+((UserBean) user).getUser_pwd()+"')";
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			disconnect();
		}catch(Exception e){
		}
	}

	@Override
	public Object getObject(String user_id) {
		// TODO Auto-generated method stub
		String sql="select * from user where user_id="+user_id;
		UserBean user=new UserBean();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_pwd(rs.getString("user_pwd"));
			rs.close();
			disconnect();
		}catch(Exception e){}
		return user;
	}

	@Override
	public ArrayList<Object> getAllObject() {
		// TODO Auto-generated method stub
		String sql ="select * from user";
		ArrayList<Object> list=new ArrayList<Object>();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				UserBean user =new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_pwd(rs.getString("user_pwd"));
				list.add(user);
			}
			rs.close();
			disconnect();
		}catch(Exception e){}
		return list;
	}


}
