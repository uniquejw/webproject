package webproject.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webproject.web.dao.TodoDao;
import webproject.web.domain.Todo;
import webproject.web.service.TodoService;

@Service
public class DefaultTodoService implements TodoService {

	@Autowired
	TodoDao todoDao;

	@Override
	@Transactional
	public int add(Todo todo) {
		return todoDao.insert(todo);
	}

	public List<Todo> list() {
		return todoDao.findAll();
	}

	@Override
	public Todo get(int no) {
		return todoDao.findByNo(no);
	}

	@Override
	@Transactional
	public int update(Todo todo) {
		return todoDao.update(todo);

	}

	@Override
	@Transactional
	public int delete(int no) {
		return todoDao.delete(no);
	}

	@Override
	public int updateStatus(Todo todo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
