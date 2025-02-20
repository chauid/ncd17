package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;
import data.service.ShopService;

@Controller
public class ShopDetailDeleteController {
	@Autowired
	ShopService shopService;
	
	@GetMapping("/shop/detail")
	public String detail(@RequestParam int num,Model model)
	{
		ShopDto dto=shopService.getSelectOne(num);
		String mainPhoto=dto.getSphoto().split(",")[0];
		dto.setMainPhoto(mainPhoto);
		
		model.addAttribute("dto", dto);
		return "/shop/detail";
	}
}
