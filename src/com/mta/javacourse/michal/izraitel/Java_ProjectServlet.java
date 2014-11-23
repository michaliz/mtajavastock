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
		
		int radius = 50;
		String line1 = new String("Calculation 1: Area of circle with radius " +radius+ " cm is: " +Math.PI * Math.pow(radius, 2)+ " square cm.");
		
		int angleB = 30, hypotenuse = 50;
		double radians = Math.toRadians(angleB);
		double sin = Math.sin(radians);
		String line2 = new String("Calculation 2: Length of opposite where angle B is " +angleB+ " degrees and Hypotenuse length is " +hypotenuse+ " cm is: " +sin * hypotenuse+ " cm.");
		
		int base = 20, exp = 13;
		String line3 = new String("Calculation 3: Power of 20 with exp of 13 is: " + (long)Math.pow(base, exp));
		resp.getWriter().println("<br>" +line1+ "<br>" + line2 + "<br>" + line3);
		}
}