
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
 * ブログの記事の一つを表示する
 */
@WebServlet("/noteBlog/read")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        String articleId = req.getParameter("id");
        
        //intへ変換して、daoで処理を行う 表示対象の記事を1つ取得する
        NoteBlog dto;
        try (NoteBlogDAO dao = new NoteBlogDAO()) {
            int id = Integer.parseInt(articleId);
            
            dto = dao.readArticle(id);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //記事の情報をリクエスト属性へバインド
        req.setAttribute("dto", dto);
        
        //最新5件分DAO取得
        try(NoteBlogDAO dao = new NoteBlogDAO()) {
            //最新記事の5件をリストで取得し、リクエスト属性へ格納する
            List<NoteBlog> list = dao.getLatestArticleList();
            req.setAttribute("latestArticleList",list);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //画面を返す
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/read.jsp");
        rd.forward(req,rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        doGet(req,rsp);
    }
}
