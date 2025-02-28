package board.controller;

import java.util.List;
import java.util.Vector;

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
import data.dto.BoardFileDto;
import data.service.BoardFileService;
import data.service.BoardRepleService;
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
	final BoardRepleService repleService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	@GetMapping("/writeform")
	public String writeForm(
			//아래 5개의 값은 답글일때만 넘어온다, 새글일때는 null 값이 넘어오므로
			//required 를 false 로 주거나 defaultValue를 지정해야한다
			@RequestParam(defaultValue = "0") int idx,
			@RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") int pageNum,
			Model model			
			)
	{
		model.addAttribute("idx", idx);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNum", pageNum);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam List<MultipartFile> upload,
			HttpSession session
			)
	{
		//세션으로부터 아이디를 얻는다
		String myid=(String)session.getAttribute("loginid");
		//아이디를이용해서 멤버 테이블에서 작성자를 얻는다(아이디와 작성자는 dto 에 넣어야함)
		String writer=memberService.getSelectByMyid(myid).getMname();
		
		//dto 에 넣기
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		//게시판 내용을 일단 db 에 저장(그래야만 dto가 idx 를 얻어올수 있다)
		boardService.insertBoard(dto);
		
		//파일이 있는경우에만 해당,네이버 스토리지에 저장후 파일저장(이때 필요한게 idx,filename)
		//반복문 안에서 이루어져야만 한다
		if(!upload.get(0).getOriginalFilename().equals(""))
		{
			for(MultipartFile f:upload)
			{
				String filename=storageService.uploadFile(NcpObjectStorageService.getBucketname(), "board", f);
				BoardFileDto bdto=new BoardFileDto();
				bdto.setIdx(dto.getIdx());
				bdto.setFilename(filename);
				//boardfile 에 insert
				fileService.insertBoardFile(bdto);
			}
		}
		return "redirect:./list?pageNum="+pageNum;
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int idx,
			@RequestParam(defaultValue = "1") int pageNum,Model model)
	{
		//조회수 1 증가
		boardService.updateReadcount(idx);
		//idx 에 해당하는 dto 얻기
		BoardDto dto=boardService.getSelectByIdx(idx);
		
		//idx 글에 등록된 파일들 가져오기
		List<String> fileList=new Vector<>();
		List<BoardFileDto> flist=fileService.getFiles(idx);
		for(BoardFileDto fdto:flist)
		{
			fileList.add(fdto.getFilename());
		}
		
		dto.setPhotos(fileList);
		
		//해당 아이디에 대한 사진을 멤버테이블에서 얻기
		String memberPhoto=memberService.getSelectByMyid(dto.getMyid()).getMphoto();
		//모델에 저장
		model.addAttribute("repleCount", repleService.getRepleCountByIdx(idx));
		model.addAttribute("dto", dto);
		model.addAttribute("memberPhoto", memberPhoto);		
		model.addAttribute("pageNum", pageNum);		
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+NcpObjectStorageService.getBucketname());
		
		return "board/boarddetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(
			@RequestParam int idx, @RequestParam int pageNum,
			Model model
			)
	{
		BoardDto dto=boardService.getSelectByIdx(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+NcpObjectStorageService.getBucketname());
		
		return "board/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto dto, @RequestParam int pageNum) {
		// 게시판 내용을 일단 db 에 저장(그래야만 dto가 idx 를 얻어올수 있다)
		boardService.updateBoard(dto);

		return "redirect:./list?pageNum=" + pageNum;
	}
	
	//수정폼에서 기존 사진 목록 나타냄
	@GetMapping("/photolist")
	@ResponseBody
	public List<BoardFileDto> photoList(@RequestParam int idx)
	{
		List<BoardFileDto> list=fileService.getFiles(idx);
		return list;
	}
	
	//수정폼에서 각각의 사진 삭제시
	@GetMapping("/photodel")
	@ResponseBody
	public void deletePhoto(@RequestParam int num)
	{
		//스토리지에 있는 파일명 얻기
		String filename=fileService.getFilename(num);
		
		//스토리지에서 사진 삭제
		storageService.deleteFile(NcpObjectStorageService.getBucketname(), "board", filename);
		
		//사진 삭제
		fileService.deleteFile(num);
	}
}


















