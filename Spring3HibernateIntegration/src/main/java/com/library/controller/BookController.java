package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.entity.Book;
import com.library.service.BookManager;

@Controller
public class BookController {

	@Autowired
	private BookManager bookManager;
	
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listBooks(ModelMap map) {
		
		map.addAttribute("book", new Book());
		map.addAttribute("bookList", bookManager.getAllBooks());

		return "editBookList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(
			@ModelAttribute(value = "book") Book book,
			BindingResult result) {
		bookManager.addBook(book);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		bookManager.deleteBook(bookId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
