package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.BookDAO;
import com.library.entity.Book;

@Service
public class BookManagerImpl implements BookManager {
	
	@Autowired
    private BookDAO bookDAO;

	@Transactional
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Transactional
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	@Transactional
	public void deleteBook(Integer bookId) {
		bookDAO.deleteBook(bookId);
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
}
