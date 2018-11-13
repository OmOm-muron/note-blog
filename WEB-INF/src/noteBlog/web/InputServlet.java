
package noteBlog.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import noteBlog.dto.NoteBlog;

/**
  *
  * @author OmOm-muron
  * ブログの記事の一つを表示する
  */
@WebServlet("/noteBlog/input")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        //voの作成
        NoteBlog dto = new NoteBlog();

        //DTOをリクエスト属性へバインド
                req.setAttribute("dto", dto);

        //記事記述画面を返す
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/input.jsp");
        rd.forward(req,rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        doGet(req,rsp);
    }
}

