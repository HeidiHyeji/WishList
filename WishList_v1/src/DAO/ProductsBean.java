/**
 * 
 */
package DAO;

/**
 * @author gogo6
 *
 */
public class ProductsBean {
	private String pro_url;
	private String pro_name;
	private int pro_price;
	private String img_id;
	private String category_id;
	/**
	 * 
	 */
	
	public ProductsBean() {
		// TODO Auto-generated constructor stub
	}
	public String getPro_url() {
		return pro_url;
	}
	public void setPro_url(String pro_url) {
		this.pro_url = pro_url;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public String getImg_id() {
		return img_id;
	}
	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

}
