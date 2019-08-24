package com.library.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;

@Repository
public class BookDaoImpl implements BookDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void addBook(Book book) {
		this.sessionFactory.getCurrentSession().save(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
		String s = "from Book book";
		return this.sessionFactory.getCurrentSession().createQuery(s).list();
	}

	public void deleteBook(Integer bookId) {
		Book book = (Book) sessionFactory.getCurrentSession().load(
				Book.class, bookId);
        if (null != book) {
        	this.sessionFactory.getCurrentSession().delete(book);
        }
	}
	
	

}
