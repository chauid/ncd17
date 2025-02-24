package data.service;

import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	MemberMapper memberMapper;

	public boolean isMyidCheck(String myid) {
		return memberMapper.checkMyid(myid) == 1 ? true : false;
	}

	public void insertMember(MemberDto dto) {
		memberMapper.insertMember(dto);
	}
}
