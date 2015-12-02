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
<title>�û���¼����</title>
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
var menu=$("topTags").getElementsByTagName("ul")[0];//�����˵�����
var tags=menu.getElementsByTagName("li");//�����˵�
var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//���˵�
var j;
//������˵������±�ǩ
for(i=0;i<ck.length;i++){
ck[i].onclick=function(){
$("welcome").style.display="none";//��ӭ��������
clearMenu();
this.style.background='url(images/tabbg02.gif)';
//ѭ��ȡ�õ�ǰ����
for(j=0;j<8;j++){
if(this==ck[j]){
if($("p"+j)==null){
openNew(j,this.innerHTML);//���ñ�ǩ��ʾ����
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
//���ӻ�ɾ����ǩ
function openNew(id,name){
var tagMenu=document.createElement("li");
tagMenu.id="p"+id;
tagMenu.innerHTML=name+"&nbsp;&nbsp;"+"<img src='images/off.gif' style='vertical-align:middle'/>";
//��ǩ����¼�
tagMenu.onclick=function(evt){
clearMenu();
ck[id].style.background='url(images/tabbg02.gif)';
clearStyle();
tagMenu.style.background='url(images/tabbg1.gif)';
clearContent();
$("c"+id).style.display="block";
};
//��ǩ�ڹر�ͼƬ����¼�
tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
evt=(evt)?evt:((window.event)?window.event:null);
if(evt.stopPropagation){evt.stopPropagation();};//ȡ��opera��Safarið����Ϊ;
this.parentNode.parentNode.removeChild(tagMenu);//ɾ����ǰ��ǩ
var color=tagMenu.style.backgroundColor;
//��������ر�һ����ǩʱ�������һ����ǩ�õ�����
if(color=="#ffff00"||color=="yellow"){//�������������ɫ����
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
//����˵���ʽ
function clearMenu(){
for(i=0;i<ck.length;i++){
ck[i].style.background='url(images/tabbg01.gif)';
 }
}
//�����ǩ��ʽ
function clearStyle(){
for(i=0;i<tags.length;i++){
menu.getElementsByTagName("li")[i].style.background='url(images/tabbg2.gif)';
  }
}
//�������
function clearContent(){
for(i=0;i<7;i++){
$("c"+i).style.display="none";
 }
}
};
</script>
</head>
<body>&nbsp; 
<jsp:useBean id="user" class="Model.User" scope="application"></jsp:useBean>
<jsp:setProperty name="studentID" property="*" />
<% HttpSession tmp=request.getSession();
	String username=(String)tmp.getAttribute("username");
	String password=(String)tmp.getAttribute("password");
	double money=(Double)tmp.getAttribute("money");
	double vip=(Double)tmp.getAttribute("vippoint");
	user.setUserName(username);
 %>
<div id="left_content">
     <div id="user_info">��ӭ����<strong><%=username%></strong><br />[<a href="#">�û�</a>��<a href="Login.jsp">�˳�</a>]</div>
</div>
<div id="top">
<h2>����˵�</h2>
<div class=jg></div>
<div id="topTags">
<ul>
</ul>
</div>
</div>
<div id="main"> 
<div id="leftMenu">
<ul>
<li>��������</li>
<li>�������</li>
<li>ϵͳ��Ϣ</li>
<li>˽����Ϣ</li>
<li>���Ѽ�¼</li>
<li>�˻���Ϣ</li>
<li>��Ա�ȼ�</li>
</ul>
</div>
<div class=jg></div>
<div id="content">
<div id="welcome" class="content" style="display:block;">
  <div align="center">
    <p>&nbsp;</p>
    <p><font size="5"><strong>��ӭʹ��IFTTT�û�����ϵͳ��</strong></font></p>
    <p>&nbsp;</p>
    </div>
</div>
<div id="c0" class="content">
	<table style="width: 400px;">
	 <tr>  
	 	  <td><font size="4">�û���:		<%=username %></font></td>               
	</tr>
	</table>
</div>
<div id="c1" class="content">
	<form method="post" action="BeginTask">
	<font size="4">��ǰ�����б�</font>
	<table style="width: %100;">
	 <tr>   
          <td><a href="createTask.jsp">�½�����</a></td> 
          <td><a href="#">�鿴����</a></td>               
	</tr>
	<tr>
		  <td><a href="#">ɾ������</a></td>  
          <td><a href="#">�޸�����</a></td> 
    </tr>	 	
	<tr>
	<%
		  ArrayList<Task> list=Dao.selectTask(username);
		  int size=list.size();
		  for(int i=0;i<size;i++){
		  	String THIS=list.get(i).getThis();
		  	String THAT=list.get(i).getThat();
		  	System.out.println("tag begin");
		  	String discription=Model.Task.getDiscription(THIS,THAT);
		  	System.out.println("tag here");%>
		  	<td><label><%=list.get(i).getTaskName() %></label>
		  	<input type="radio" name="taskList" value=<%=list.get(i).getTaskName()%>/></td>
		  	<td><textarea name="taskDiscripton" rows="3" cols="25" ><%=discription%></textarea></td><tr/><tr>
		  	<% } %>
	</tr>
	<tr>      
                    <td align="center">
						<input type="submit" name="beginTask" value="��ʼ����" style= "height:30px; width=80px">
                    </td>                  
                    <td align="center">
                        <input type="submit" name="endTask" value="��������" style= "height:30px; width=80px">
                    </td>   
    </tr> 
	</table>
	<%session.setAttribute("username",username);%>
	</form>
</div>
<div id="c2" class="content">
	<font size="4">ϵͳ��Ϣ��</font> <br />
	<%ArrayList<message> messages=Dao.getMessageBox(username);
	 	if(messages!=null){
	 	int k=messages.size();
	 	for(int i=0;i<k;i++){
	 		if(messages.get(i).getSourceName().trim().equals("System")){
	  %>
	 From: <%=messages.get(i).getSourceName()%><br /> 
	 Title: <%=messages.get(i).getTitle()%><br /> 
	 Content: <%=messages.get(i).getContent()%><br /> 
	 <%}}} %>
</div>
<div id="c3" class="content">
	<font size="4">˽����Ϣ��</font> <br />
	<%session.setAttribute("username",username);%>
	----------------------------------------------------------------<br />
	<font size="4">�ѷ��͵���Ϣ��</font> <br />
	<%ArrayList<message> sendMessages=Dao.sendMessageBox(username);
	 	if(sendMessages!=null){
	 	int count=sendMessages.size();
	 	for(int i=0;i<count;i++){
	  %>
	 TO: <%=sendMessages.get(i).getTargetName()%><br /> 
	 Title: <%=sendMessages.get(i).getTitle()%><br /> 
	 Content: <%=sendMessages.get(i).getContent()%><br /> 
	 <%}} %> 
	-----------------------------------------------------------------<br />
	<font size="4">�ѽ��յ���Ϣ��</font> <br />
	<%ArrayList<message> getMessages=Dao.getMessageBox(username);
	 	if(getMessages!=null){
	 	int k=getMessages.size();
	 	for(int i=0;i<k;i++){
	 		if(!getMessages.get(i).getSourceName().trim().equals("System")){
	  %>
	 From: <%=getMessages.get(i).getSourceName()%><br /> 
	 Title: <%=getMessages.get(i).getTitle()%><br /> 
	 Content: <%=getMessages.get(i).getContent()%><br /> 
	 <%}}} %>
	 ------------------------------------------------------------------<br />
	 <form method="post" action="UserSendMessage.jsp">
	 	<input type="submit" name="submit" value="������Ϣ" style= "height:30px; width=80px">
	 </form>
</div>
<div id="c4" class="content">
	<font size="4">��Ϣ��¼��</font> <br />
	<%ArrayList<SpendRecord> recordList=Dao.selectSpendRecord(username);
	 	if(recordList!=null){
	 	int n=recordList.size();
	 	for(int i=0;i<n;i++){
	  %>
	 <%=recordList.get(i).getUserName()%>�� <%=recordList.get(i).getCreateTime()%>ʱ��ִ������<%=recordList.get(i).getTaskName() %>������50����<br /> 
	 <%}} %> 
</div>
<div id="c5" class="content">
	<table style="width: 400px;">
	 <tr>   
          <td><font size="4">�˻����:		</font></td> 
          <td><%=Dao.selectUser(username).getMoney() %></td>    
	</tr>
	</table>
</div>
<div id="c6" class="content">
	<table style="width: 400px;">
	 <tr>   
          <td><font size="4">��Ա�ȼ�:		</font></td>
          <td><%=Dao.selectUser(username).getVIPpoint() %></td>       
	</tr>
	</table>
</div>
</div>
</div>
<div id="footer">Welcome to IFTTT</div>
</body>
</html>