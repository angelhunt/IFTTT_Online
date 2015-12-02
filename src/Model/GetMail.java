package Model;

import java.util.Date;
import java.security.Security; 
import java.util.Properties; 
import javax.mail.*; 

public class GetMail extends This{
	protected String ID;
	protected String pwd;
	protected Date time;
	
	public GetMail(String ID, String pwd){
		this.ID = ID;
		this.pwd = pwd;
		this.time = new Date();
	}
	
	public GetMail(String s){
		char[] temp = s.toCharArray();
		char[] test = new char[100];
		int i = 0, length = 0;
		
		while (temp[i] != '%')
			i++;
		i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_ID = new char[length];
		copy(temp_ID, test);
		ID = new String(temp_ID);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_pwd = new char[length];
		copy(temp_pwd, test);
		pwd = new String(temp_pwd);
		length = 0;i++;
		
		time = new Date();
	}
	
	public boolean ReturnThis(){
		while (true){
			try {
				if (getmail()){
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean getmail() throws Exception {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider()); 
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory"; 
		// Get a Properties object 
		Properties props = System.getProperties(); 
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY); 
		props.setProperty("mail.pop3.socketFactory.fallback", "false"); 
		props.setProperty("mail.pop3.port", "995"); 
		props.setProperty("mail.pop3.socketFactory.port", "995"); 
		//以下步骤跟一般的JavaMail操作相同 
		Session session = Session.getDefaultInstance(props,null); 
		//请将红色部分对应替换成你的邮箱帐号和密码 
		URLName urln = new URLName("pop3","pop.gmail.com",995,null, 
				ID, pwd); 
		Store store = session.getStore(urln); 
		Folder inbox = null; 
		try {
			store.connect(); 
			inbox = store.getFolder("INBOX"); 
			inbox.open(Folder.READ_ONLY); 
			FetchProfile profile = new FetchProfile(); 
			profile.add(FetchProfile.Item.ENVELOPE); 
			Message[] messages = inbox.getMessages(); 
			inbox.fetch(messages, profile); 
			System.out.println("收件箱的邮件数：" + messages.length); 
			for (int i = 0; i < messages.length; i++) { 
//		    //邮件发送者 
//		    String from = decodeText(messages[i].getFrom()[0].toString()); 
//		    InternetAddress ia = new InternetAddress(from); 
//		    System.out.println("FROM:" + ia.getPersonal()+'('+ia.getAddress()+')'); 
//		    //邮件标题 
//		    System.out.println("TITLE:" + messages[i].getSubject()); 
//		    //邮件大小 
//		    System.out.println("SIZE:" + messages[i].getSize()); 
//		    //邮件发送时间 
//		    System.out.println("DATE:" + messages[i].getSentDate()); 
			   
				Date temp = messages[i].getSentDate();
				System.out.println(temp);
				if (temp.after(time))
					return true;
		   } 
		   return false;
		} finally {
			try {
				inbox.close(false);
			} catch (Exception e) {}
			try { 
			    store.close(); 
			   } catch (Exception e) {}
		}
	}


	public String toString() {
		return new String("2%" + ID + "%" + pwd + "%");
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	private static void copy(char[] a, char[] b){
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static void main(String[] args){
		GetMail g = new GetMail("hidimay@gmail.com", "yjy7225436");
//		GetMail m = new GetMail(g.toString());
//		System.out.println(m.toString());
		System.out.println(g.time);
		System.out.println(g.ReturnThis());
	}
}
