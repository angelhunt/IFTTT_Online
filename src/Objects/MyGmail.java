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
                //��¼�û�������   
                return new PasswordAuthentication(user,pwd);   
            }   
        });   

        session.setDebug(true);   
        Transport transport = session.getTransport("smtps");//"smtps"   
        transport.connect(host,user,pwd);    
        //��Ϣ   
        MimeMessage message = new MimeMessage(session);   
           
        setMailContent(message,messageContent);//������������������������������������   
           
        message.setSubject("Java Test");   
        //��Ϣ�����߽���������   
        message.setFrom(new InternetAddress(user,"�콭"));    
        message.addRecipients(Message.RecipientType.TO,new InternetAddress[]{   
                new InternetAddress(strDesID)
        });   
        message.saveChanges();   
           
        //����   
        Transport.send(message);   
           
        transport.close();     
           
    }   
       
    //�趨�ʼ�����   
    private void setMailContent(MimeMessage message,String messageContent) throws MessagingException {   
        //����һ��ֻ���ı��ʼ�   
        //message.setText("Welcome to java");//���ı�����   
        //����������Ӹ������ʼ�   
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
	����˵�����������������û������������������û���������
	���������
	�������ͣ�
	*/
	 public boolean judgeReceive ( String popUser, String popPassword,String desID,Date time){
		  boolean tf=false;
		  try{
		   String popServer="imap.gmail.com";    //�ʼ�������
		    tf= receive(popServer, popUser, popPassword,desID,time);
		  }catch (Exception ex){
		   System.out.println("Usage: java com.lotontech.mail.POPMail"+" popServer popUser popPassword");
		  }
		  return tf;
	 }
	 /*
	����˵���������ʼ���Ϣ
	���������
	�������ͣ�*/
	 public static boolean receive(String popServer, String popUser, String popPassword,String desID,Date time){
		  Store store=null;
		  Folder folder=null;
		  try{
		   //��ȡĬ�ϻỰ
		   Properties props = System.getProperties();
		   props.setProperty("mail.store.protocol", "imaps");//���õ����ʼ�Э��
		   
		   Session session = Session.getDefaultInstance(props, null);
		   //ʹ��POP3�Ự���ƣ����ӷ�����
		   System.out.println(popUser+" "+popPassword);
		   store = session.getStore("imaps");
		   store.connect(popServer, popUser, popPassword);
		   //��ȡĬ���ļ���
		   folder = store.getDefaultFolder();
		   if (folder == null) throw new Exception("No default folder");
		   //������ռ���
		   folder = folder.getFolder("INBOX");
		   if (folder == null) throw new Exception("No POP3 INBOX");
		   //ʹ��ֻ����ʽ���ռ���
		   folder.open(Folder.READ_ONLY);
		   //�õ��ļ�����Ϣ����ȡ�ʼ��б�
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
		   //�ͷ���Դ
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
	����˵������ӡ�ʼ���Ϣ
	���������Message message ��Ϣ����
	�������ͣ�
	  */
	 public static boolean judge(Message message,String desID,Date time){
	   //��÷����ʼ���ַ
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

  


