
package noteBlog.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import noteBlog.dao.NoteBlogDAO;
import noteBlog.dto.NoteBlog;

/**
 *
 * @author user01
 * Search Function.
 * This servlet searches blog articles, and forward to result list.
 */

@WebServlet("/note-blog/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
            throws IOException,ServletException {
        req.setCharacterEncoding("UTF-8");
        
        //DAO取得
        try(NoteBlogDAO dao = new NoteBlogDAO()) {
            //記事の一覧をリストで取得し、リクエスト属性へ格納する
            List<NoteBlog> list = dao.getArticleList();
            req.setAttribute("articleList",list);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //最新5件分DAO取得
        try(NoteBlogDAO dao = new NoteBlogDAO()) {
            //最新記事の5件をリストで取得し、リクエスト属性へ格納する
            List<NoteBlog> list = dao.getLatestArticleList();
            req.setAttribute("latestArticleList",list);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //検索結果一覧を表示する
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/search.jsp");
        rd.forward(req,rsp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException,IOException {
        doGet(req,rsp);
    }   
}
