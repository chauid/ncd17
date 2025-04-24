package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.react.data.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity,Integer> {

}
