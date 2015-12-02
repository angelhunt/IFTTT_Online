package Objects;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;   
import java.util.Properties;   
import java.util.Date;
import javax.activation.DataHandler;   
import javax.activation.FileDataSource; 
import javax.mail.Authenticator;   
import javax.mail.BodyPart;   
import javax.mail.Folder;
import javax.mail.Message;   
import javax.mail.MessagingException;   
import javax.mail.Multipart;   
import javax.mail.PasswordAuthentication;   
import javax.mail.Session;   
import javax.mail.Store;
import javax.mail.Transport;   
import javax.mail.internet.InternetAddress;   
import javax.mail.internet.MimeBodyPart;   
import javax.mail.internet.MimeMessage;   
import javax.mail.internet.MimeMultipart;   

  
  
public class MyGmail {   
           
    public void SendMail(String strID,String strPassword,String strDesID,String messageContent) throws Exception {   
        String host = "smtp.gmail.com";// "smtp.gmail.com"    
        String port = "465"; //"465"   
        Properties props = new Properties();   
        props.setProperty("mail.smtp.host", host);    
        props.setProperty("mail.smtp.port", port);   
        props.setProperty("mail.smtp.auth", "true");   
        props.setProperty("mail.smtp.ssl.enable", "true");//"true"   
        props.setProperty("mail.smtp.connectiontimeout", "5000");   

           
        final String user = strID;  //"***@gmail.com"   
        final String pwd = strPassword;   
        Session session = Session.getInstance(props, new Authenticator() {    
            protected PasswordAuthentication getPasswordAuthentication() {   
                //登录用户名密码   
                return new PasswordAuthentication(user,pwd);   
            }   
        });   

        session.setDebug(true);   
        Transport transport = session.getTransport("smtps");//"smtps"   
        transport.connect(host,user,pwd);    
        //消息   
        MimeMessage message = new MimeMessage(session);   
           
        setMailContent(message,messageContent);//。。。。。。。。。。。。。。。。。。   
           
        message.setSubject("Java Test");   
        //消息发送者接收者设置   
        message.setFrom(new InternetAddress(user,"徐江"));    
        message.addRecipients(Message.RecipientType.TO,new InternetAddress[]{   
                new InternetAddress(strDesID)
        });   
        message.saveChanges();   
           
        //发送   
        Transport.send(message);   
           
        transport.close();     
           
    }   
       
    //设定邮件内容   
    private void setMailContent(MimeMessage message,String messageContent) throws MessagingException {   
        //方法一：只有文本邮件   
        //message.setText("Welcome to java");//纯文本内容   
        //方法二：添加附件的邮件   
        Multipart part = new MimeMultipart();   
           
        BodyPart bodypart1 = new MimeBodyPart();   
        bodypart1.setText(messageContent);         
        part.addBodyPart(bodypart1 );   
         
           
        message.setContent(part); 
    }
    
    // receive the mail 

}

//"yf094020@gmail.com" 66393956639395
 class ReceiveEmail{
	 /*
	方法说明：主方法，接收用户输入的邮箱服务器、用户名和密码
	输入参数：
	返回类型：
	*/
	 public boolean judgeReceive ( String popUser, String popPassword,String desID,Date time){
		  boolean tf=false;
		  try{
		   String popServer="imap.gmail.com";    //邮件服务器
		    tf= receive(popServer, popUser, popPassword,desID,time);
		  }catch (Exception ex){
		   System.out.println("Usage: java com.lotontech.mail.POPMail"+" popServer popUser popPassword");
		  }
		  return tf;
	 }
	 /*
	方法说明：接收邮件信息
	输入参数：
	返回类型：*/
	 public static boolean receive(String popServer, String popUser, String popPassword,String desID,Date time){
		  Store store=null;
		  Folder folder=null;
		  try{
		   //获取默认会话
		   Properties props = System.getProperties();
		   props.setProperty("mail.store.protocol", "imaps");//设置电子邮件协议
		   
		   Session session = Session.getDefaultInstance(props, null);
		   //使用POP3会话机制，连接服务器
		   System.out.println(popUser+" "+popPassword);
		   store = session.getStore("imaps");
		   store.connect(popServer, popUser, popPassword);
		   //获取默认文件夹
		   folder = store.getDefaultFolder();
		   if (folder == null) throw new Exception("No default folder");
		   //如果是收件箱
		   folder = folder.getFolder("INBOX");
		   if (folder == null) throw new Exception("No POP3 INBOX");
		   //使用只读方式打开收件箱
		   folder.open(Folder.READ_ONLY);
		   //得到文件夹信息，获取邮件列表
		   Message[] msgs = folder.getMessages();
		   for (int msgNum = 0; msgNum < msgs.length; msgNum++){
		    if(judge(msgs[msgNum],desID,time)) 
		    	{	if (folder!=null) folder.close(false);
			    	if (store!=null) store.close();
		    		return true;
		    	}
		   }
		  }catch (Exception ex){
		   ex.printStackTrace();
		  }
		  /*finally{
		   //释放资源
		   try{
		    if (folder!=null) folder.close(false);
		    if (store!=null) store.close();
		   }catch (Exception ex2) {
		    ex2.printStackTrace();
		   }
		  }*/
		  return false;
	 }
	 /*
	方法说明：打印邮件信息
	输入参数：Message message 信息对象
	返回类型：
	  */
	 public static boolean judge(Message message,String desID,Date time){
	   //获得发送邮件地址
	    String from=null;
	    java.util.Date date=null;
		try {
			from = ((InternetAddress)message.getFrom()[0]).getPersonal();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				from=((InternetAddress)message.getFrom()[0]).getAddress();
				date=message.getSentDate(); 
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int  i=date.compareTo(time);
			System.out.println(date+"   "+time+" "+ i);
		   if((from.equals(desID))  && (i>0) ) return true;
		   else return false;
		}
 }

  


