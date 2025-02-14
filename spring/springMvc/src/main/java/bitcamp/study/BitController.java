package bitcamp.study;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class BitController {
	
	//@RestController 는 json 출력시  @ResponseBody 안붙인다
	@GetMapping("/hello")
	public List<TestDto> list()
	{
		List<TestDto> list=new Vector<>();
		list.add(new TestDto("강호동", "서울", "010-222-4444"));
		list.add(new TestDto("이미자", "부산", "010-4545-6767"));
		list.add(new TestDto("손철수", "제주", "010-1212-3434"));
		return list;
	}
}
