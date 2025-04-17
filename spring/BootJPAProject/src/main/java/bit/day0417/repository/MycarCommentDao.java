package bit.day0417.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import bit.day0417.data.MycarCommentDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarCommentDao {
	MycarCommentRepository commentRepository;
	
	public void insertComment(MycarCommentDto dto)
	{
		commentRepository.save(dto);
	}
	
	public void deleteComment(int idx)
	{
		commentRepository.deleteById(idx);
	}
	
	public List<MycarCommentDto> getCommentList(Long num)
	{
		return commentRepository.getMycarCommentList(num);
	}
}
