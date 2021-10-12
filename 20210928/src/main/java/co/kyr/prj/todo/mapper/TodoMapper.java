package co.kyr.prj.todo.mapper;

import java.util.List;

import co.kyr.prj.todo.vo.TodoVO;

public interface TodoMapper {
	public List<TodoVO> todoSelectList();
	public int todoDelete(TodoVO vo);
	public int todoUpdate(TodoVO vo);
	public int todoInsert(TodoVO vo);
}
