package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.react.data.ShopEntity;
import jakarta.transaction.Transactional;

public interface ShopRepository extends JpaRepository<ShopEntity,Integer> {
	
	@Query(value="""
			update jpashop set sangpum=:#{#entity.sangpum},price=:#{#entity.price},
			color=:#{#entity.color},sangguip=:#{#entity.sangguip}
			where num=:#{#entity.num}
			""",nativeQuery=true)
    @Modifying //@Modifying은 insert, update, delete 뿐만 아니라 DDL구문을 사용할 때도 표기를 해줘야 됩니다.
    @Transactional //@Transactional은 update, delete를 할 때 표기를 해줘야 정상 실행이 됩니다.
	public void updateShopNoPhoto(@Param("entity") ShopEntity entity);

}
