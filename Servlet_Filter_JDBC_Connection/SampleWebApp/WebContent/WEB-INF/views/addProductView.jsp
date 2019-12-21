<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Login</title>
 </head>
 <body>
   <jsp:include page="_header.jsp"></jsp:include>
   <jsp:include page="_menu.jsp"></jsp:include>
   <h3>Please Add your product here!!</h3>
   <p style="color: red;">${errorString}</p>
<form method="POST" action="${pageContext.request.contextPath}/addProduct">
     <table border="0">
          <tr>
             <td>Product ID</td>
 <td><input type="text" name="id" value= "${add.id}" /> </td>
           </tr>
           <tr>
              <td>Product Name</td>
<td><input type="text" name="pname" value= "${add.pname}" /> </td>
           </tr>
           <tr>
             <td>Product Quantity</td>
 <td><input type="text" name="quantity" value= "${add.quantity}" /> </td>
           </tr>
           <tr>
           <td>Price</td>
 <td><input type="text" name="price" value= "${add.price}" /> </td>
           </tr>
           <tr>
              <td colspan ="2">
                 <input type="submit" value="Submit" />
                 <a href="${pageContext.request.contextPath}/">Cancel</a>
              </td>
           </tr>
        </table>
        
     </form>
     