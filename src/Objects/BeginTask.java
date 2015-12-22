package Objects;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.*;
import Model.*;
import MyDao.*;

public class BeginTask extends HttpServlet {

	ExecutorService executor;
	
	public BeginTask() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String taskName=request.getParameter("taskList");
		String username=(String)(request.getSession().getAttribute("username"));
		System.out.println(taskName+"||"+username);
		Task task=Dao.selectTask(username, taskName);
		if(task==null) System.out.println("error");
		User tmp=Dao.selectUser(username);
		double money=tmp.getMoney()-50;
		double vip=tmp.getVIPpoint()+0.5;
		tmp.setMoney(money);
		tmp.setVIPpoint(vip);
		Dao.UpdateUser(tmp);
		System.out.println(task.getTaskName()+"|||"+task.getCreateTime());
		SpendRecord record=new SpendRecord(username,task.getTaskName(),task.getCreateTime(),50);
		Dao.addSpendRecord(record);
		Thread thread1=new Thread(task);
		thread1.start();
		
		response.sendRedirect("UserLogin.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		if(executor==null){
			executor=Executors.newFixedThreadPool(8);
		}
	}

}
