package bit.day0417.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.day0417.data.MycarDto;
/*
1.객체지향적으로 데이터를 관리할 수 있기 때문에 비즈니스 로직에 집중 할 수 있으며, 객체지향 개발이 가능하다.
2.테이블 생성, 변경, 관리가 쉽다. (JPA를 잘 이해하고 있는 경우)
3.로직을 쿼리에 집중하기 보다는 객체자체에 집중 할 수 있다.
4.빠른 개발이 가능하다.
 */

//JpaRepository 가 가진 기본 CRUD 메서드를 상속받아 사용
public interface MycarRepository extends JpaRepository<MycarDto,Long>{

	//count() 가 전체 갯수를 구하는 메소드로 제공되지만 직접 구현하고 싶다면
	
	//@Query: repository에 원하는 쿼리를 작성하게 해주는 어노테이션
	//value 속성: 쿼리 작성부
	//nativeQuery: JPA에서 지정한 규칙을 모두 무시할 수 있는 속성
	
	@Query(value = "select count(*) from jpamycar",nativeQuery = true)
	public Long getTotalMycount();
	
	@Query(value = "select * from jpamycar where carname like concat('%',:search,'%')",nativeQuery = true)
	public List<MycarDto> getSearchList(@Param("search") String search);
	
	
	public List<MycarDto> findByCarnameContaining(String search);
	
}
