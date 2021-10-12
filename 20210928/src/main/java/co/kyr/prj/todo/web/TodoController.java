package co.kyr.prj.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.kyr.prj.todo.service.TodoService;
import co.kyr.prj.todo.vo.TodoVO;

@RestController
public class TodoController {
	@Autowired
	TodoService todoDao;
	
// 전체조회
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public List<TodoVO> todoSelectList(TodoVO vo, Model model){
		return todoDao.todoSelectList();
	}
	
// 등록
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public TodoVO todoInsert(@RequestBody TodoVO vo, Model model) {
		todoDao.todoInsert(vo);
		return vo;
	}
	
// 삭제
	@RequestMapping(value="/todo/{no}", method=RequestMethod.DELETE)
	public TodoVO todoDelete(@PathVariable int no, TodoVO vo, Model model) {
		vo.setNo(no);
		todoDao.todoDelete(vo);
		return vo;
	}
	
}
