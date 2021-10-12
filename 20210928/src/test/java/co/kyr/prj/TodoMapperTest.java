package co.kyr.prj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kyr.prj.todo.mapper.TodoMapper;
import co.kyr.prj.todo.vo.TodoVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml")
public class TodoMapperTest {

	@Autowired TodoMapper mapper;
	
//	@Test
	public void todoSelectList() {
		System.out.println(mapper.todoSelectList());
	}
	
//	@Test
	public void todoDelete() {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		System.out.println(mapper.todoDelete(vo));
	}
	
//	@Test
	public void todoUpdate() {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		System.out.println(mapper.todoUpdate(vo));
	}
	
	@Test
	public void todoInsert() {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		System.out.println(mapper.todoInsert(vo));
		System.out.println(vo);
	}
	
}
