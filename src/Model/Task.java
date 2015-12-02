package Model;

import java.util.Date;

public class Task implements Runnable{
	protected String UserName;
	protected String TaskName;
	protected String This;
	protected String That;
	protected String CreateTime;
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getTaskName() {
		return TaskName;
	}

	public void setTaskName(String taskName) {
		TaskName = taskName;
	}

	public String getThis() {
		return This;
	}

	public void setThis(String this1) {
		This = this1;
	}

	public String getThat() {
		return That;
	}

	public void setThat(String that) {
		That = that;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	
	public Task() {};

	public Task(String UserName, String TaskName, String This, String That, String CreateTime){
		this.UserName = UserName;
		this.TaskName = TaskName;
		this.This = This;
		this.That = That;
		this.CreateTime = CreateTime;
	}
	
	

	public void run() {
		System.out.println("task is begun");
		if (thisrun(This)){
			System.out.println("�������㣬��ʼִ��");
			thatrun(That);
		}else
			System.out.println("error!");
	}

	private void thatrun(String s) {
		char[] temp = s.toCharArray();
		switch (temp[0]){
		case '1': new SendWeibo(s).DoThat();break;
		case '2': new SendMail(s).DoThat();break;
		default: System.out.print("that��ʽ����!");break;
		}
		
	}

	private boolean thisrun(String s) {
		char[] temp = s.toCharArray();
		switch (temp[0]){
		case '1': return new Time(s).ReturnThis();
		case '2': return new GetMail(s).ReturnThis();
		case '3': return new GetWeibo(s).ReturnThis();
		case '4': return new NotGetWeiboBefore(s).ReturnThis();
		default: System.out.print("this��ʽ����!");return false;
		}
	}
	public static int checkTaskType(String[] THIS,String THAT){
		if(THIS.length==1 && THIS[0].equals("Clock") && THAT.equals("Gmail")){
			return 1;
		}else if(THIS.length == 1 && THIS[0].equals("Clock") && THAT.equals("Weibo")){
			return 2;
		}else if (THIS.length == 1 && THIS[0].equals("Gmail") && THAT.equals("Gmail")){
			return 3;
		}else if(THIS.length == 1 && THIS[0].equals("Gmail") && THAT.equals("Weibo")){
			return 4;
		}else if (THIS.length == 1 && THIS[0].equals("Weibo") && THAT.equals("Gmail")){
			return 5;
		}else if (THIS.length == 1 && THIS[0].equals("Weibo") && THAT.equals("Weibo")){
			return 6;
		}else if (THIS.length == 2 && THIS[0].equals("Clock") && THIS[1].equals("Weibo")
				&& THAT.equals("Gmail")){
			return 7;
		}else if (THIS.length == 2 && THIS[0].equals("Clock") && THIS[1].equals("Weibo")
				&& THAT.equals("Weibo")){
			return 8;
		}else
			return -1;
	}
	public static int checkTaskType(String THIS,String THAT){
		if(THIS.toCharArray()[0]=='1' && THAT.toCharArray()[0]=='2')
			return 1;
		else if (THIS.toCharArray()[0]=='1' && THAT.toCharArray()[0]=='1')
			return 2;
		else if (THIS.toCharArray()[0]=='2' && THAT.toCharArray()[0]=='2')
			return 3;
		else if (THIS.toCharArray()[0]=='2' && THAT.toCharArray()[0]=='1')
			return 4;
		else if (THIS.toCharArray()[0]=='3' && THAT.toCharArray()[0]=='2')
			return 5;
		else if (THIS.toCharArray()[0]=='3' && THAT.toCharArray()[0]=='1')
			return 6;
		else if (THIS.toCharArray()[0]=='4' && THAT.toCharArray()[0]=='2')
			return 7;
		else if (THIS.toCharArray()[0]=='4' && THAT.toCharArray()[0]=='1')
			return 8;
		else 
			return -1;
	}
	public static String getDiscription(int type){
		switch (type){
		case 1:return "��ָ��ʱ������Ŀ�����䷢һ���ʼ�:";
		case 2:return "��ָ��ʱ������Ŀ��΢��������״̬";
		case 3:return "��ָ�������յ����ʼ�ʱ����Ŀ�����䷢һ���ʼ�";
		case 4:return "��ָ�������յ����ʼ�ʱ����Ŀ��΢��������״̬";
		case 5:return "��ָ��΢������ָ�����ݵ�״̬ʱ����Ŀ�����䷢һ���ʼ�";
		case 6:return "��ָ��΢������ָ�����ݵ�״̬ʱ,��Ŀ��΢��������״̬";
		case 7:return "������ʼ����ָ��ʱ���ڣ����ָ��΢��δ����״̬������Ŀ�����䷢һ���ʼ�";
		case 8:return "������ʼ����ָ��ʱ���ڣ����ָ��΢��δ����״̬������Ŀ��΢��������״̬";
		default:return "not exist the task !!!";
		}
	}
	
	public static String getDiscription(String THIS,String THAT){
		int type=Task.checkTaskType(THIS, THAT);
		System.out.println(type);
		switch (type){
		case 1:{
			Time tmp1=new Time(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "��"+tmp1.getTime()+"ʱ�̵�¼����"+tmp2.getFrom()+"������"+tmp2.getTo()
				+"����һ�����Ϊ"+tmp2.getSubject()+"����Ϊ"+tmp2.getText()+"���ʼ�";
			}
		case 2:{
			Time tmp1=new Time(THIS);
			SendWeibo tmp2=new SendWeibo(THAT);
			return "��"+tmp1.getTime()+"ʱ�̵�¼΢��"+tmp2.getID()
				+"����һ��״̬Ϊ"+tmp2.getMessage()+"��΢��";
			}
		case 3:{
			GetMail tmp1=new GetMail(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "��ָ������"+tmp1.getID()+"�յ��ʼ���"+"��¼����"+tmp2.getFrom()+"������"+tmp2.getTo()
				+"����һ�����Ϊ"+tmp2.getSubject()+"����Ϊ"+tmp2.getText()+"���ʼ�";
			}
		case 4:{
			GetMail tmp1=new GetMail(THIS);
			SendWeibo tmp2;
			tmp2=new SendWeibo(THAT);
			return "��ָ������"+tmp1.getID()+"�յ��ʼ���"+"��¼΢��"+tmp2.getID()
				+"����һ��״̬Ϊ"+tmp2.getMessage()+"��΢��";
			}
		case 5:{
			GetWeibo tmp1=new GetWeibo(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "��ָ��΢��"+tmp1.getID()+"����״̬"+tmp1.getText()+"��"+"��¼����"+tmp2.getFrom()+"������"+tmp2.getTo()
			+"����һ�����Ϊ"+tmp2.getSubject()+"����Ϊ"+tmp2.getText()+"���ʼ�";
			}
		case 6:{
			GetWeibo tmp1=new GetWeibo(THIS);
			SendWeibo tmp2;
			tmp2=new SendWeibo(THAT);
			return "��ָ��΢��"+tmp1.getID()+"����״̬"+tmp1.getText()+"��"+"��¼΢��"+tmp2.getID()
				+"����һ��״̬Ϊ"+tmp2.getMessage()+"��΢��";
			}
		case 7:{
			NotGetWeiboBefore tmp1=new NotGetWeiboBefore(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "������ʼ����ָ��ʱ��"+tmp1.getEndTime()+"�ڣ����΢��"+tmp1.getID()+"δ����״̬,"+"��¼����"+tmp2.getFrom()+"������"+tmp2.getTo()
			+"����һ�����Ϊ"+tmp2.getSubject()+"����Ϊ"+tmp2.getText()+"���ʼ�";			}
		case 8:{
			NotGetWeiboBefore tmp1=new NotGetWeiboBefore(THIS);
			SendWeibo tmp2;
			tmp2=new SendWeibo(THAT);
			return "������ʼ����ָ��ʱ��"+tmp1.getEndTime()+"�ڣ����΢��"+tmp1.getID()+"δ����״̬,"+"��¼΢��"+tmp2.getID()
				+"����һ��״̬Ϊ"+tmp2.getMessage()+"��΢��";
			}
		default: return "not exist the task !!!";
		}
	}
	
	public static Date getCurrentTime(){
		Date date=new Date();
		return date;
	}
}
