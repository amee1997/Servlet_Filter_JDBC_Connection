<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
      <jsp:include page = "_header.jsp"></jsp:include>
      <jsp:include page = "_menu.jsp"></jsp:include>
      <h2>Home page</h2>
      <p>Welcome to Home page</p>
      <ul>
          <li>Login</li>
          <li>Add Product</li>
          <li>Delete Product</li>
          <li>Edit Product Name</li>
          <li>Update Product</li>
      </ul>
     <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>