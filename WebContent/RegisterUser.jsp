<%@ page language="java" contentType="text/html;charset=gb2312"%>  
<%@ page import="Objects.StoreInfo" %>
<html>
<head>
<title>IFTTT�û�ע����Ϣ</title>
 <link rel="stylesheet" type="text/css" href="css/Login.css" />
</head>
<script language="JavaScript">

//���ע���
function checkRegistForm(form){
//�û����Ƿ�Ϊ��
	if(form.username.value == ""){
		alert("�������û���");
		form.username.focus();
			return(false);
	}
	//�ж��û������ȺͺϷ���
	if(form.username.value.match(/^[a-zA-Z]*$/)){
		if(form.username.value.length>20||form.username.value.length<5){
		alert("�Բ����û�������ֻ����5-20��֮��");
		return(false);
		}
	}
	else{
		alert("�Բ���ֻ����������ĸ");
		return(false);
	} 
	
	//�����Ƿ�Ϊ��
	if (form.password.value == ""){
		alert("������ע������");
		form.password.focus();
		return (false);
	}
	//�ж�����Ϸ���
	if(form.password.value.length>20||form.password.value.length<5){
		alert("�Բ������볤��ֻ����5-20��֮��");
		return(false);
	}
	//�ظ����������
	if (form.checkpassword.value == ""){
		alert("���ٴ�����ע������");
		form.password.focus();
		return (false);
	}
	
	
	//���������Ƿ�һ��
	if(form.password.value != form.checkpassword.value){
		alert("������������벻һ��");
		form.password.focus();
		return(false);
	}
	
	//���������Ƿ���ȷ
	if(form.email.value == "" ){
		alert("��������������ַ");
		form.email.focus();
		return(false);
	}
	if(form.email.value.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) == -1){
		alert("������ĵ��������ַ����ȷ");
		form.email.focus();
		return(false);
	}
}
</script>


<!--Register.jsp-->
<body >
<h1 align="center">&nbsp;IFTTT�û�ע�����д</h1>
<p align="center">����д����ע����Ϣ������*����Ϊ������Ŀ��</p>




<form method="post" language="javascript" onsubmit="return checkRegistForm(form)" 
		action="StoreInfo" name="form">
  <table width="100%" border="0" align="center">
    <tr>
      <td width="19%" height="26"><div align="center">*�û���</div></td>
      <td width="26%"><input name="username" type="text" size="20" maxlength="20" /></td>
      <td width="55%">ֻ����������ĸ��������5-20֮��</td>
    </tr>
	 <tr>
      <td><div align="center">*����</div></td>
      <td height="5"><label>
        <input name="password" type="password" size="20" maxlength="20" />
        </label>      </td>
      <td height="5">������5-20֮��</td>
    </tr>
    <tr>
	<td><div align="center">*�ظ�����</div></td>
      <td height="7"><label>
        <input name="checkpassword" type="password" size="20" maxlength="20" />
        </label>      </td>
      <td height="7">������������һ��</td>
    </tr>
	<tr>
      <td><div align="center">*��������</div></td>
      <td height="14"><input name="email" type="text" size="20" maxlength="20" /></td>
      <td height="14">��������ȷ�������ַ������������ϵ��ķ�ʽ</td>
	</tr>
    <tr>
      <td height="30"><div align="center">�Ա�</div></td>
      <td colspan="2"><label>��
            <input name="sex" type="radio" value="search engine" checked="checked" />
        </label>
          <label>Ů
            <input name="sex" type="radio" value="Ů" />
          </label></td>
    </tr>
    <tr>
      <td height="35"><div align="center">��������</div></td>
      <td colspan="2"><label>
        <input name="year" type="text" id="year" size="4" maxlength="4" />
        </label>
        ��
        <label></label>
        <label for="textfield"></label>
        <input name="month" type="text" id="month" size="2" maxlength="2" />
        ��
        <label for="label"></label>
        <input name="day" type="text" id="label" size="2" maxlength="2" />
        <label></label>
        �� </td>
    </tr>
    <tr>
      <td height="32"><div align="center">����</div></td>
      <td colspan="2"><label> </label>
          <label for="label4"></label>
          <label for="select"></label>
          <select name="select" id="select">
            <option>�й�</option>
            <option>�ձ�</option>
            <option>����</option>
            <option>����</option>
            <option>ŷ��</option>
            <option>����</option>
        </select>      </td>
    </tr>
    <tr>
      <td height="-2"><div align="center">��Ȥ����</div></td>
      <td colspan="2"><label for="label5">����Ӱ</label>
          <input type="checkbox" name="checkbox4" value="checkbox" id="label5" />
          <label for="label6">����</label>
          <input type="checkbox" name="checkbox22" value="checkbox" id="label6" />
          <label for="checkbox2"></label>
          <label for="label7">����</label>
          <input type="checkbox" name="checkbox32" value="checkbox" id="label7" />
          <label></label>
          <label></label></td>
    </tr>
    <tr>
      <td height="17"><div align="center">��ע</div></td>
      <td colspan="2"><label for="label8"></label>
          <textarea name="textarea3" rows="6" id="label8"></textarea>      </td>
    </tr>
    <tr>
      <td height="22">&nbsp;</td>
      <td height="22" colspan="2"><input name="submit" type="submit"  value="�ύ" />
          <input name="Submit22" type="reset" value="����">      </td>
    </tr>
  </table>
</form>

</body>
</html>


