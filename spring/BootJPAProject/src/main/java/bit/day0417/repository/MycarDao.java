package bit.day0417.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bit.day0417.data.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarDao {

	MycarRepository mycarRepository;
	
	public Long getTotalCount()
	{
		//return mycarRepository.count();//전체 갯수 반환-jpa에서 제공하는 메서드
		return mycarRepository.getTotalMycount();// 내가 직접 쿼리문으로 작성한 메서드,결과는 위와 같다
	}
	
	public void insertCar(MycarDto dto)
	{
		//save메서드는 기본 제공하는 메서드인데 추가와 수정을 모두 담당한다
		//num 값이 dto 에 포함되어있을경우 자동으로 수정이되고
		//없을경우 추가가된다
		mycarRepository.save(dto);
	}
	
	public List<MycarDto> getAllCarList()
	{
		return mycarRepository.findAll();//추가한 순서대로
		//return mycarRepository.findAll(Sort.by(Sort.Direction.DESC,"carprice"));//단가의 내림차순으로 정렬해서 출력
		//return mycarRepository.findAll(Sort.by(Sort.Direction.ASC,"carprice"));//단가의 오름차순으로 정렬해서 출력
		//return mycarRepository.findAll(Sort.by(Sort.Direction.ASC,"carguip"));//구입일의 오름차순으로 정렬해서 출력
	}
	
	//페이지에 필요한 만큼만 가져가는 메서드
	public Page<MycarDto> getAllPageCars(Pageable pageable)
	{
		return mycarRepository.findAll(pageable);//페이지에 필요한 만큼만 데이타 반환
	}
	
	public MycarDto getData(Long num)
	{
		return mycarRepository.getReferenceById(num);
	}
	
	public void updateCar(MycarDto dto)
	{
		mycarRepository.save(dto);//이번에는 num이 포함되어 있으므로 수정이 된다
	}
	
	public void deleteCar(Long num)
	{
		mycarRepository.deleteById(num);
	}
	
	//search
	public List<MycarDto> getSearchList(String search)
	{
		return mycarRepository.getSearchList(search);
	}

	public List<MycarDto> findByCarnameContaining(String search)
	{
		return mycarRepository.findByCarnameContaining(search);
	}
}



















