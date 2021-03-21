package DAO;

import java.sql.*;
import java.util.ArrayList;

public class DBImagesDAO implements IDAO {

	private static Connection con;
	private static Statement stmt;

	private static DBImagesDAO uniqueInstance;
	
	public static DBImagesDAO getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new DBImagesDAO();
		}
		return uniqueInstance;
	}
	
	public DBImagesDAO() {
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
	public void addObject(Object image) {
		// TODO Auto-generated method stub
		
		String sql="insert into images values('"
				+((ImagesBean) image).getImg_id()+"','"
				+((ImagesBean) image).getImg()+"', '"
				+((ImagesBean) image).getImg_title()+"', '"
				+((ImagesBean) image).getImg_width()+"', '"
				+((ImagesBean) image).getImg_height()+"', '"
				+((ImagesBean) image).getImg_filesize()+"')";
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			disconnect();
		}catch(Exception e){
		}
	}

	@Override
	public Object getObject(String img_id) {
		// TODO Auto-generated method stub
		String sql="select * from images where img_id="+img_id;
		ImagesBean images=new ImagesBean();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			images.setImg_id(rs.getString("pro_url"));
			images.setImg(rs.getBlob("img"));
			images.setImg_title(rs.getString("img_title"));
			images.setImg_width(rs.getInt("img_width"));
			images.setImg_height(rs.getInt("img_height"));
			images.setImg_filesize(rs.getInt("img_filesize"));
			rs.close();
			disconnect();
		}catch(Exception e){}
		return images;
	}

	@Override
	public ArrayList<Object> getAllObject() {
		// TODO Auto-generated method stub
		String sql ="select * from products";
		ArrayList<Object> list=new ArrayList<Object>();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				ImagesBean images =new ImagesBean();
				images.setImg_id(rs.getString("pro_url"));
				images.setImg(rs.getBlob("img"));
				images.setImg_title(rs.getString("img_title"));
				images.setImg_width(rs.getInt("img_width"));
				images.setImg_height(rs.getInt("img_height"));
				images.setImg_filesize(rs.getInt("img_filesize"));
				list.add(images);
			}
			rs.close();
			disconnect();
		}catch(Exception e){}
		return list;
	}


}
