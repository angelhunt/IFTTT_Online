<%--UserLogin.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java"contentType="text/html;charset=gb2312"%> 
<%@page import="Dao.*" %>
<%@page import="Model.*" %>
<%@page import="Model.Task"%>
<%@page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>用户登录界面</title>
<style type="text/css">
body{
	font-size:12px;
	background-image: url(images/bg.gif);
	background-repeat: repeat;
}
ul,li,h2{margin:0;padding:0;}
ul{list-style:none;}
#top{
	width:909px;
	height:26px;
	background-image: url(images/h2bg.gif);
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	background-repeat: repeat-x;
}
#top h2{
	width:150px;
	height:24px;
	float:left;
	font-size:12px;
	text-align:center;
	line-height:20px;
	color: #FFFFFF;
	font-weight: bold;
	padding-top: 2px;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
}
#top .jg {
	width: 5px;
	float: left;
	background-color: #DCE6F5;
	height: 26px;
}
#topTags{
	width:740px;
	height:24px;
	float:left;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	padding-top: 2px;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
	padding-left: 10px;
}
#topTags ul li{
	float:left;
	width:100px;
	height:21px;
	margin-right:4px;
	display:block;
	text-align:center;
	cursor:pointer;
	padding-top: 3px;
	color: #15428B;
	font-size: 12px;
}
#main{
	width:909px;
	height:501px;
	background-color:#F5F7E6;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
}
#main .jg {
	width: 5px;
	float: left;
	background-color: #DFE8F6;
	height: 500px;
}
#leftMenu{
	width:150px;
	height:500px;
	background-color:#DAE7F6;
	float:left;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
}
#leftMenu ul{margin:10px;}
#leftMenu ul li{
	width:130px;
	height:22px;
	display:block;
	cursor:pointer;
	text-align:center;
	margin-bottom:5px;
	background-color: #D9E8FB;
	background-image: url(images/tabbg01.gif);
	background-repeat: no-repeat;
	background-position: 0px 0px;
	padding-top: 2px;
	line-height: 20px;
}
#leftMenu ul li a{
	color:#000000;
	text-decoration:none;
	background-image: url(images/tb-btn-sprite_03.gif);
	background-repeat: repeat-x;
}
#content{
	width:750px;
	height:500px;
	float:left;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
	background-color: #DAE7F6;
}
.content{
	width:740px;
	height:490px;
	display:none;
	padding:5px;
	overflow-y:auto;
	line-height:30px;
	background-color: #FFFFFF;
}
#footer{
	width:907px;
	height:26px;
	background-color:#FFFFFF;
	line-height:20px;
	text-align:center;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
	background-image: url(images/h2bg.gif);
	background-repeat: repeat-x;
}
.content1 {width:740px;height:490px;display:block;padding:5px;overflow-y:auto;line-height:30px;}
</style>
<script type="text/javascript">
window.onload=function(){
function $(id){return document.getElementById(id);};
var menu=$("topTags").getElementsByTagName("ul")[0];//顶部菜单容器
var tags=menu.getElementsByTagName("li");//顶部菜单
var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//左侧菜单
var j;
//点击左侧菜单增加新标签
for(i=0;i<ck.length;i++){
ck[i].onclick=function(){
$("welcome").style.display="none";//欢迎内容隐藏
clearMenu();
this.style.background='url(images/tabbg02.gif)';
//循环取得当前索引
for(j=0;j<5;j++){
if(this==ck[j]){
if($("p"+j)==null){
openNew(j,this.innerHTML);//设置标签显示文字
 }
clearStyle();
$("p"+j).style.background='url(images/tabbg1.gif)';
clearContent();
$("c"+j).style.display="block";
   }
 }
return false;
  };
 }
//增加或删除标签
function openNew(id,name){
var tagMenu=document.createElement("li");
tagMenu.id="p"+id;
tagMenu.innerHTML=name+"&nbsp;&nbsp;"+"<img src='images/off.gif' style='vertical-align:middle'/>";
//标签点击事件
tagMenu.onclick=function(evt){
clearMenu();
ck[id].style.background='url(images/tabbg02.gif)';
clearStyle();
tagMenu.style.background='url(images/tabbg1.gif)';
clearContent();
$("c"+id).style.display="block";
};
//标签内关闭图片点击事件
tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
evt=(evt)?evt:((window.event)?window.event:null);
if(evt.stopPropagation){evt.stopPropagation();};//取消opera和Safari冒泡行为;
this.parentNode.parentNode.removeChild(tagMenu);//删除当前标签
var color=tagMenu.style.backgroundColor;
//设置如果关闭一个标签时，让最后一个标签得到焦点
if(color=="#ffff00"||color=="yellow"){//区别浏览器对颜色解释
if(tags.length-1>=0){
clearStyle();
tags[tags.length-1].style.background='url(images/tabbg1.gif)';
clearContent();
var cc=tags[tags.length-1].id.split("p");
$("c"+cc[1]).style.display="block";
clearMenu();
ck[cc[1]].style.background='url(images/tabbg1.gif)';
 }
else{
clearContent();
clearMenu();
$("welcome").style.display="block";
   }
  }
};
menu.appendChild(tagMenu);
}
//清除菜单样式
function clearMenu(){
for(i=0;i<ck.length;i++){
ck[i].style.background='url(images/tabbg01.gif)';
 }
}
//清除标签样式
function clearStyle(){
for(i=0;i<tags.length;i++){
menu.getElementsByTagName("li")[i].style.background='url(images/tabbg2.gif)';
  }
}
//清除内容
function clearContent(){
for(i=0;i<4;i++){
$("c"+i).style.display="none";
 }
}
};
</script>
</head>
<body>&nbsp; 
<div id="left_content">
     <div id="user_info">欢迎您，<strong>系统管理员</strong><br />[<a href="#">管理员</a>，<a href="Login.jsp">退出</a>]</div>
