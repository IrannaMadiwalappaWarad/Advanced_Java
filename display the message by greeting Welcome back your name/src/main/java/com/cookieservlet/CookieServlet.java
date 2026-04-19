//8a. Build a servlet program to create a cookie to get your name through text box and press submit button(
//through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
//n times ( n = number of your visit ) along with the list of cookies and demonstrate the expiry of cookie also.
package com.cookieservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String userName = request.getParameter("userName");

        int visitCount = 1;
        String existingUser = null;

        // Read cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    visitCount = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // If user enters name first time
        if (userName != null && !userName.isEmpty()) {
            existingUser = userName;

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(30); // expires in 30 sec

            Cookie countCookie = new Cookie("count", "1");
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);

            visitCount = 1;
        } else {
            // Update visit count cookie
            Cookie countCookie = new Cookie("count", String.valueOf(visitCount));
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);
        }

        // HTML Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page "
                    + visitCount + " times!</h2>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please enter your name</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}
