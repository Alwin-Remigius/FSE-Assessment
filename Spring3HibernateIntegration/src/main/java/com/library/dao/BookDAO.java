package com.library.dao;

import java.util.List;

import com.library.entity.Book;

public interface BookDAO 
{
    public void addBook(Book book);
    public List<Book> getAllBooks();
    public void deleteBook(Integer bookId);
}