</div>
<div id="top">
<h2>管理菜单</h2>
<div class=jg></div>
<div id="topTags">
<ul>
</ul>
</div>
</div>
<div id="main"> 
<div id="leftMenu">
<ul>
<li>用户资料</li>
<li>系统管理</li>
<li>系统消息</li>
<li>私人消息</li>
</ul>
</div>
<div class=jg></div>
<div id="content">
<div id="welcome" class="content" style="display:block;">
  <div align="center">
    <p>&nbsp;</p>
    <p><font size="5"><strong>欢迎使用IFTTT用户管理系统！</strong></font></p>
    <p>&nbsp;</p>
    </div>
</div>
<div id="c0" class="content">
	 <font size="4">用户资料：</font> <br />
	 <%
	 	ArrayList<User> list=Dao.selectUser();
	 	int size=list.size();
	 	for(int i=0;i<size;i++){
	  %>
	  用户名：<%=list.get(i).getUserName()%>  等级：<%=list.get(i).getVIPpoint()%>  消费余额：<%=list.get(i).getMoney()%><br /> 
	 <%} %>          
</div>
<div id="c1" class="content">
	系统管理
</div>
<div id="c2" class="content">
	<font size="4">系统消息：</font> <br />
	----------------------------------------------------------------<br />
	<font size="4">所有系统发送的消息：</font> <br />
	<%ArrayList<message> sys_messages=Dao.selectMessage();
	 	if(sys_messages!=null){
	 	int m=sys_messages.size();
	 	for(int i=0;i<m;i++){
	 		if(sys_messages.get(i).getSourceName().trim().equals("System")){
	  %>
	 <input type="radio" name="sys_message" value=<%=sys_messages.get(i).getSendTime()%>/>FROM: <%=sys_messages.get(i).getSourceName()%>   TO: <%=sys_messages.get(i).getTargetName()%><br /> 
	 	Title: <%=sys_messages.get(i).getTitle()%><br /> 
	 	Content: <%=sys_messages.get(i).getContent()%><br /> 
	 <%}}} %> 
	-----------------------------------------------------------------<br />
	<form method="post" action="SysSendMessage.jsp">
	 	<input type="submit" name="submit" value="发送消息" style= "height:30px; width=80px">
	 </form><br />
	<a href="createTask.jsp">删除消息</a><br />
	<a href="createTask.jsp">修改消息</a>
</div>
<div id="c3" class="content">
	<font size="4">所有用户发送的私人消息：</font> <br />
	----------------------------------------------------------------<br />
	<font size="4">所有用户私人消息：</font> <br />
	<%ArrayList<message> usr_messages=Dao.selectMessage();
	 	if(usr_messages!=null){
	 	int m=usr_messages.size();
	 	for(int i=0;i<m;i++){
	 		if(!usr_messages.get(i).getSourceName().trim().equals("System")){
	  %>
	 <input type="radio" name="user_message" value=<%=usr_messages.get(i).getSendTime()%>/>FROM: <%=usr_messages.get(i).getSourceName()%>   TO: <%=usr_messages.get(i).getTargetName()%><br /> 
	 	Title: <%=usr_messages.get(i).getTitle()%><br /> 
	 	Content: <%=usr_messages.get(i).getContent()%><br /> 
	 <%}}} %> 
	-----------------------------------------------------------------<br />
	<a href="createTask.jsp">删除消息</a><br />
	<a href="createTask.jsp">修改消息</a>
</div>
<div id="footer">Welcome to IFTTT</div>
</body>
</html>