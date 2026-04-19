//10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP
//called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all
//the fields with server sided validation and display all the data along with result ( Pass if all subjects
//greater than 40%) and Average marks through result.jsp with a link to move to the client side

package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

@WebServlet("/processResult")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        String s1 = request.getParameter("sub1");
        String s2 = request.getParameter("sub2");
        String s3 = request.getParameter("sub3");
        String s4 = request.getParameter("sub4");
        String s5 = request.getParameter("sub5");

        String message;

        try {
            if (rollno == null || rollno.isEmpty() || name == null || name.isEmpty()) {
                message = "Error: Roll No and Name are required";
            } else {
                int sub1 = Integer.parseInt(s1);
                int sub2 = Integer.parseInt(s2);
                int sub3 = Integer.parseInt(s3);
                int sub4 = Integer.parseInt(s4);
                int sub5 = Integer.parseInt(s5);

                // Calculate average
                double avg = (sub1 + sub2 + sub3 + sub4 + sub5) / 5.0;

                // Result
                String result;
                if (sub1 >= 40 && sub2 >= 40 && sub3 >= 40 && sub4 >= 40 && sub5 >= 40) {
                    result = "PASS";
                } else {
                    result = "FAIL";
                }

                message = "Result Processed Successfully";

                request.setAttribute("rollno", rollno);
                request.setAttribute("name", name);
                request.setAttribute("sub1", sub1);
                request.setAttribute("sub2", sub2);
                request.setAttribute("sub3", sub3);
                request.setAttribute("sub4", sub4);
                request.setAttribute("sub5", sub5);
                request.setAttribute("average", avg);
                request.setAttribute("result", result);
            }

        } catch (Exception e) {
            message = "Error: Invalid input (Enter numbers only)";
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }
}
