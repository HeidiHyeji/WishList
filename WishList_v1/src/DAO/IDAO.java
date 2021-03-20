package DAO;
import java.util.ArrayList;

public interface IDAO {
	
	public void addObject(Object event);
	public Object getObject(String id);
	public ArrayList<Object> getAllObject();
}
