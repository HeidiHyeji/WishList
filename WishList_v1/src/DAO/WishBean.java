package DAO;

import java.sql.Date;
public class WishBean {
	private String user_id;
	private String pro_url;
	private Date  wish_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPro_url() {
		return pro_url;
	}
	public void setPro_url(String pro_url) {
		this.pro_url = pro_url;
	}
	public Date getWish_date() {
		return wish_date;
	}
	public void setWish_date(Date wish_date) {
		this.wish_date = wish_date;
	}
	public WishBean() {
		// TODO Auto-generated constructor stub
	}

}
