package co.kyr.prj.todo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kyr.prj.todo.mapper.TodoMapper;
import co.kyr.prj.todo.service.TodoService;
import co.kyr.prj.todo.vo.TodoVO;

@Repository("todoDao")
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoMapper map;
	
	@Override
	public List<TodoVO> todoSelectList() {
		return map.todoSelectList();
	}

	@Override
	public int todoDelete(TodoVO vo) {
		return map.todoDelete(vo);
	}

	@Override
	public int todoUpdate(TodoVO vo) {
		return map.todoUpdate(vo);
	}

	@Override
	public int todoInsert(TodoVO vo) {
		return map.todoInsert(vo);
	}

}
