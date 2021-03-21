package DAO;

import java.sql.*;
import java.util.ArrayList;

public class DBWishDAO implements IDAO {

	private static Connection con;
	private static Statement stmt;

	private static DBWishDAO uniqueInstance;
	
	public static DBWishDAO getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new DBWishDAO();
		}
		return uniqueInstance;
	}
	
	public DBWishDAO() {
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
	public void addObject(Object wish) {
		// TODO Auto-generated method stub
		
		String sql="insert into wish values('"
				+((WishBean) wish).getUser_id()+"','"
				+((WishBean) wish).getPro_url()+"', '"
				+((WishBean) wish).getWish_date()+"')";
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
		String sql="select * from wish where user_id="+user_id;
		WishBean wish=new WishBean();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			wish.setUser_id(rs.getString("user_id"));
			wish.setPro_url(rs.getString("pro_url"));
			wish.setWish_date(rs.getDate("wish_date"));
			rs.close();
			disconnect();
		}catch(Exception e){}
		return wish;
	}

	
	public Object getObjectFromUrl(String pro_url) {
		// TODO Auto-generated method stub
		String sql="select * from wish where pro_url="+pro_url;
		WishBean wish=new WishBean();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			wish.setUser_id(rs.getString("user_id"));
			wish.setPro_url(rs.getString("pro_url"));
			wish.setWish_date(rs.getDate("wish_date"));
			rs.close();
			disconnect();
		}catch(Exception e){}
		return wish;
	}

	@Override
	public ArrayList<Object> getAllObject() {
		// TODO Auto-generated method stub
		String sql ="select * from wish";
		ArrayList<Object> list=new ArrayList<Object>();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				WishBean wish =new WishBean();
				wish.setUser_id(rs.getString("user_id"));
				wish.setPro_url(rs.getString("pro_url"));
				wish.setWish_date(rs.getDate("wish_date"));
				list.add(wish);
			}
			rs.close();
			disconnect();
		}catch(Exception e){}
		return list;
	}


}
