<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="user" class="Model.User" scope="application"></jsp:useBean> 
<html>   
   <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Task Detail</title>
</head>
 <link rel="stylesheet" type="text/css" href="css/Login.css" />

                   <div align="center"> 
            <p><font face="Eras Bold ITC" size="9" color= gray>Set Task</font></p>
            <p><br>
              <font face="Eras Bold ITC" size="7"> </font></p>
       </div>
<form method="post" action="StoreTaskInfo">
    <div align="center"> 
      <table width="779" height="470" align="center">
                <tr>
  					<td width="345" align="center"><font size="5"> TaskName:</font></td>
				  <td width="470"><input type="text" name="taskName" size=25 /></td>
  				</tr>
                <tr>   
                    <td align="center"><font size="5"> THIS:</font></td>
                    <td>&nbsp;</td>   
  				</tr> 
  				<tr>
  					<td align="center"><font size="5"> Date(xxxx-xx-xx):</font></td>
  					<td><input type="text" name="date" size=25 /></td>
  				</tr>
  				<tr>
  					<td align="center"><font size="5"> Time(hh:mm:ss):</font></td>
  					<td><input type="text" name="time" size=25 /></td>
  				</tr>
  				<tr>
  					<td align="center"><font size="5"> SrcID:</font></td>
  					<td><input type="text" name="srcID" size=25 /></td>
  				</tr>
  				<tr>
  					<td align="center"><font size="5"> SrcPassword:</font></td>
  					<td><input type="text" name="srcPassword" size=25 /></td>
  				</tr> 
  				<tr>
  					<td align="center" valign="middle"><font size="5"> SrcContent:</font></td>
  					<td><textarea name="srcContent" rows="4" cols="25" ></textarea></td>
  				</tr>
                <tr>   
                    <td align="center" valign="middle"><font size="5">THAT:</font></td>
                    <td>&nbsp;</td>   
                </tr>
                <tr>
  					<td align="center"><font size="5"> MyID:</font></td>
  					<td><input type="text" name="myID" size=25 /></td>
  				</tr>
  				<tr>
  					<td align="center"><font size="5"> MyPassword:</font></td>
  					<td><input type="text" name="myPassword" size=25 /></td>
  				</tr>
  				<tr>
  					<td align="center"><font size="5">DesID:</font></td>
  					<td><input type="text" name="desID" size=25 /></td>
  				</tr>
  				<tr>
  					<td height="55" align="center"><font size="5"> DesContent:</font></td>
  					<td><textarea name="desContent" rows="4" cols="25" ></textarea></td>
  				</tr>   
 </table>
      <input type="submit" align="center" name="submit1" value="确认" style= "height:30px; width=80px">
  </div>
    </form>      
   
    </body>   
</html>   


