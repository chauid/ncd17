package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.react.data.BoardEntity;
import jakarta.transaction.Transactional;

public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{

	@Query(value = """
			update jpaboard set readcount=readcount+1 where num=:num
			""",nativeQuery = true)
    @Modifying
    @Transactional
	public void updateReadCount(@Param("num") int num);
}
