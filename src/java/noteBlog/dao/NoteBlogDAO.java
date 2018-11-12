
package noteBlog.dao;

import java.sql.*;
import java.util.*;
import noteBlog.dto.NoteBlog;

/**
 *
 * @author user01
 */
public class NoteBlogDAO extends DAO {
    public List<NoteBlog> getArticleList() throws Exception {
        List<NoteBlog> returnList = new ArrayList<NoteBlog>();
        
        String sql = "SELECT id, name, filename, uploadDate, content FROM articles";
        
        //プリペアドステートメントを取得し、実行SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);
        
        //SQLを実行してその結果を取得する
        ResultSet rs = statement.executeQuery();
        
        //検索結果の行数分、取得結果をNetBlogインスタンスへ格納する
        while (rs.next()) {
            NoteBlog dto = new NoteBlog();
            
            //クエリ結果をVOへ格納
            dto.setId(rs.getInt("id"));
            dto.setName(rs.getString("name"));
            dto.setFileName(rs.getString("filename"));
            dto.setUploadDate(rs.getTimestamp("uploadDate"));
            dto.setContent(rs.getString("content"));
            
            returnList.add(dto);
        }
        
        return returnList;
    }
}
