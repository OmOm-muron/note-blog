
package noteBlog.dto;

import java.sql.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author user01
 * ブログ一覧検索1行単位のDataTransferObject
 */
public class NoteBlog {
    //フィールド：ブログ記事の情報
    private int id;
    private String title;
    private java.sql.Date uploadDate;
    private String content;
    
    //Getter
    public int getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public java.sql.Date getUploadDate() {
        return this.uploadDate;
    }
    
    public String getContent() {
        return this.content;
    }
    
    //Setter
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setUploadDate(java.sql.Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
