package board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardRepleDto;
import data.service.BoardRepleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardRepleController {
	final BoardRepleService repleService;
	final NcpObjectStorageService storageService;

	@PostMapping("/addreple")
	public void insertReple(@RequestParam int idx, @RequestParam String message, @RequestParam(required = false) MultipartFile photo,
			HttpSession session) {
		String myid = (String) session.getAttribute("loginid");
		if(myid == null) {
			return;
		}
		
		BoardRepleDto dto = new BoardRepleDto();
		dto.setMyid(myid);
		dto.setIdx(idx);
		dto.setMessage(message);
		if (photo == null) {
			dto.setPhoto(null);
		} else {
			String uploadFileName = storageService.uploadFile(NcpObjectStorageService.getBucketname(), "board/reple", photo);
			dto.setPhoto(uploadFileName);
		}
		repleService.insertReple(dto);
	}

	@GetMapping("/replelist")
	public List<BoardRepleDto> repleList(@RequestParam int idx) {
		List<BoardRepleDto> list = null;
		list = repleService.getReplesByIdx(idx);
		return list;
	}

	@PutMapping("/updatereple")
	public void updateReple(@RequestParam int num, @RequestParam String message, @RequestParam(required = false) MultipartFile photo,
			HttpSession session) {
		String myid = (String) session.getAttribute("loginid");
		BoardRepleDto originReple = repleService.getRepleByNum(num);
		String oldFilename = originReple.getPhoto();
		BoardRepleDto dto = new BoardRepleDto();

		if (!myid.equals(originReple.getMyid())) {
			return;
		}
		
		if (photo == null) {
			dto.setPhoto(originReple.getPhoto());
		} else {
			storageService.deleteFile(NcpObjectStorageService.getBucketname(), "board/reple", oldFilename);
			String uploadFileName = storageService.uploadFile(NcpObjectStorageService.getBucketname(), "board/reple", photo);
			dto.setPhoto(uploadFileName);
		}

		dto.setNum(num);
		dto.setMessage(message);
		repleService.updateReple(dto);
	}

	@DeleteMapping("/deletereple")
	public void deleteReple(@RequestParam int num, HttpSession session) {
		String myid = (String) session.getAttribute("loginid");
		BoardRepleDto originReple = repleService.getRepleByNum(num);
		String oldFilename = originReple.getPhoto();
		
		if (!myid.equals(originReple.getMyid())) {
			return;
		}
		
		storageService.deleteFile(NcpObjectStorageService.getBucketname(), "board/reple", oldFilename);
		repleService.deleteReple(num);
	}
}
