<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
 <link rel="stylesheet" type="text/css" href="css/Login.css" />
<body style="background:url('images/backgroup1.jpg') no-repeat;">
       <div align="center"> 
            <p><font face="Eras Bold ITC" size="7" color= gray>Welcome to IFTTT</font><br>
            <font face="Eras Bold ITC" size="7"> </font></p>
       </div>
<div align="center">
   					
						<img src="images/user.png" alt=""/>
					
  <table width="358" height="110" border="1">
  <tr>
    <th width="65" height="48" scope="col">用户</th>
    <th width="277" scope="col"><form id="form2" name="form2" method="post" action="">
      <label for="ID2"></label>
      <input type="text" name="ID" id="ID2" />
    </form></th>
  </tr>
  <tr>
    <th height="54" scope="col">密码</th>
    <th scope="col"><form id="form3" name="form3" method="post" action="">
      <label for="passwd"></label>
      <input type="text" name="passwd" id="passwd" />
    </form></th>
  </tr>
</table>
</div>
<div align="center">
<form method="post" action="RegisterUser.jsp">
                        <input type="submit" name="submit2" value="注册" style= "height:30px; width=80px">
                    </form>
</div>
</body>   
</html>