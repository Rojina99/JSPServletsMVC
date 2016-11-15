<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "dto.UserDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Login</title>
</head>
<body>

<h1><b>Login Successful!!</b></h1>

<!-- 
Replacing Scriptlet tag with JSTL(Java Standard Tag Library) 
// // UserDetails ud = (UserDetails) session.getAttribute("user"); 
//    UserDetails ud = (UserDetails) request.getAttribute("user");
 -->

<jsp:useBean id="user" class="dto.UserDetails" scope="request"> 
<!-- If there is already the object with attribute user then the jsp set property line
will not be executed else it will set object as user and execute property and name tag below-->
<jsp:setProperty property="userName" name="user" value="NewUser"/>
</jsp:useBean>


<%-- <h3>You have Successfully Logged In : <%=user.getUserName() %> </h3> --%>

<!-- It is used to get the property value of the beans that we have defined using 
the use bean tag -->

<h3>You have Successfully Logged In :<jsp:getProperty property="userName" name="user"/>
</h3>


</body>
</html>