package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.MemberDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberDelUpdateController {
	final MemberService memberService;
	final BoardService boardService;
	final BoardFileService boardFileService;

	// 버킷 이름
	private static final String bucketName = "bitcamp-bucket-springmvc3";

	@Autowired
	NcpObjectStorageService storageService;

	@GetMapping("/delete")
	public String deleteMember(@RequestParam int num) {
		memberService.deleteMember(num);
		return "redirect:./list";
	}

	@GetMapping("/mypagedel") // 마이페이지를 통한 본인탈퇴
	@ResponseBody
	public void mypageDelete(@RequestParam int num, HttpSession session) {
		memberService.deleteMember(num);

		// 모든 세션 제거
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		session.removeAttribute("loginphoto");
	}

	@GetMapping("/checkdel")
	@ResponseBody
	public void checkDeleteMember(@RequestParam String nums) {
		// 삭제할 num 들
		String[] num = nums.split(",");
		for (String str : num) {
			int n = Integer.parseInt(str);
			memberService.deleteMember(n);
		}
	}

	@GetMapping("/mypage")
	public String goMypage(HttpSession session, Model model) {
		// 세션으로부터 아이디를 얻는다
		String myid = (String) session.getAttribute("loginid");
		// 아이디에 해당하는 dto 얻기
		MemberDto dto = memberService.getSelectByMyid(myid);
		if (dto != null) {
			dto.setMphoto("https://kr.object.ncloudstorage.com/bitcamp-bucket-springmvc3/member/" + dto.getMphoto());
			
		}
		List<BoardDto> list = boardService.getSelectById(myid);
		
		// 모델에 dto저장
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		
		return "member/mypage";
	}

	@PostMapping("/changephoto")
	@ResponseBody
	public void changePhoto(HttpServletRequest request, @RequestParam("upload") MultipartFile upload,
			@RequestParam("num") int num, HttpSession session) {
		// save 경로
//		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//		// 기존 파일명 얻기
//		String oldFilename = memberService.getSelectByNum(num).getMphoto();
//		// 기존 파일 삭제
//		File oldFile = new File(uploadFolder + "/" + oldFilename);
//		if (oldFile.exists())
//			oldFile.delete();
//		// upload 할 파일명
//		String uploadFilename = UUID.randomUUID() + "." + upload.getOriginalFilename().split("\\.")[1];
//		// 업로드
//		try {
//			upload.transferTo(new File(uploadFolder + "/" + uploadFilename));
//			// session 도 변경
//			session.setAttribute("loginphoto", uploadFilename);
//
//			// db 도 사진변경
//			memberService.changePhoto(uploadFilename, num);
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String oldFileName = memberService.getSelectByNum(num).getMphoto();
		storageService.deleteFile(bucketName, "member", oldFileName);

		String uploadFileName = storageService.uploadFile(bucketName, "member", upload);
		memberService.changePhoto(uploadFileName, num);
		session.setAttribute("loginphoto", uploadFileName);
	}

	@PostMapping("/update")
	@ResponseBody
	public void updateMember(@ModelAttribute MemberDto dto) {
		System.out.println(dto.getNum());
		memberService.updateMember(dto);
	}

}
