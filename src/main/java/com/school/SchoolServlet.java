package com.school;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SchoolServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to Our School!</h1>");
        out.println("<p>We provide quality education to students.</p>");
        out.println("</body></html>");
        out.close();
    }
}
