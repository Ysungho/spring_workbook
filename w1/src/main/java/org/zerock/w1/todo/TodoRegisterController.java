/*Get 방식으로 호출되는 경우에도 입력할 수 있는 화면을 보여주고,
* Post 방식으로 호출되는 경우에는 등록이 처리된 후 다시 목록 페이지를 호출함*/

package org.zerock.w1.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("입력 화면 볼 수 있도록 구성");
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("입력을 처리하고 목록 페이지로 이동");

        //브라우저가 호출해야 하는 주소
        resp.sendRedirect("/todo/list");
    }
}
