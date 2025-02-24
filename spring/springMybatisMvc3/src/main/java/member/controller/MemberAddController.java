package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberAddController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/form")
	public String form()
	{
		return "member/memberform";
	}
	
	//아이디가 존재하면 result 에 fail 를 ,존재하지 않으면 success 를 보내기
	@GetMapping("/idcheck")
	@ResponseBody
	public Map<String, String> idCheck(@RequestParam String myid)
	{
		Map<String, String> map=new HashMap<>();
		if(memberService.isMyidCheck(myid))
			map.put("result", "fail");
		else
			map.put("result", "success");
		return map;
	}
	
	@PostMapping("/insert")
	public String insert(
			HttpServletRequest request,
			@ModelAttribute MemberDto dto,
			@RequestParam("upload") MultipartFile upload
			)
	{
		//사진선택을 안했을경우 upload 의 파일명을 확인후
		//사진선택을 안했다면 upload하지말고 mphoto 에 "no" 저장
		System.out.println("filename:"+upload.getOriginalFilename());
		
		if(upload.getOriginalFilename().equals("")) {
			dto.setMphoto("no");
		}else {
			//업로드할 폴더명
			String uploadFolder=request.getSession().getServletContext().getRealPath("save");
			//업로드할 파일명
			String uploadFilename=UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
			//업로드
			try {
				upload.transferTo(new File(uploadFolder+"/"+uploadFilename));
				dto.setMphoto(uploadFilename);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		memberService.insertMember(dto);
		
		return "redirect:../";//일단은 홈으로 이동
	}
}






























