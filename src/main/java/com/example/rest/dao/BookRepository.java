package com.example.rest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.rest.entity.Book;

public interface BookRepository  extends CrudRepository<Book, Integer> {

public Book findById(int id);
}
