package com.face.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import com.face.bo.UserAccount;
import com.face.bo.UserProduct;


public class DBUtils {
	
	String id; String pname; String quantity; String price;
	public static UserAccount findUser(Connection conn, //
	           String userName, String password) throws SQLException {
	       String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
	               + " where a.User_Name = ? and a.password= ?";
	       PreparedStatement pstm = conn.prepareStatement(sql);
	       pstm.setString(1, userName);
	       pstm.setString(2, password);
	       ResultSet rs = pstm.executeQuery();
	       if (rs.next()) {
	           String gender = rs.getString("Gender");
	           UserAccount user = new UserAccount();
	           user.setUserName(userName);
	           user.setPassword(password);
	           user.setGender(gender);
	           return user;
	       }
	       return null;
	   }
	public static UserProduct insertProduct(Connection conn, String id, String pname, String quantity, String price) throws SQLException {
		// TODO Auto-generated method stub throws SQLException {
	 String id1=id;
	 String pname1=pname;
	 String quantity1=quantity;
	 String price1=price;
	 
		  String sq = "insert into product (id,productname,quantity,price) values ('"+id1+"','"+pname1+"','"+quantity1+"','"+price1+"')";
		  
	       PreparedStatement pst = conn.prepareStatement(sq);
	      
	       int rs = pst.executeUpdate(sq);
	        if (rs==1) {
	           UserProduct add = new UserProduct();
	           add.setId(id1);
	           add.setPname(pname1);
	           add.setQuantity(quantity1);
	           add.setPrice(price1);
	           return add;
	       }
	      
	
		return null;
	}
}