package com.haky.service;

import com.haky.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface BookService {

    List<Book> getBookList();
}
