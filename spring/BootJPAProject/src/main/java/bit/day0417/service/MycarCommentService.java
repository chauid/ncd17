package bit.day0417.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.day0417.data.MycarCommentDto;
import bit.day0417.repository.MycarCommentDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MycarCommentService {
	MycarCommentDao commentDao;
	
	public void insertComment(MycarCommentDto dto)
	{
		commentDao.insertComment(dto);
	}
	
	public void deleteComment(int idx)
	{
		commentDao.deleteComment(idx);
	}
	
	public List<MycarCommentDto> getCommentList(Long num)
	{
		return commentDao.getCommentList(num);
	}
}
