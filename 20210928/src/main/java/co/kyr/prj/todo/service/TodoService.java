package co.kyr.prj.todo.service;

import java.util.List;

import co.kyr.prj.todo.vo.TodoVO;

public interface TodoService {
	public List<TodoVO> todoSelectList();
	public int todoDelete(TodoVO vo);
	public int todoUpdate(TodoVO vo);
	public int todoInsert(TodoVO vo);
}
