package Objects;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;
import Model.*;

public class CheckInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckInfo() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+password);
		if(username.equals("System" )&& password.equals("System"))
			response.sendRedirect("SystemLogin.jsp");
		else{
			boolean tf=Dao.CheckUser(username, password);
			if(tf==true) 
				try {
					User tmp=Dao.selectUser(username);
					double money=tmp.getMoney();
					double vip=tmp.getVIPpoint();
					HttpSession session=request.getSession();
					session.setAttribute("username",username);
					session.setAttribute("password",password);
					session.setAttribute("money",money);
					session.setAttribute("vippoint",vip );
					response.sendRedirect("UserLogin.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				else
					response.sendRedirect("Login.jsp");
		}

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
