package webproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webproject.web.dao.BookDao;
import webproject.web.domain.Book;

@RestController
public class BookController {

	@Autowired
	BookDao bookDao;

	@RequestMapping("/book/list")
	public Object list() {
		return bookDao.findAll();
	}

	@RequestMapping("/book/add")
	public Object add(Book book) throws Exception {
		bookDao.insert(book);
		return bookDao.countAll();
	}

	@RequestMapping("/book/get")
	public Object get(int no) {
		Book book = bookDao.findByNo(no);
		return book != null ? book : "";
	}

	@RequestMapping("/book/update")
	public Object update(Book book) throws Exception {
		return bookDao.update(book);
	}

	@RequestMapping("/book/delete")
	public Object delete(int no) throws Exception {
		return bookDao.delete(no);
	}
}
