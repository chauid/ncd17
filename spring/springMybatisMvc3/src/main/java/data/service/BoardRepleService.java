package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardRepleDto;
import data.mapper.BoardRepleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardRepleService {
	final BoardRepleMapper repleMapper;

	public void insertReple(BoardRepleDto dto) {
		repleMapper.insertReple(dto);
	}

	public int getRepleCountByIdx(int idx) {
		return repleMapper.getRepleCountByIdx(idx);
	}

	public BoardRepleDto getRepleByNum(int num) {
		return repleMapper.getRepleByNum(num);
	}

	public List<BoardRepleDto> getReplesByIdx(int idx) {
		return repleMapper.getReplesByIdx(idx);
	}

	public void updateReple(BoardRepleDto dto) {
		repleMapper.updateReple(dto);
	}

	public void deleteReple(int num) {
		repleMapper.deleteReple(num);
	}
}
