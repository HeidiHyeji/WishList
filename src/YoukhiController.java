

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class YoukhiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoukhiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IDAO dao1=new DBProductsDAO();
		IDAO dao2=new DBWishDAO();
		String address=null;
		request.setCharacterEncoding("utf-8");
		
		String action=request.getParameter("action");
		
		if(action.equals("add")){
			ProductsBean products=new ProductsBean();
			products.setPro_url(request.getParameter("pro_url"));
			products.setPro_name(request.getParameter("pro_name"));
			products.setPro_price(Integer.parseInt(request.getParameter("pro_price")));
			dao1.addObject(products);
			request.setAttribute("products", products);
			address="/dashgum/Theme/gallery1.html";
			
			WishBean wish=new WishBean();
			//Date date= new Date();
			wish.setPro_url(request.getParameter("pro_url"));
			//wish.setWish_date(date); java.util.date 라이브러리를 쓰면 문자열 형식으로 저장가능
			dao2.addObject(wish);
			request.setAttribute("wish",  wish);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(address);
		dispatcher.forward(request,  response);
		
	}
}
