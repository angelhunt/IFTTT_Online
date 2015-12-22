<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>   
    <head>
     <link rel="stylesheet" type="text/css" href="css/Login.css" />
          <link rel="stylesheet" type="text/css" href="css/Select.css" />
               <title>Creat Task</title>
     </head>   
<body style="background:url('images/backgroup1.jpg') no-repeat;">   
            <div align="center"> 
            <p><font face="Eras Bold ITC" size="7" color= gray>Creat Task</font><br>
            <font face="Eras Bold ITC" size="7"> </font></p>
       </div>
       
<div align="center"> 
    <form method="post" action="CheckTaskType">
       <div align="center"> 
         <p>&nbsp;</p>
         <p><br>
         </p>
       </div>
      <div align="center">
             <br></br>
    <font face="Eras Bold ITC" size="6" color="#00ffff">
            <table width="572" height="171" align="center" style="width: %100;">
                <tr>   
                    <td height="39"><div align="center"><font size="6">THIS:</font></div></td>   
                    <td>
<a class="btn-select" id="btn_select"> 

<select name="this"> 
<span class="cur-select">请选择</span> 
<option>请选择THIS事件</option>
<option>Clock</option> 
<option>Gmail</option> 
<option>Weibo</option> 
</select> 
</a> 
                    </td>
  				</tr>   
                <tr>   
                
                    <td><div align="center"><font size="6">THAT:</font></div></td>   
                    <td>
<a class="btn-select" id="btn_select"> 

<select name="that"> 
<span class="cur-select">请选择</span> 
<option>请选择THAT事件</option>
<option>Weibo</option> 
<option>Gmail</option> 
</select> 
</a> 
                </tr>   

      </table>
      </div>
     <div align="center"><input name="submit" value="submit" type="submit" /> </div>
  </form>     
</div>
    </body>   
</html>   


