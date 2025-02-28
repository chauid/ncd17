package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.BoardRepleDto;

@Mapper
public interface BoardRepleMapper {
	public void insertReple(BoardRepleDto dto);
	public int getRepleCountByIdx(int idx);
	public BoardRepleDto getRepleByNum(int num);
	public List<BoardRepleDto> getReplesByIdx(int idx);
	public void updateReple(BoardRepleDto dto);
	public void deleteReple(int num);
}
