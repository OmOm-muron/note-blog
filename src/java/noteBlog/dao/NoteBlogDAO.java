
package noteBlog.dao;

import java.sql.*;
import java.util.*;
import noteBlog.dto.NoteBlog;

/**
 *
 * @author user01
 */
public class NoteBlogDAO extends DAO {
    
    /**
     * 記事の一覧を取得する
     * @return
     * @throws Exception 
     */
    public List<NoteBlog> getArticleList() throws Exception {
        List<NoteBlog> returnList = new ArrayList<NoteBlog>();
        
        String sql = "SELECT id, title, uploadDate, content FROM articles ORDER BY uploadDate";
        
        //プリペアドステートメントを取得し、実行SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);
        
        //SQLを実行してその結果を取得する
        ResultSet rs = statement.executeQuery();
        
        //検索結果の行数分、取得結果をNetBlogインスタンスへ格納する
        while (rs.next()) {
            NoteBlog dto = new NoteBlog();
            
            //クエリ結果をVOへ格納
            dto.setId(rs.getInt("id"));
            dto.setTitle(rs.getString("title"));
            dto.setUploadDate(rs.getTimestamp("uploadDate"));
            dto.setContent(rs.getString("content"));
            
            returnList.add(dto);
        }
        
        return returnList;
    }
    
    /**
     * 一つの記事を抜き出して情報を返す
     * @param id
     * @return
     * @throws Exception 
     */
    public NoteBlog readArticle(int id) throws Exception {
        NoteBlog dto = new NoteBlog();
        
        String sql = "SELECT ?, title, uploadDate, content FROM articles";
        
        //PreparedStatement取得、SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);
        statement.setInt(1, id);
        
        //クエリ実行、結果を格納
        ResultSet rs = statement.executeQuery();
        
        //NoteBlogインスタンス(dto)に記事の情報を格納
        dto.setTitle(rs.getString("title"));
        dto.setUploadDate(rs.getTimestamp("uploadDate"));
        dto.setContent(rs.getString("content"));
        
        return dto;
    }
    
    /**
     * 記事を書き込む
     * @param dto
     * @return
     * @throws Exception 
     */
    public int writeArticle(NoteBlog dto) throws Exception {
        String sql = "INSERT INTO articles (title,uploadDate,content)"
                + "VALUES (?, ?, ?)";
        
        //resultを初期化
        int result = 0;
        
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, dto.getTitle());
            statement.setTimestamp(2, dto.getUploadDate());
            statement.setString(3, dto.getContent());
            
            result = statement.executeUpdate();

            //コミット
            super.commit();
        } catch (Exception e) {
            super.rollback();
            throw e;
        }
     
        return result;
    }
    
    public int deleteArticle(int id) throws Exception {
        String sql = "DELETE FROM articles WHERE id = ?";
        
        //resultを初期化
        int result = 0;
        
        //SQLを実行、例外があればロールバック
        try {
            //PreparedStatementを取得、SQLを渡す
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setInt(1, id);

            result = statement.executeUpdate();
            
            super.commit();
        } catch (Exception e) {
            super.rollback();
            throw e;
        }
        
        return result;
    }
}
