//서블릿 사용 연습

package org.zerock.w1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="myServlet", urlPatterns = "/my")
public class MyServlet extends HttpServlet{

    @Override
    /*doGet은 브라우저의 주소를 직접 변경해서 접근하는 경우에 호출되는 메소드*/
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out=resp.getWriter();
        /*servlet에서는 PrintWriter 객체를 사용해서 브라우저쪽으로 출력을 처리함*/
        out.println("<html><body>");
        out.println("<h1>MyServlet</h1>");
        out.println("</body></html>");
    }
}
