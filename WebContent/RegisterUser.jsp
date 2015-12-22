<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>IFTTT用户注册信息</title>
 <link rel="stylesheet" type="text/css" href="css/Login.css" />
</head>
<script language="JavaScript">

//检测注册表单
function checkRegistForm(form){
//用户名是否为空
	if(form.username.value == ""){
		alert("请输入用户名");
		form.username.focus();
			return(false);
	}
	//判断用户名长度和合法性
	if(form.username.value.match(/^[a-zA-Z0-9]*$/)){
		if(form.username.value.length>20||form.username.value.length<5){
		alert("对不起，用户名长度只能在5-20个之间");
		return(false);
		}
	}
	else{
		alert("对不起，只允许输入字母和数字");
		return(false);
	} 
	
	//密码是否为空
	if (form.password.value == ""){
		alert("请输入注册密码");
		form.password.focus();
		return (false);
	}
	//判断密码合法性
	if(form.password.value.length>20||form.password.value.length<5){
		alert("对不起，密码长度只能在5-20个之间");
		return(false);
	}
	//重复密码的输入
	if (form.checkpassword.value == ""){
		alert("请再次输入注册密码");
		form.password.focus();
		return (false);
	}
	
	
	//两次密码是否一致
	if(form.password.value != form.checkpassword.value){
		alert("两次输入的密码不一致");
		form.password.focus();
		return(false);
	}
	
	//电子邮箱是否正确
	if(form.email.value == "" ){
		alert("请输入电子邮箱地址");
		form.email.focus();
		return(false);
	}
	if(form.email.value.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) == -1){
		alert("你输入的电子邮箱地址不正确");
		form.email.focus();
		return(false);
	}
}
</script>


<!--Register.jsp-->
<body style="background:url('images/backgroup1.jpg') no-repeat;">
       <div align="center"> 
            <p><font face="Eras Bold ITC" size="7" color= gray>用户注册表单</font><br>
            <font face="Eras Bold ITC" size="7"> </font></p>
       </div>
<p align="center">请填写下列注册信息（带“*”的为必填项目）</p>




<form method="post" language="javascript" onsubmit="return checkRegistForm(form)" 
		action="StoreInfo" name="form">
  <table width="100%" border="0" align="center">
    <tr>
      <td width="19%" height="26"><div align="center">*用户名</div></td>
      <td width="26%"><input name="username" type="text" size="20" maxlength="20" /></td>
      <td width="55%">只允许输入字母和数字，长度在5-20之间</td>
    </tr>
	 <tr>
      <td><div align="center">*密码</div></td>
      <td height="5"><label>
        <input name="password" type="password" size="20" maxlength="20" />
        </label>      </td>
      <td height="5">长度在5-20之间</td>
    </tr>
    <tr>
	<td><div align="center">*重复密码</div></td>
      <td height="7"><label>
        <input name="checkpassword" type="password" size="20" maxlength="20" />
        </label>      </td>
      <td height="7">请与所填密码一致</td>
    </tr>
	<tr>
      <td><div align="center">*电子邮箱</div></td>
      <td height="14"><input name="email" type="text" size="20" maxlength="20" /></td>
      <td height="14">请输入正确的邮箱地址，这是我们联系你的方式</td>
	</tr>
    <tr>
      <td height="30"><div align="center">性别</div></td>
      <td colspan="2"><label>男
            <input name="sex" type="radio" value="search engine" checked="checked" />
        </label>
          <label>女
            <input name="sex" type="radio" value="女" />
          </label></td>
    </tr>
    <tr>
      <td height="35"><div align="center">出生年月</div></td>
      <td colspan="2"><label>
        <input name="year" type="text" id="year" size="4" maxlength="4" />
        </label>
        年
        <label></label>
        <label for="textfield"></label>
        <input name="month" type="text" id="month" size="2" maxlength="2" />
        月
        <label for="label"></label>
        <input name="day" type="text" id="label" size="2" maxlength="2" />
        <label></label>
        日 </td>
    </tr>
    <tr>
      <td height="32"><div align="center">国家</div></td>
      <td colspan="2"><label> </label>
          <label for="label4"></label>
          <label for="select"></label>
          <select name="select" id="select">
            <option>中国</option>
            <option>日本</option>
            <option>韩国</option>
            <option>美国</option>
            <option>欧盟</option>
            <option>其它</option>
        </select>      </td>
    </tr>
    <tr>
      <td height="-2"><div align="center">兴趣爱好</div></td>
      <td colspan="2"><label for="label5">看电影</label>
          <input type="checkbox" name="checkbox4" value="checkbox" id="label5" />
          <label for="label6">购物</label>
          <input type="checkbox" name="checkbox22" value="checkbox" id="label6" />
          <label for="checkbox2"></label>
          <label for="label7">其它</label>
          <input type="checkbox" name="checkbox32" value="checkbox" id="label7" />
          <label></label>
          <label></label></td>
    </tr>
    <tr>
      <td height="17"><div align="center">备注</div></td>
      <td colspan="2"><label for="label8"></label>
          <textarea name="textarea3" rows="6" id="label8"></textarea>      </td>
    </tr>
    <tr>
      <td height="22">&nbsp;</td>
      <td height="22" colspan="2"><input name="submit" type="submit"  value="提交" />
          <input name="Submit22" type="reset" value="重置">      </td>
    </tr>
  </table>
</form>

</body>
</html>


