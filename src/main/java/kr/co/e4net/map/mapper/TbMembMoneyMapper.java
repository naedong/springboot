package kr.co.e4net.map.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.dto.TbMembMoneyDto;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembMoneyEntity;
import kr.co.e4net.map.BaseMapper;

@Mapper(componentModel = "spring")
public interface TbMembMoneyMapper extends BaseMapper<TbMembMoneyDefault, TbMembMoneyEntity> {
	TbMembMoneyMapper INSTANCE = Mappers.getMapper(TbMembMoneyMapper.class);
	
}
