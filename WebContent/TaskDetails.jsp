<%@page language="java"contentType="text/html;charset=gb2312"%> 
<jsp:useBean id="user" class="Model.User" scope="application"></jsp:useBean> 
<html>   
    <head>   
        <title>Set the task </title>   
    </head>   
    <body style="background:url('images/RegisterUser.jpg') no-repeat;">
    <form method="post" action="StoreTaskInfo">
       <% session=request.getSession();
				session.setAttribute("type",request.getSession().getAttribute("type"));
				session.setAttribute("username",user.getUserName());
        %>
       <div align="left"> 
            <font face="Eras Bold ITC" size="5" color="#00ffff">Set the task:<%=request.getSession().getAttribute("discription") %></font></div><h6><br><font face="Eras Bold ITC" size="7"> </font></h6>
            <table style="width: %100;" align="left">
                <tr>
  					<td><font size="5"> TaskName:</font></td>
  					<td><input type="text" name="taskName" size=25 /></td>
  				</tr>
                <tr>   
                    <td><font size="5"> THIS:</font></td>   
  				</tr> 
  				<tr>
  					<td><font size="5"> Date(xxxx-xx-xx):</font></td>
  					<td><input type="text" name="date" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5"> Time(hh:mm:ss):</font></td>
  					<td><input type="text" name="time" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5"> SrcID:</font></td>
  					<td><input type="text" name="srcID" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5"> SrcPassword:</font></td>
  					<td><input type="text" name="srcPassword" size=25 /></td>
  				</tr> 
  				<tr>
  					<td><font size="5"> SrcContent:</font></td>
  					<td><textarea name="srcContent" rows="4" cols="25" ></textarea></td>
  				</tr>
                <tr>   
                    <td><font size="5">THAT:</font></td>   
                </tr>
                <tr>
  					<td><font size="5"> MyID:</font></td>
  					<td><input type="text" name="myID" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5"> MyPassword:</font></td>
  					<td><input type="text" name="myPassword" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5">DesID:</font></td>
  					<td><input type="text" name="desID" size=25 /></td>
  				</tr>
  				<tr>
  					<td><font size="5"> DesContent:</font></td>
  					<td><textarea name="desContent" rows="4" cols="25" ></textarea></td>
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


