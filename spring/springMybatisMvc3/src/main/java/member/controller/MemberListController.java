package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import data.dto.MemberDto;
import data.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberListController {
	@Autowired
	MemberService memberService;

	@GetMapping("/list")
	public String memberList(Model model) {
		List<MemberDto> list = memberService.getAllMembers();
		for (MemberDto dto : list) {
			if (dto.getMphoto() != null) {
				dto.setMphoto("https://s8iggryl8725.edge.naverncp.com/Jy5pSYRAWb/member/" + dto.getMphoto()
						+ "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
			}
		}
		model.addAttribute("list", list);
		return "member/memberlist";
	}

}
