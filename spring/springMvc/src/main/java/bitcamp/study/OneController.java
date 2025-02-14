package bitcamp.study;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@AllArgsConstructor  //모든 멤버변수 자동주입 //방법2
public class OneController {
	
	//같은 타입의 빈을 찾아서 자동으로 주입한다(DI)
	//@Autowired  //방법1
	Mycar mycar;
	
	@GetMapping("/")
	public ModelAndView show()
	{
		ModelAndView mview=new ModelAndView();
		//Model 에 데이타를 저장(서블릿에서 request 에 저장하는것과 같음)
		mview.addObject("today", new Date());
		mview.addObject("message","오늘은 즐거운 금요일!!!");
		//포워드
		mview.setViewName("result1");//properties 에서 설정한 뷰리졸버에 의해서 포워드
		return mview;
	}
	
	//매핑주소가 두가지 이상일경우 {} 안에 넣어준다
	@GetMapping({"/board/list","/board/list.do"})
	public String list1(Model model)
	{		
		model.addAttribute("writer", "한가람");
		return "boardlist";
	}
	
	@GetMapping("/shop/list")
	public String list2(Model model)
	{
		model.addAttribute("sangpum", "사과");
		model.addAttribute("price", "3000");
		
		return "shoplist";
	}
	
	@GetMapping({"/bitcamp/study","/bitcamp/study2"})
	public String list3(Model model)
	{
		model.addAttribute("mycar", mycar.getMycarName());
		model.addAttribute("mycarColor", mycar.getMycarColor());
		return "study";
	}
}




















