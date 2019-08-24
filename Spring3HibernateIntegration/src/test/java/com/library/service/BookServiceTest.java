package com.library.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.library.dao.BookDAO;
import com.library.dao.BookDaoImpl;
import com.library.entity.Book;
import com.library.service.BookManagerImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/application-security.xml")
public class BookServiceTest {

	@Mock
	private  BookDaoImpl bookDaoImpl;
	
	@Mock
	BookDAO dao;
	
	@Mock
	private  BookManagerImpl bookManagerImpl;
	
	
	@Mock
	private  SessionFactory sessionFactory;
	
	@Mock
	private Session session;
	
	@Spy
	List<Book> books = new ArrayList<Book>();
	
	 @Captor
	  ArgumentCaptor<Book> captor;

	/**
	 * Initialize the application context to re-use in all test cases
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	//	sessionFactory = mock(SessionFactory.class);
	//	session = mock(Session.class);
	//	bookDaoImpl = new BookDaoImpl();
		// Removes NullPointerException - 'A'
	//	when(sessionFactory.getCurrentSession()).thenReturn(session);
		books = getAllBooks();
	//	doReturn(session).when(sessionFactory).getCurrentSession();
	}

	

	@Test(expected  = RuntimeException.class)
	public void saveTest() {

		Book book = new Book();
		book.setBookId(1223);
		book.setTitle("MYself");
		when(sessionFactory.getCurrentSession().save(book)).thenReturn(book.getBookId());
		bookDaoImpl.addBook(book);
		verify(sessionFactory, times(0)).getCurrentSession().save(book);
		//verify(sessionFactory.getCurrentSession()).save(book);
	}
	
	 @Test
	    public void findAllBooks() {
	        
	        when(dao.getAllBooks()).thenReturn(books);
	       // Assert.assertEquals(bookManagerImpl.getAllBooks(), books);
	      //  Assert.assertEquals(captor.getValue().getVolume(), "12");
	        assertNotNull(books);
	       // assertEquals(1, books.size());
	        Assert.assertEquals(1, books.size());
	    }
	 
	 public List<Book> getAllBooks() {
			Book book = new Book();
			book.setBookId(1223);
			book.setTitle("MYself");
			book.setVolume(12);
			book.setPublishDate("12/12/2029");
			book.setPrice(200.20);
			
			books.add(book);
			return books;
		}
}
