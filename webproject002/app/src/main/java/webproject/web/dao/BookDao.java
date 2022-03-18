package webproject.web.dao;

import java.util.List;

import webproject.web.domain.Book;

public interface BookDao {

  int countAll();

  List<Book> findAll();

  void insert(Book book);
  
  Book findByNo(int no);

  int update(Book book);
  
  int delete(int no);
}











