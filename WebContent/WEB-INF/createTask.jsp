<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>   
    <head>
     <link rel="stylesheet" type="text/css" href="css/Login.css" />
<body style="background:url('images/backgroup1.jpg') no-repeat;">   
        <title>createTask.jsp</title>   
    </head>   
    <body style="background:url('images/RegisterUser.jpg') no-repeat;">
    <form method="post" action="CheckTaskType">
       <div align="left"> 
            <font face="Eras Bold ITC" size="6" color="#00ffff">choose the task</font></div><h6><br><font face="Eras Bold ITC" size="7"> </font></h6>
            <table style="width: %100;" align="left">
                <tr>   
                    <td><font size="6">IF THIS:</font></td>   
                    <td>
                    	<select name="this" size=1 multiple>
		  				<option>请选择THIS事件</option>
		  				<option>Clock</option>
		  				<option>Gmail</option>
		  				<option>Weibo</option>
						</select>
                    </td>
  				</tr>   
                <tr>   
                    <td><font size="6">THEN THAT:</font></td>   
                    <td>
                    	<select name="that" size=1 multiple>
		  				<option>请选择THAT事件</option>
		  				<option>Weibo</option>
		  				<option>Gmail</option>
						</select>
                    </td>
                </tr>   
                <tr>      
                    <td align="center">
						<input type="submit" name="submit1" value="确认" style= "height:30px; width=80px">
                    </td>                  
                    <td align="center">
                        <input type="reset" name="submit2" value="重置" style= "height:30px; width=80px">
                    </td>   
                </tr>    
            </table>
    </form>      
    </body>   
</html>   


