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
   <h3>Product List</h3>
   <p style="color: red;">${errorString}</p>
<form >
           <a href="${pageContext.request.contextPath}/addProduct">Add Product</a> 
           <a href="">View Product</a>
           <a href="${pageContext.request.contextPath}/deleteProduct">Delete Product</a>
           <a href="">Update Product </a>
           <a href="${pageContext.request.contextPath}/">Cancel</a>
              </td>
           </tr>
        </table>
        
     </form>
     