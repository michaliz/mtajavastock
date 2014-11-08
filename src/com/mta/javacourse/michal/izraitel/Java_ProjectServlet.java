package com.mta.javacourse.michal.izraitel;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Java_ProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int num1 = 4, num2 = 3, num3 = 7;
		int res = (num2 + num3) * num1 + (num2 * num2);
		String resultStr = new String("<h1>Result of ("+num2+" + "+num3+") * " +num1+ " + ("+num2+ " * " +num2+ ") = " +res+"</h1>");
		resp.setContentType("text/html");
		resp.getWriter().println(resultStr);
	}
}