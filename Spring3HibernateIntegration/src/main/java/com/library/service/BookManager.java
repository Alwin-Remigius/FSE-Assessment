package com.library.service;

import java.util.List;

import com.library.entity.Book;


public interface BookManager {
	public void addBook(Book book);
    public List<Book> getAllBooks();
    public void deleteBook(Integer bookId);
}
