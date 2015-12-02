<%@page language="java"contentType="text/html;charset=gb2312"%>   
<html>   
    <head>   
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


