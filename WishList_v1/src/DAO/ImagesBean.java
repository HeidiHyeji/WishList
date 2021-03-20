package DAO;

import java.sql.Blob;

public class ImagesBean {
	private String img_id;
	private Blob img;
	private String img_title;
	private int img_width;
	private int img_height;
	private int img_filesize;
	
	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public String getImg_title() {
		return img_title;
	}

	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}

	public int getImg_width() {
		return img_width;
	}

	public void setImg_width(int img_width) {
		this.img_width = img_width;
	}

	public int getImg_height() {
		return img_height;
	}

	public void setImg_height(int img_height) {
		this.img_height = img_height;
	}

	public int getImg_filesize() {
		return img_filesize;
	}

	public void setImg_filesize(int img_filesize) {
		this.img_filesize = img_filesize;
	}

	public ImagesBean() {
		// TODO Auto-generated constructor stub
	}

}
