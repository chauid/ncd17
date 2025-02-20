package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ShopDto;

@Mapper
public interface ShopMapper {
	public int getTotalCount();
	public void insertShop(ShopDto dto);
	public List<ShopDto> getAllSangpum();
	public ShopDto getSelectOne(int num);
}
