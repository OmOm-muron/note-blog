
package noteBlog.dao;

import java.sql.*;
import java.util.*;
import noteBlog.dto.NoteBlog;

/**
 *
 * @author user01
 */
public class WriteBlogDAO extends DAO {
    public void writeArticle(String name, String filename, String content) throws Exception {
        String sql = "INSERT INTO articles (name,filename,uploadDate,content)"
                + "VALUES (" + name + ", " + filename + ", " + (Timestamp) new java.util.Date() + ", " + content + ")";
        
        PreparedStatement statement = getPreparedStatement(sql);
        
        ResultSet rs = statement.executeQuery();
        commit();
        
        
    }
}
