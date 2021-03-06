
package noteBlog.web;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import noteBlog.dao.NoteBlogDAO;
import noteBlog.dto.NoteBlog;

/**
 *
 * @author OmOm-muron
 * ブログの記事の一つを削除する
 */
@WebServlet("/note-blog/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String articleId = req.getParameter("id");
        
        //intへ変換して、daoで処理を行う 表示対象の記事を1つ取得する
        int result;
        try (NoteBlogDAO dao = new NoteBlogDAO()) {
            int id = Integer.parseInt(articleId);
            
            result = dao.deleteArticle(id);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        //削除件数をリクエスト属性へ格納
        req.setAttribute("resultCount",result);
        
        //最新5件分DAO取得
        try(NoteBlogDAO dao = new NoteBlogDAO()) {
            //最新記事の5件をリストで取得し、リクエスト属性へ格納する
            List<NoteBlog> list = dao.getLatestArticleList();
            req.setAttribute("latestArticleList",list);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //画面を返す
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/delete.jsp");
        rd.forward(req,rsp);
    }
}
