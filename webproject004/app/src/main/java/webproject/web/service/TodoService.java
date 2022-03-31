package webproject.web.service;

import java.util.List;

import webproject.web.domain.Todo;

public interface TodoService {

	int add(Todo todo);

	List<Todo> list();

	Todo get(int no);

	int update(Todo todo);
	
	int updateStatus(Todo todo);

	int delete(int no);
}
