package DAO;

import java.sql.*;
import java.util.ArrayList;

public class DBCategoryDAO implements IDAO {

	private static Connection con;
	private static Statement stmt;

	private static DBCategoryDAO uniqueInstance;
	
	public static DBCategoryDAO getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new DBCategoryDAO();
		}
		return uniqueInstance;
	}
	
	public DBCategoryDAO() {
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
	public void addObject(Object category) {
		// TODO Auto-generated method stub
		
		String sql="insert into category values('"
				+((CategoryBean) category).getCategory_id()+"','"
				+((CategoryBean) category).getCategory_name()+"')";
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			disconnect();
		}catch(Exception e){
		}
	}

	@Override
	public Object getObject(String category_id) {
		// TODO Auto-generated method stub
		String sql="select * from category where category_id="+category_id;
		CategoryBean category=new CategoryBean();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			category.setCategory_id(rs.getString("category_id"));
			category.setCategory_name(rs.getString("category_name"));
			rs.close();
			disconnect();
		}catch(Exception e){}
		return category;
	}

	@Override
	public ArrayList<Object> getAllObject() {
		// TODO Auto-generated method stub
		String sql ="select * from category";
		ArrayList<Object> list=new ArrayList<Object>();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				CategoryBean category =new CategoryBean();
				category.setCategory_id(rs.getString("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				list.add(category);
			}
			rs.close();
			disconnect();
		}catch(Exception e){}
		return list;
	}


}
