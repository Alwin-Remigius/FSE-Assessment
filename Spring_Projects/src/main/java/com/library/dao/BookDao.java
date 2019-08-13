package com.library.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.library.beans.Book;
  
public class BookDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Book book){  
    String sql="insert into book(bookId,title,price,publishDate,volume) values("+book.getBookId()+",'"+book.getTitle()+"',"+book.getPrice()+",'"+book.getPublishDate()+"',"+book.getVolume()+")";  
    return template.update(sql);  
}  
public int update(Book p){  
    String sql="update book set bookId="+p.getBookId()+", title='"+p.getTitle()+"',price="+p.getPrice()+" where id="+p.getBookId()+"";  
    return template.update(sql);  
}  
public int delete(int bookId){  
    String sql="delete from book where bookId="+bookId+"";  
    return template.update(sql);  
}  
public Book getBookById(int id){  
    String sql="select * from book where id=bookId";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Book>(Book.class));  
}  
public List<Book> getBooks(){  
    return template.query("select * from book",new RowMapper<Book>(){  
        public Book mapRow(ResultSet rs, int row) throws SQLException {  
        	Book e=new Book();  
            e.setBookId(rs.getInt(1));  
            e.setTitle(rs.getString(2));  
            e.setPrice(rs.getDouble(3));  
            e.setPublishDate(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  