package webproject.web.service;

import java.util.List;

import webproject.web.domain.Book;

public interface BookService {

  int add(Book book);

  List<Book> list();

  Book get(int no);

  int update(Book book);

  int delete(int no);
}
