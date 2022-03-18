package webproject.web.dao;

import java.util.List;

import webproject.web.domain.Board;

public interface BoardDao {

  int countAll();

  List<Board> findAll();

  int insert(Board board);

  Board findByNo(int no);

  int update(Board board);

  int delete(int no);

  int increaseViewCount(int no);
}











