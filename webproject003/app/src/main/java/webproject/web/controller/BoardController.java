package webproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webproject.web.domain.Board;
import webproject.web.service.BoardService;

@RestController 
public class BoardController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 BoardController 객체를 만들 때 BoardDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    return boardService.list();
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    return boardService.add(board);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return "";
    }
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    return boardService.update(board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int no) {
    return boardService.delete(no);
  }
}




