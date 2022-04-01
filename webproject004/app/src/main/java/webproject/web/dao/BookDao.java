package webproject.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webproject.web.domain.Book;

@Mapper
public interface BookDao {

  int countAll();

  List<Book> findAll();

  int insert(Book book);
  
  Book findByNo(int no);

  int update(Book book);
  
  int delete(int no);
}











