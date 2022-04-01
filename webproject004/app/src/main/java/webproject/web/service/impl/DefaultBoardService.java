package webproject.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webproject.web.dao.BoardDao;
import webproject.web.domain.Board;
import webproject.web.service.BoardService;

@Service
public class DefaultBoardService implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Transactional
	public int add(Board Board) {
		return boardDao.insert(Board);
	}

	public List<Board> list() {
		return boardDao.findAll();
	}

	public Board get(int no) {
		Board board = boardDao.findByNo(no);
		if (board != null) {
			boardDao.increaseViewCount(no);
		}
		return board;
	}

	@Transactional
	public int update(Board Board) {
		return boardDao.update(Board);

	}

	@Transactional
	public int delete(int no) {
		return boardDao.delete(no);
	}
}
