//8b. Build a servlet program to create a cookie to get your name through text box and press submit button(
//through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
//n times ( n = number of your visit ) along with the list of cookies and its setvalues and demonstrate the
//expiry of cookie also.
package com.bas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.*;




//Step 2: Create servlet class
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 int count = 0; // visit count

 // Step 3: Handle GET request
 public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     // Step 4: Get username from request
     String userName = request.getParameter("userName");

     if (userName != null && !userName.isEmpty()) {

         // Step 5: Create cookie
         Cookie userCookie = new Cookie("user", userName);

         // Step 6: Set expiry (30 seconds)
         userCookie.setMaxAge(30);

         response.addCookie(userCookie);
     }

     // Step 7: Read cookies
     Cookie[] cookies = request.getCookies();
     String existingUser = null;

     if (cookies != null) {
         for (Cookie c : cookies) {
             if (c.getName().equals("user")) {
                 existingUser = c.getValue();
             }
         }
     }

     // Step 8: HTML response
     out.println("<html>");
     out.println("<head><title>Cookie Example</title></head>");
     out.println("<body>");

     if (existingUser != null) {
         count++;

         out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
         out.println("<h2 style='color:green;'>You have visited this page " + count + " times!</h2>");

         // 🔹 Display all cookies
         out.println("<h3>List of Cookies:</h3>");
         if (cookies != null) {
             for (Cookie c : cookies) {
                 out.println("<p><b>Name:</b> " + c.getName() +
                         " | <b>Value:</b> " + c.getValue() +
                         " | <b>MaxAge:</b> " + c.getMaxAge() + "</p>");
             }
         }

         // Logout button
         out.println("<form action='CookieServlet' method='post'>");
         out.println("<input type='submit' value='Logout'>");
         out.println("</form>");

     } else {

         // First time user
         out.println("<h2 style='color:red;'>Welcome Guest! Please login</h2>");
         out.println("<form action='CookieServlet' method='get'>");
         out.println("Enter your name: <input type='text' name='userName'>");
         out.println("<input type='submit' value='Submit'>");
         out.println("</form>");
     }

     out.println("</body></html>");
 }

 // Step 9: Handle POST (logout)
 public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

     // Delete cookie
     Cookie cookie = new Cookie("user", "");
     cookie.setMaxAge(0);
     response.addCookie(cookie);

     response.sendRedirect("CookieServlet");
 }
}

