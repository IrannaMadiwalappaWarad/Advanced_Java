//6c. Build a servlet program to check the given number is prime number or not using HTML with step by
//step procedure.
package prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeNumber
 */
@WebServlet("/prime")
public class PrimeNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
		    // Get the number from the form
		    int number = Integer.parseInt(request.getParameter("number"));

		    // Validate input
		    if (number < 0) {
		        throw new IllegalArgumentException("Number cannot be negative");
		    }

		    boolean isPrime = true;
		    String calculation = "Checking divisibility:<br>";

		    if (number <= 1) {
		        isPrime = false;
		        calculation += number + " is not prime (must be greater than 1)";
		    } else {
		        for (int i = 2; i <= Math.sqrt(number); i++) {
		            calculation += number + " ÷ " + i + " = " + (number / (double)i) + "<br>";
		            if (number % i == 0) {
		                isPrime = false;
		                break;
		            }
		        }
		    }

		    String result = isPrime ? "Prime Number" : "Not a Prime Number";

		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Prime Result</title>");
		    out.println("<style>");
		    out.println(".container { margin: 20px; padding: 20px; width: 500px; border: 1px solid rgb(255, 255, 16); border-radius: 10px; }");
		    out.println(".result { margin: 20px 0; }");
		    out.println("</style>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<div class='container'>");
		    out.println("<h2>Prime Number Result</h2>");
		    out.println("<div class='result'>");

		    out.println("<p><b>Number:</b> " + number + "</p>");
		    out.println("<p><b>Result:</b> " + result + "</p>");
		    out.println("<p>" + calculation + "</p>");

		    out.println("</div>");
		    out.println("<a href='index.html'>Check Another Number</a>");
		    out.println("</div>");
		    out.println("</body>");
		    out.println("</html>");

		} catch (NumberFormatException e) {
		    displayError(out, "Please enter a valid number");
		} catch (IllegalArgumentException e) {
		    displayError(out, e.getMessage());
		}
	}
		private void displayError(PrintWriter out, String message) {
		    out.println("<html>");
		    out.println("<head><title>Error</title></head>");
		    out.println("<body>");
		    out.println("<div style='margin: 20px; color: red;'>");
		    out.println("<h2>Error</h2>");
		    out.println("<p>" + message + "</p>");
		    out.println("<a href='index.html'>Try Again</a>");
		    out.println("</div>");
		    out.println("</body>");
		    out.println("</html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
