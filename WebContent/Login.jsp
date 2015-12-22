<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IFTTT用户登录</title>
</head>
 <link rel="stylesheet" type="text/css" href="css/Login.css" />
<body style="background:url('images/backgroup1.jpg') no-repeat;">

       <div align="center"> 
            <p><font face="Eras Bold ITC" size="7" color= gray>Welcome to IFTTT</font><br>
            <font face="Eras Bold ITC" size="7"> </font></p>
       </div>
       
       
<div align="center">
<p><img src="images/user.png" alt=""/></p>
<form method="get" action="CheckInfo"> 
<table width="320" height="161" border="1">

<!-- 第一行 -->
  <tr>
    <th width="68" scope="col">&nbsp; <div align="center"> 用户名 </div></th>
    
    <th width="236" scope="col">&nbsp;<div align="center"> <input name="username" type="text" id="user" /> </div></th>
  </tr>
  
  <!-- 第二行 -->
  <tr>
    <th scope="row">&nbsp;<div align="center"> 用户名 </div></th>
    <th scope="col">&nbsp;<div align="center"> <input name="password" type="text" id="pwd" /> </div></th>
  </tr>
  
  
  
    <!-- 第三行 -->
   <tr>
    <td scope="row">&nbsp; <input type="submit" name="submit" value="登录" /> </td>
  </tr>
     <!-- 第四行 -->
   <tr>
    <td scope="row">&nbsp; <a href="RegisterUser.jsp"><input type="submit" name="Submit" value="注册" /></a> </td>
  </tr>
</table>
</form>
</div>
</body>   
</html>