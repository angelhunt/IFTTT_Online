package Objects;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;
import Dao.*;

public class StoreTaskInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StoreTaskInfo() {
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
		String THIS=null,THAT=null;
		response.setContentType("text/html");
		int type=(Integer)request.getSession().getAttribute("type");
		System.out.println(type);
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String srcID = request.getParameter("srcID");
		String srcPassword = request.getParameter("srcPassword");
		String srcContent = request.getParameter("srcContent");
		String myID = request.getParameter("myID");
		String myPassword = request.getParameter("myPassword");
		String desID = request.getParameter("desID");
		String title = request.getParameter("taskName");
		String desContent = request.getParameter("desContent");
		
		switch (type){
		case 1:	THIS = "1%" + date + " " + time +"%";
			THAT = "2%" + myID + "%" + myPassword + "%" + desID + "%" + title + "%" + desContent  + "%";
			break;
		case 2: THIS = "1%" + date + " " + time +"%";
			THAT = "1%" + myID + "%" + myPassword + "%" + desContent + "%";
			break;
		case 3:	THIS = "2%" + srcID + "%" + srcPassword + "%";
			THAT = "2%" + myID + "%" + myPassword + "%" + desID + "%" + title + "%" + desContent  + "%";
			break;
		case 4:	THIS = "2%" + srcID + "%" + srcPassword + "%";
			THAT = "1%" + myID + "%" + myPassword + "%" + desContent + "%";
			break;
		case 5:	THIS = "3%" + srcID + "%" + srcPassword + "%" + srcContent + "%";
			THAT = "2%" + myID + "%" + myPassword + "%" + desID + "%" + title + "%" + desContent  + "%";	
			break;
		case 6:	THIS = "3%" + srcID + "%" + srcPassword + "%" + srcContent + "%";
			THAT = "1%" + myID + "%" + myPassword + "%" + desContent + "%";
			break;
		case 7:	THIS = "4%" + srcID + "%" + srcPassword + "%" + date + " " + time + "%";
			THAT = "2%" + myID + "%" + myPassword + "%" + desID + "%" + title + "%" + desContent  + "%";
			break;
		case 8:	THIS = "4%" + srcID + "%" + srcPassword + "%" + date + " " + time + "%";
			THAT = "1%" + myID + "%" + myPassword + "%" + desContent + "%";
			break;
		default:	System.out.println("task not exists");
		}
		
	
		System.out.println(THIS+"   "+THAT+ "   "+(String)request.getSession().getAttribute("username"));
		Task task=new Task();
		task.setCreateTime(Time.getCurrentTime());
		task.setTaskName(request.getParameter("taskName"));
		task.setThis(THIS);
		task.setThat(THAT);
		task.setUserName((String)request.getSession().getAttribute("username"));
		Dao.addTask(task);
		response.sendRedirect("UserLogin.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
