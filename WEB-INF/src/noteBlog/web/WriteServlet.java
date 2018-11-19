
package noteBlog.web;

import java.sql.*;
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import noteBlog.dao.NoteBlogDAO;
import noteBlog.dto.NoteBlog;

/**
  *
  * @author OmOm-muron
  * ブログの記事の一つを表示する
  */
@WebServlet("/note-blog/write")
public class WriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        //リクエストパラメータを受け取り、DTOに格納する準備
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        
        java.sql.Date uploadTime = new java.sql.Date(new java.util.Date().getTime());

        //DTOへ格納
        NoteBlog dto = new NoteBlog();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setUploadDate(uploadTime);

        //記事を投稿する
        try (NoteBlogDAO dao = new NoteBlogDAO()) {
            dao.writeArticle(dto);
            String message = "新しい記事を投稿しました！";
            req.setAttribute("message",message);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //投稿完了→完了画面へ
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/write.jsp");
        rd.forward(req,rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        doGet(req,rsp);
    }
}

