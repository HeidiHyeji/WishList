package DAO;

import java.sql.*;
import java.util.ArrayList;

public class DBProductsDAO implements IDAO {

	private static Connection con;
	private static Statement stmt;

	private static DBProductsDAO uniqueInstance;
	
	public static DBProductsDAO getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new DBProductsDAO();
		}
		return uniqueInstance;
	}
	
	public DBProductsDAO() {
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
	public void addObject(Object products) {
		// TODO Auto-generated method stub
		
		String sql="insert into products values('"
				+((ProductsBean) products).getPro_url()+"','"
				+((ProductsBean) products).getPro_name()+"', '"
				+((ProductsBean) products).getPro_price()+"', '"
				+((ProductsBean) products).getImg_id()+"', '"
				+((ProductsBean) products).getCategory_id()+"')";
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			disconnect();
		}catch(Exception e){
		}
	}

	@Override
	public Object getObject(String pro_url) {
		// TODO Auto-generated method stub
		String sql="select * from products where pro_url="+pro_url;
		ProductsBean products=new ProductsBean();
		try{
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			products.setPro_url(rs.getString("pro_url"));
			products.setPro_name(rs.getString("pro_name"));
			products.setPro_price(rs.getInt("pro_price"));
			products.setImg_id(rs.getString("img_id"));
			products.setCategory_id(rs.getString("category_id"));
			rs.close();
			disconnect();
		}catch(Exception e){}
		return products;
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
				ProductsBean products =new ProductsBean();
				products.setPro_url(rs.getString("pro_url"));
				products.setPro_name(rs.getString("pro_name"));
				products.setPro_price(rs.getInt("pro_price"));
				products.setImg_id(rs.getString("img_id"));
				products.setCategory_id(rs.getString("category_id"));
				list.add(products);
			}
			rs.close();
			disconnect();
		}catch(Exception e){}
		return list;
	}


}
