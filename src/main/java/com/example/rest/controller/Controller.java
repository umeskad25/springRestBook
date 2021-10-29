package com.example.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Book;
import com.example.rest.service.BookService;


@RestController
public class Controller {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/books")
	public ResponseEntity<List<Book>> getBooks() {
		System.out.println("in rest");
		List<Book> list = this.bookService.getAllBooks();	
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(list));            
		}
		
	}
	
	@GetMapping(value = "/book"
			+ "/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id) {
		System.out.println("in spwcific");
		Book book =  this.bookService.getBookByID(id);	
		if(book ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(book));            
		}
		
	}
	
	@PostMapping(value ="/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
	
		try {
//			Book bb= new Book();
//			bb.setAuthor("jj");
//			bb.setId(80);
//			bb.setName("um");
//			this.bookService.addBook(bb);
			
			Book b = this.bookService.addBook(book);
			
			
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	
	}
	
	
	@DeleteMapping(value ="/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") int bookId) {
		Book b;
		try{
		 b = this.bookService.deleteBook(bookId);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping(value ="/books/{id}")
	public Book updateBook(@PathVariable(value = "id") int bookId,@RequestBody Book book) {
		Book b = this.bookService.updateBook(bookId,book);
		return b;
	}
}
