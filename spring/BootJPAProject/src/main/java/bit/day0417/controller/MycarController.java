package bit.day0417.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bit.day0417.data.MycarDto;
import bit.day0417.service.MycarService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MycarController {
	
	final MycarService mycarService;

	@GetMapping("/")
	public String home()
	{
		return "redirect:/carlist";
	}
	
	@GetMapping("/addform")
	public String addForm()
	{
		return "mycar/addform";
	}
	
	@PostMapping("/insert")
	public String insertCar(@ModelAttribute MycarDto dto)
	{
		//db 저장
		mycarService.insertCar(dto);
		
		//목록으로 이동
		return "redirect:./carlist";
	}
	
	@GetMapping("/carlist")
	public String list(Model model)
	{
		//총 갯수 구하기
		Long totalCount=mycarService.getTotalCount();
		
		//전체 목록 가져오기
		List<MycarDto> list=mycarService.getAllCarList();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "mycar/carlist";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("num") Long num,Model model)
	{
		System.out.println("num="+num);
		MycarDto dto=mycarService.getData(num);
		model.addAttribute("dto", dto);
		return "mycar/detail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(@RequestParam("num") Long num,Model model)
	{
		MycarDto dto=mycarService.getData(num);
		model.addAttribute("dto", dto);
		return "mycar/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MycarDto dto)
	{
		mycarService.updateCar(dto);
		return "redirect:./detail?num="+dto.getNum();
	}
	
	@GetMapping("/delete")
	public String deleteCar(@RequestParam("num") Long num)
	{
		mycarService.deleteCar(num);
		
		return "redirect:./carlist";
	}
}























