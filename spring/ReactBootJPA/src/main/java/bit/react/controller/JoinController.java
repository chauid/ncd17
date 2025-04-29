package bit.react.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bit.react.data.JoinDto;
import bit.react.repository.JoinService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JoinController {
	private final JoinService joinService;
	
	@PostMapping("/join")
	public String joinProcess(@RequestBody JoinDto dto)
	{
		joinService.joinProcess(dto);
		return "join ok!!";
	}
}
