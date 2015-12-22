<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">    
    <head>   
        <title>Login.jsp</title>   
    </head>   
    <body style="background:url('images/RegisterUser.jpg') no-repeat;">
       <div align="center"> 
            <font face="Eras Bold ITC" size="7" color="#00ffff">Welcome to IFTTT</font></div><h6><br><font face="Eras Bold ITC" size="7"> </font></h6>
            <table style="width: 400px;" align="center">
            	<form method="get" action="CheckInfo">   
                <tr>   
                    <td><font size="6">用户名:</font></td>   
                        <td align="center"><font size="6"><input type="text" name="username" size=30 style= "height:30px font-size:30px;"></font></td>   
  
                </tr>   
                <tr>   
                    <td><font size="6">密&nbsp;&nbsp;码:</font></td>   
                    <td align="center"><font size="6"><input type="password" name="password" size=30 style= "height:30px  font-size:30px;"></font></td> 
                </tr>   
                <tr>      
                    <td align="center">
						<input type="submit" name="submit1" value="登陆" style= "height:30px; width=80px">
					</form> 
                    </td>                  
                    <td align="center">
                    <form method="post" action="RegisterUser.jsp">
                        <input type="submit" name="submit2" value="注册" style= "height:30px; width=80px">
                    </form>
                    </td>   
                </tr> 
                <tr align="center">   
                    <h5 style="font-weight: normal;"><font color="#000000"><em>提示：</em></font></h5>   
                </tr>   
                <tr align="center">   
                    <h5 style="font-weight: normal;"><font color="#000000"><em>如果有已注册请直接登录</em></font></h5>   
                </tr>   
                <tr>   
                    <h5 style="font-weight: normal;" align="center"><font color="#000000"><em>如果没有注册请直接注册</em></font></h5>   
                </tr>     
            </table>      
    </body>   
</html>   

