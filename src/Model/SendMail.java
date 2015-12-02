package Model;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail extends That{
	private String host = "smtp.gmail.com";
	private String from;
	private String pwd ;
	private String to;
	private String subject;
	private String text;
	
	public String getFrom(){
		return from;
	}
	public String getPwd(){
		return pwd;
	}
	public String getTo(){
		return to;
	}
	public String getSubject(){
		return subject;
	}
	public String getText(){
		return text;
	}
	public SendMail() {}
	
	public SendMail(String srcID, String pwd, String trgID, String tlt, String text){
		this.from = srcID;
		this.pwd = pwd;
		this.to = trgID;
		this.subject = tlt;
		this.text = text;
	}
	
	public SendMail(String s){
		System.out.println(s);
		char[] temp = s.toCharArray();
		char[] test = new char[400];
		int i = 0, length = 0;
		
		while (temp[i] != '%')
			i++;
		i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_from = new char[length];
		copy(temp_from, test);
		from = new String(temp_from);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_pwd = new char[length];
		copy(temp_pwd, test);
		pwd = new String(temp_pwd);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_to = new char[length];
		copy(temp_to, test);
		to = new String(temp_to);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_subject = new char[length];
		copy(temp_subject, test);
		subject = new String(temp_subject);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_text = new char[length];
		copy(temp_text, test);
		text = new String(temp_text);
		length = 0;i++;
	}

	public void DoThat() {
		Properties props = new Properties();
		// ���÷����ʼ����ʼ������������ԣ�����ʹ��gmail��smtp��������
		props.put("mail.smtp.host", host);
		// ��Ҫ������Ȩ��Ҳ�����л����������У�飬��������ͨ����֤��һ��Ҫ����һ����
		props.put("mail.smtp.auth", "true");
		// �øո����úõ�props���󹹽�һ��session
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "465");   
		props.setProperty("mail.smtp.socketFactory.port", "465");   

		Session session = Session.getDefaultInstance(props);
		// ������������ڷ����ʼ��Ĺ�������console����ʾ������Ϣ��������ʹ
		// �ã�������ڿ���̨��console)�Ͽ��������ʼ��Ĺ��̣�
		session.setDebug(true);
		// ��sessionΪ����������Ϣ����
		MimeMessage message = new MimeMessage(session);
		try {
			// ���ط����˵�ַ
			message.setFrom(new InternetAddress(from));
			// �����ռ��˵�ַ
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// ���ر���
			message.setSubject(subject);
			// ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
			Multipart multipart = new MimeMultipart();

			// �����ʼ����ı�����
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setText(text);
			multipart.addBodyPart(contentPart);
			message.setContent(multipart);
			// �����ʼ�
			message.saveChanges();
			// �����ʼ�
			Transport transport = session.getTransport("smtp");
			// ���ӷ�����������
			transport.connect(host, from, pwd);
			// ���ʼ����ͳ�ȥ
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return new String ("2%" + from + '%' + pwd + '%' + to + '%' + subject + '%' + text + '%');

	}
	
	private static void copy(char[] a, char[] b){
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static void main(String args[]){
		SendMail s = new SendMail("a", "b", "c", "d", "e");
		System.out.println(s.toString());
		SendMail ss= new SendMail(s.toString());
		System.out.println(ss.toString());
	}
}
