package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.dao.BookRepository;
import com.example.rest.entity.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	
	public List<Book> getAllBooks(){
		System.out.println("in book");
		List<Book> bookList = (List<Book>) this.bookRepository.findAll();
		System.out.println("book out");
		return bookList;
	}
	
	public Book getBookByID(int id) {
		Book book=null;
		try {
		book = this.bookRepository.findById(id);
			//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		System.out.println("before repo");
	
		this.bookRepository.save(book);
		
		return this.getBookByID(book.getId());
		
	}
	
	public Book deleteBook(int bookId) {
		
		Book book =null;
		book = this.getBookByID(bookId);
		 this.bookRepository.deleteById(bookId);
		
		
		return book;	
	}
	
public Book updateBook(int bookId,Book book) {
		
	Book b = this.getBookByID(bookId);
	b.setAuthor(book.getAuthor());
	b.setId(book.getId());
	b.setName(book.getName());
	this.deleteBook(bookId);
	this.addBook(b);
	
		return this.getBookByID(bookId);	
	}
	
}
