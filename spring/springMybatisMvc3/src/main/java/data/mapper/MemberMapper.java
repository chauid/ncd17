package data.mapper;

import org.apache.ibatis.annotations.Mapper;

import data.dto.MemberDto;

@Mapper
public interface MemberMapper {
	public int checkMyid(String myid);
	public void insertMember(MemberDto dto);
}
