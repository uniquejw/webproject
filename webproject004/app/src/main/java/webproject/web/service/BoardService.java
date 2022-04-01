package webproject.web.service;

import java.util.List;

import webproject.web.domain.Board;

public interface BoardService {

  int add(Board board);

  List<Board> list();

  Board get(int no);

  int update(Board board);

  int delete(int no);
}
