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
			System.out.println("条件满足，开始执行");
			thatrun(That);
		}else
			System.out.println("error!");
	}

	private void thatrun(String s) {
		char[] temp = s.toCharArray();
		switch (temp[0]){
		case '1': new SendWeibo(s).DoThat();break;
		case '2': new SendMail(s).DoThat();break;
		default: System.out.print("that格式错误!");break;
		}
		
	}

	private boolean thisrun(String s) {
		char[] temp = s.toCharArray();
		switch (temp[0]){
		case '1': return new Time(s).ReturnThis();
		case '2': return new GetMail(s).ReturnThis();
		case '3': return new GetWeibo(s).ReturnThis();
		case '4': return new NotGetWeiboBefore(s).ReturnThis();
		default: System.out.print("this格式错误!");return false;
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
		case 1:return "在指定时间内向目的邮箱发一封邮件:";
		case 2:return "在指定时间内在目标微博发表新状态";
		case 3:return "当指定邮箱收到新邮件时，向目的邮箱发一封邮件";
		case 4:return "当指定邮箱收到新邮件时，在目标微博发表新状态";
		case 5:return "当指定微博更新指定内容的状态时，向目的邮箱发一封邮件";
		case 6:return "当指定微博更新指定内容的状态时,在目标微博发表新状态";
		case 7:return "从任务开始，到指定时间内，如果指定微博未更新状态，则像目的邮箱发一封邮件";
		case 8:return "从任务开始，到指定时间内，如果指定微博未更新状态，则在目标微博发表新状态";
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
			return "在"+tmp1.getTime()+"时刻登录邮箱"+tmp2.getFrom()+"给邮箱"+tmp2.getTo()
				+"发送一封标题为"+tmp2.getSubject()+"内容为"+tmp2.getText()+"的邮件";
			}
		case 2:{
			Time tmp1=new Time(THIS);
			SendWeibo tmp2=new SendWeibo(THAT);
			return "在"+tmp1.getTime()+"时刻登录微博"+tmp2.getID()
				+"发送一条状态为"+tmp2.getMessage()+"的微博";
			}
		case 3:{
			GetMail tmp1=new GetMail(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "在指定邮箱"+tmp1.getID()+"收到邮件后"+"登录邮箱"+tmp2.getFrom()+"给邮箱"+tmp2.getTo()
				+"发送一封标题为"+tmp2.getSubject()+"内容为"+tmp2.getText()+"的邮件";
			}
		case 4:{
			GetMail tmp1=new GetMail(THIS);
			SendWeibo tmp2;
			tmp2=new SendWeibo(THAT);
			return "在指定邮箱"+tmp1.getID()+"收到邮件后"+"登录微博"+tmp2.getID()
				+"发送一条状态为"+tmp2.getMessage()+"的微博";
			}
		case 5:{
			GetWeibo tmp1=new GetWeibo(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "在指定微博"+tmp1.getID()+"更新状态"+tmp1.getText()+"后"+"登录邮箱"+tmp2.getFrom()+"给邮箱"+tmp2.getTo()
			+"发送一封标题为"+tmp2.getSubject()+"内容为"+tmp2.getText()+"的邮件";
			}
		case 6:{
			GetWeibo tmp1=new GetWeibo(THIS);
			SendWeibo tmp2;
			tmp2=new SendWeibo(THAT);
			return "在指定微博"+tmp1.getID()+"更新状态"+tmp1.getText()+"后"+"登录微博"+tmp2.getID()
				+"发送一条状态为"+tmp2.getMessage()+"的微博";
			}
		case 7:{
			NotGetWeiboBefore tmp1=new NotGetWeiboBefore(THIS);
			SendMail tmp2;
			tmp2=new SendMail(THAT);
			return "从任务开始，到指定时间"+tmp1.getEndTime()+"内，如果微博"+tmp1.getID()+"未更新状态,"+"登录邮箱"+tmp2.getFrom()+"给邮箱"+tmp2.getTo()
			+"发送一封标题为"+tmp2.getSubject()+"内容为"+tmp2.getText()+"的邮件";			}
		case 8:{
			NotGetWeiboBefore tmp1=new NotGetWeiboBefore(THIS);
			SendWeibo tmp2;
			tmp2=new SendWeibo(THAT);
			return "从任务开始，到指定时间"+tmp1.getEndTime()+"内，如果微博"+tmp1.getID()+"未更新状态,"+"登录微博"+tmp2.getID()
				+"发送一条状态为"+tmp2.getMessage()+"的微博";
			}
		default: return "not exist the task !!!";
		}
	}
	
	public static Date getCurrentTime(){
		Date date=new Date();
		return date;
	}
}
