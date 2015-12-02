<%@page language="java"contentType="text/html;charset=gb2312"%> 
<%@page import="Dao.*" %>
<%@page import="Model.*" %>
<%@page import="Model.Task"%>
<%@page import="java.util.ArrayList" %>
<html>   
    <head>   
        <title>system send message </title>   
    </head>   
    <body style="background:url('images/RegisterUser.jpg') no-repeat;">
    <form method="post" action="SysStoreMessage">
       <div align="left"> 
            <font face="Eras Bold ITC" size="5" color="#00ffff">Set the message</font></div><h6><br><font face="Eras Bold ITC" size="7"> </font></h6>
            <table style="width: %100;" align="left">
            	<tr>
  					<td><font size="5"> Title:</font></td>
  					<td><input type="text" name="Title" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5"> Content:</font></td>
  					<td><textarea name="Content" rows="3" cols="25"></textarea></td>
  				</tr>
  				 <tr>      
                    <td align="center">
						<input type="submit" name="submit1" value="È·ÈÏ" style= "height:30px; width=80px">
                    </td>                  
                    <td align="center">
                        <input type="reset" name="submit2" value="ÖØÖÃ" style= "height:30px; width=80px">
                    </td>   
                </tr>  
            </table>
    </form>      
    </body>   
</html>   