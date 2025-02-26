package board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;

	@GetMapping("/writeform")
	public String writeForm(
			// 아래 5개의 값은 답글일때만 넘어온다, 새글일때는 null 값이 넘어오므로
			// required 를 false 로 주거나 defaultValue를 지정해야한다
			@RequestParam(value = "idx", defaultValue = "0") int idx,
			@RequestParam(value = "regroup", defaultValue = "0") int regroup,
			@RequestParam(value = "restep", defaultValue = "0") int restep,
			@RequestParam(value = "relevel", defaultValue = "0") int relevel,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {
		model.addAttribute("idx", idx);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNum", pageNum);

		return "board/writeform";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto, @RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload, HttpSession session) {

		// 세션으로부터 아이디를 얻는다
		String loginId = (String) session.getAttribute("loginid");

		// 아이디를이용해서 멤버 테이블에서 작성자를 얻는다
		String writer = memberService.getSelectByMyid(loginId).getMname();
		dto.setWriter(writer);

		// 게시판 내용을 일단 db 에 저장(그래야만 dto가 idx 를 얻어올수 있다)
		boardService.insertBoard(dto);
		
		
		// 파일이 있는경우에만 해당,네이버 스토리지에 저장후 파일저장(이때 필요한게 idx,filename)
		// 반복문 안에서 이루어져야만 한다
		for (MultipartFile file : upload) {
			fileService.insertBoardFile(null)
		}

		return "redirect:./list?pageNum=" + pageNum;
	}

	@GetMapping("/detail")
	public String detail() {
		return "board/boarddetail";
	}
}
