package co.kyr.prj.user.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.kyr.prj.user.service.UserService;
import co.kyr.prj.user.vo.UserVO;

@RestController
public class RestfulUserController {
	@Autowired
	UserService userService;
	
	//전체조회
//	@ResponseBody 자바객체를 json구조의 스트링으로 변환시켜줌(@restcontroller 사용하면 responseBody사용 안해도됨) 
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<UserVO> getUserList(Model model, UserVO vo) {
		return  userService.getUserList(vo);
	}
	
	//단건조회
	@RequestMapping(value="/users/{id}",  method=RequestMethod.GET)
	public UserVO getUser(@PathVariable String id, UserVO vo, Model model) {
		vo.setId(id);
		return  userService.getUser(vo);
	}
	
	//삭제
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public Map  getUserList( @PathVariable String id, UserVO vo, Model model) {
		vo.setId(id);
		userService.deleteUser(vo);
		Map result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
	//등록
	@RequestMapping(value="/users"
			,method=RequestMethod.POST
	// 		,consumes="application/json"
    //      ,headers = {"Content-type=application/json" }
	)
	//@requestBody 는 넘어오는 parameter가 json구조라는 뜻.
	//원래는  ?id=aaaa&password=111 이런식으로 넘어오는데 
	//@requestBody 사용하면 parameter가 "{id:aaaa,password:111}"로 받아짐
	public Map insertUser(@RequestBody UserVO vo, Model model) {
		userService.insertUser(vo);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("result", "success");
		map.put("user", vo);	
		return map;
		
		//return  Collections.singletonMap("result", true);
	}
	
	//수정
	@RequestMapping(value="/users"
			,method=RequestMethod.PUT // put의 경우 @requestBody가 있어야됨(json방식으로 넘어오기 때문)
	//		,produces="application/json"      //응답헤더
	 		,consumes="application/json"      //요청헤더
     //       ,headers = {"Content-type=application/json" }
	)
	public UserVO updateUser(@RequestBody UserVO vo, Model model) {
		userService.updateUser(vo);
		return  vo;
	}	
	
	@RequestMapping(value="/respAPI")
	public Map respAPI() {
		RestTemplate rest = new RestTemplate();
		return rest.getForObject("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101", Map.class);
	}
	
}
