package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.test.TestDto;

@Controller  //bean 객체를 자동등록,
//@RestController 로 할경우 무조건 json으로만 처리가능,포워드나 리다이렉트 안됨
//이경우 @ResponseBody  안붙여도 된다
public class HelloController {

	//@RequestMapping(value = "/",method = RequestMethod.GET) //스프링모든버전에서 가능
	//@RequestMapping("/")  //method 방식 생력시 기본이 Get
	@GetMapping("/hello2") //스프링5부터 가능
	@ResponseBody public TestDto hello() //json 형식으로 바로 브라우저에 출력
	{
		TestDto dto=new TestDto();
		dto.setName("이영자");
		dto.setAddr("강남구");
		dto.setHp("010-2222-3333");
		System.out.println(dto);//ToString 메서드 호출
		return dto;
	}
}
