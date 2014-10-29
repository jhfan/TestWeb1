package com.mercury.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mercury.beans.User;
import com.mercury.service.HelloService;
//import org.apache.catalina.User;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HelloService hs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        
        if(hs==null){
        	hs = new HelloService();
        }
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// similar controller
		//String name = request.getParameter("name");
		//int age = Integer.parseInt(request.getParameter("age"));
		User user = parse(request);
		// set output
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// but if you have ten columns to save, it will be a big problem to have ten lines of codes
		//HelloService hs = new HelloService();
		out.print(hs.sayHello(user));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = parse(request);
		request.setAttribute("userInfo", hs.process(user));
		String url = "/result.jsp";
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private User parse(HttpServletRequest request){
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		return user;
	}

}
