import javafx.print.Printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calc", urlPatterns = {"/calculator"})
public class Calculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int num3 = Integer.parseInt(req.getParameter("num3"));
        int num4 = Integer.parseInt(req.getParameter("num4"));

        int sum = num1+num2;
        int prod = num3*num4;

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form action=\"/calculator\" method=\"get\">\n" +
                "\n" +
                "    <p class=\"sum\">\n" +
                "        <input type=\"number\" name=\"num1\" value=\""+num1+"\"> <span>&nbsp;+ &nbsp; </span>\n" +
                "        <input type=\"number\" name=\"num2\" value=\""+num2+"\"> <span>&nbsp;= &nbsp; </span> <input type=\"number\" name=\"result\" value=\""+sum+"\">\n" +
                "    </p>\n" +
                "\n" +
                "    <br/>\n" +
                "    <p class=\"prod\">\n" +
                "        <input type=\"number\" name=\"num3\" value=\""+num3+"\"> <span>&nbsp;+ &nbsp; </span>\n" +
                "        <input type=\"number\" name=\"num4\" value=\""+num4+"\"> <span>&nbsp;= &nbsp; </span> <input type=\"number\" name=\"result\" value=\""+prod+"\">\n" +
                "    </p>\n" +
                "    <br/>\n" +
                "\n" +
                "    <p class=\"subm\" >\n" +
                "        <input type=\"submit\" value=\"Submit\">\n" +
                "    </p>\n" +
                "\n" +
                "\n" +
                "</form>");
    }
}
