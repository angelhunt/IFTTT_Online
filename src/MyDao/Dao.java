package MyDao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import MyDao.Dao;
import Model.*;

public class Dao {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl =  "jdbc:mysql://localhost:3306/IFTTTDB";
	
	protected static String dbUser = "root";
	protected static String dbPwd = "Mm14719961233";
	private static Connection conn = null;
	
	
	public static void main(String[] args) throws SQLException
	{
           Dao d = new Dao();
		   System.out.println(conn);
		 // addUser(new User("MHJ", "123"));
		   boolean tf=Dao.CheckUser("1137633684", "14719961233");
		   User  t = d.selectUser("1137633684");
		   System.out.println(t.getPassWord());
			//User user=new User("1137633684", "14719961233");
			//Dao.addUser(user);
	}
	private Dao(){
		try{
			if (conn == null){
				Class.forName(dbClassName); 
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}
	
	private static int executeUpdate(String sql){
		try{
			if (conn == null) new Dao();
			Statement stm = conn.createStatement();
			return stm.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
			return -2;
		}finally{}
	}
	
	private static ResultSet executeQuery(String sql) {
		try{
			if (conn == null) new Dao();
			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			return stm.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		return null;
		}
	}
	
	private static void close(){
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{conn = null;}
	}
	
	public static void addUser(User us) {

		try{
			String sql = "insert into user(username, password, money, vippoint) values ('"+us.getUserName()+"','"+us.getPassWord()+"', '"+us.getMoney()+"', '"+us.getVIPpoint()+"')";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static ArrayList selectUser() {
		ArrayList list=new ArrayList();
		
		String sql = "select *  from user";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				User us=new User(rs.getString("username"), rs.getString("password"), rs.getDouble("money"), rs.getDouble("vippoint"));
				list.add(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	
	public static User selectUser(String username) {
		User us = null;
		String sql = "select *  from user where username = '"+username+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			if (rs.next()) {
				us=new User(rs.getString("username"), rs.getString("password"), rs.getDouble("money"), 
						rs.getDouble("vippoint"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return us;
	}
	
	public static boolean CheckUser(String name, String password){
		String sql = "select * from user where username = '"+name+"' and password = '"+password+"'" ;
		ResultSet rs = Dao.executeQuery(sql);
		try{
			while (rs.next()){
				System.out.print(rs.getString("username")+ rs.getString("password"));
				if (rs.getString("username").startsWith(name) && rs.getString("password").startsWith(password))
					return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Dao.close();
		return false;
	}
	
	public static void UpdateUser(User us) {

		try{
			String sql = "update user set password = '"+us.getPassWord()+"', money = '"+us.getMoney()+"', vippoint = '"+us.getVIPpoint()+"' where username = '"+us.getUserName()+"'";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static void DeleteUser(User us) {

		try{
			String sql = "delete from user where username = '"+us.getUserName()+"'";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static void addTask(Task task) {

		try{
			String sql = "insert into task (username, taskname, this, that, createtime) values ('"+task.getUserName()+"','"+task.getTaskName()+"', '"+task.getThis()+"', '"+task.getThat()+"', '"+task.getCreateTime()+"')";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static ArrayList selectTask() {
		ArrayList list=new ArrayList();
		
		String sql = "select *  from task";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				Task task=new Task(rs.getString("username"), rs.getString("taskname"), rs.getString("this"), rs.getString("that"), rs.getString("createtime"));
				list.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	
	public static ArrayList selectTask(String username) {
		ArrayList list=new ArrayList();
		String sql = "select *  from Task where username = '"+username+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while(rs.next()) {
				Task task=new Task(rs.getString("username"), rs.getString("taskname"), rs.getString("this"), rs.getString("that"), rs.getString("createtime"));
				list.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	
	public static Task selectTask(String username,String taskName) {
		Task task = null;
		String sql = "select *  from task where username = '"+username+"' and TaskName = '"+taskName+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			if (rs.next()) {
				task=new Task(rs.getString("UserName"), rs.getString("TaskName"), rs.getString("THIS"), 
						rs.getString("THAT"),rs.getString("CreateTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return task;
	}
	
	public static void UpdateTask(Task task) {

		try{
			String sql = "update task set taskname = '"+task.getTaskName()+"', this = '"+task.getThis()+"', that = '"+task.getThat()+"' where username = '"+task.getUserName()+"' and createtime = '"+task.getCreateTime()+"'";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static void DeleteTask(Task task) {

		try{
			String sql = "delete from task where username = '"+task.getUserName()+"' and createtime = '"+task.getCreateTime()+"'";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static void addSpendRecord(SpendRecord sr) {

		try{
			String sql = "insert into SpendRecord(UserName, TaskName, CreateTime, Value) values ('"+sr.getUserName()+"','"+sr.getTaskName()+"','"+sr.getCreateTime()+"','"+sr.getValue()+"')";
			System.out.println(sql);
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static ArrayList selectSpendRecord(String UserName) {
		ArrayList list=new ArrayList();
		
		String sql = "select *  from spendrecord where username = '"+UserName+"'";
		ResultSet rs = Dao.executeQuery(sql);
		if(rs==null) return null;
		try {
			while (rs.next()) {
				SpendRecord sr=new SpendRecord(rs.getString("username"), rs.getString("taskname"), rs.getString("createtime"), rs.getDouble("value"));
				list.add(sr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	
	public static void addMessage(message m) {

		try{
			String sql = "insert into message(sourcename, targetname, sendtime, title, content) values ('"+m.getSourceName()+"','"+m.getTargetName()+"', '"+m.getSendTime()+"', '"+m.getTitle()+"', '"+m.getContent()+"')";
			executeUpdate(sql);
			Dao.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public static ArrayList selectMessage() {
		ArrayList list=new ArrayList();
		
		String sql = "select *  from Message";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				message message=new message(rs.getString("sourcename"), rs.getString("targetname"), rs.getString("sendtime"), rs.getString("title"), rs.getString("content"));
				list.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	
	public static ArrayList sendMessageBox(String sourceName) {
		ArrayList list=new ArrayList();
		
		String sql = "select *  from message where sourcename = '"+sourceName+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				message m =new message(rs.getString("sourcename"), rs.getString("targetname"), rs.getString("sendtime"), rs.getString("title"), rs.getString("content"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	
	public static ArrayList getMessageBox(String targetName) {
		ArrayList list=new ArrayList();
		
		String sql = "select *  from message where targetname = '"+targetName+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				message m =new message(rs.getString("sourcename"), rs.getString("targetname"), rs.getString("sendtime"), rs.getString("title"), rs.getString("content"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
}
