package bit.day0417.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.day0417.data.MycarCommentDto;

public interface MycarCommentRepository extends JpaRepository<MycarCommentDto, Integer>{
    //num 에 대한 댓글 여러개를 반환받는 메서드를 쿼리문을 이용해서 직접 만들어보자	
	@Query(value = "select * from jpamycar_comment where num=:num order by idx desc",nativeQuery = true)
	public List<MycarCommentDto> getMycarCommentList(@Param("num") Long num);
}
