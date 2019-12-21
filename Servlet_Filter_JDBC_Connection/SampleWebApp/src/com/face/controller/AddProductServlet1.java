package com.face.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.face.bo.UserAccount;
import com.face.bo.UserProduct;
import com.face.dao.DBUtils;
import com.face.dao.MyUtils;

/**
 * Servlet implementation class AddProductServlet1
 */

@WebServlet(urlPatterns = { "/addProduct"})
public class AddProductServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Add product Servlet");
	       // Forward to /WEB-INF/views/loginView.jsp
	       // (Users can not access directly into JSP pages placed in WEB-INF)
	       RequestDispatcher dispatcher //
	               = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProductView.jsp");
	       dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String id = request.getParameter("id");
		 
	       String pname = request.getParameter("pname");
	       String quantity = request.getParameter("quantity");;
	       String price = request.getParameter("price");
	       UserProduct add = null;
	       boolean hasError = false;
	       String errorString = null;
	       Connection conn = MyUtils.getStoredConnection(request);
	           
	               // Find the user in the DB.
	       try {
               // Find the user in the DB.
               add = DBUtils.insertProduct(conn, id, pname,quantity,price);
               if (add == null) {
                   hasError = true;
                   errorString = "Data not added";
               }
           } catch (SQLException e) {
               e.printStackTrace();
               hasError = true;
               errorString = e.getMessage();
           }
       
    
// If error, forward to /WEB-INF/views/login.jsp
if (hasError) {
    add = new UserProduct();
    add.setId(id);
    add.setPname(pname);
    add.setQuantity(quantity);
    add.setPrice(price);
   
    request.setAttribute("errorString", errorString);
    request.setAttribute("user", add);
   
    RequestDispatcher dispatcher //
            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProductView.jsp");
    dispatcher.forward(request, response);
}

else {
    HttpSession session = request.getSession();
  //  MyUtils.storeLoginedUser(session, add);
    
   
  
    response.sendRedirect(request.getContextPath() + "/product");
}
}

}