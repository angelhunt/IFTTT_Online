<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body><div align="center" title="IFTTT" dir="ltr">
  <h1 align="center">IFTTT登陆界面</h1></div>

<div align="center">
<div align="center">
<table width="344" height="114" border="1">
  <tr>
    <th width="56" scope="col">用户</th>
    <th width="228" scope="col"><form id="form2" name="form2" method="post" action="">
      <label for="ID2"></label>
      <input type="text" name="ID" id="ID2" />
    </form></th>
  </tr>
  <tr>
    <th scope="col">密码</th>
    <th scope="col"><form id="form3" name="form3" method="post" action="">
      <label for="passwd"></label>
      <input type="text" name="passwd" id="passwd" />
    </form></th>
  </tr>
</table>
</div>
<div align="center">
  <form id="form1" name="form1" method="post" action="">
    <input type="submit" name="登陆" id="登陆" value="登陆" />
  </form>
</div>
</div>


</body>
</html>