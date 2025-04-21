package bit.day0417.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.day0417.data.MycarCommentDto;
import bit.day0417.data.MycarDto;
import bit.day0417.service.MycarCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MyCarCommentController {
	final MycarCommentService commentService;
	@Operation(summary = "addcommnet",description = "댓글(닉네임,코멘트추가기능)")
	@PostMapping("/addcomment")
	public void addComment(@RequestParam("nickname") String nickname,@RequestParam("comment") String comment,
			@RequestParam("num") Long num)
	{
		//먼저 MyCarDto 에 num 값을 넣은후 MyCarCommentDto 에 넣는다(외부키로 지정된값)
		MycarDto mycar=MycarDto.builder().num(num).build();
		
		MycarCommentDto commentDto=MycarCommentDto.builder()
				.nickname(nickname)
				.comment(comment)
				.mycar(mycar)
				.build();

		//db insert
		commentService.insertComment(commentDto);
	}

//	@PostMapping("/addcomment")
//	public String addComment(@RequestBody MycarCommentDto dto)
//	{
//		System.out.println(dto);
//		MycarDto mycar=MycarDto.builder().num(dto.getNum()).build();
//
//		MycarCommentDto commentDto=MycarCommentDto.builder()				
//				.mycar(mycar)
//				.build();
//
//		//db insert
//		commentService.insertComment(commentDto);
//		return "comment insert ok";
//	}

	@Operation(summary = "commentlist",description = "댓글 목록 출력")
	@GetMapping("/commentlist")
	public List<MycarCommentDto> commentList(@RequestParam("num") long num)
	{
		return commentService.getCommentList(num);
	}

	@Operation(summary = "commentdelete",description = "댓글 삭제기능")
	@DeleteMapping("/commentdel")
	public String deleteComment(@RequestParam("idx") int idx)
	{
		commentService.deleteComment(idx);
		return "comment delete ok";
	}

}

/*
 * 확인 방법

http://localhost:8090/swagger-ui.html
또는
http://localhost:8090/swagger-ui/index.html
 */
















