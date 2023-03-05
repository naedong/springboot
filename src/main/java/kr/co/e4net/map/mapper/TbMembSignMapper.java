package kr.co.e4net.map.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.enums.MembCls;
import kr.co.e4net.enums.MembStatusCd;
import kr.co.e4net.map.BaseMapper;

@Mapper(componentModel = "spring")
@Qualifier("TbMembSignMapper")
public interface TbMembSignMapper extends BaseMapper<TbMembSign, TbMembEntity>{
	TbMembSignMapper INSTANCE = Mappers.getMapper(TbMembSignMapper.class);
	
	TbMembSign toDto(TbMembEntity tbMembEntity);
	
	@Mapping(source = "lastLoginDtm", target = "lastLoginDtm")
	TbMembEntity toEntity(TbMembSign tbMembSign);
	
//	List<TbMembSign> toDto(List<TbMembEntity> tbMembEntity);
	
	
	TbMembSign map(TbMembEntity tbMembEntity);
	
	default MembCls map(String legacyCodeName) {
		return MembCls.toSting(legacyCodeName);
	}
	
	default String map(MembCls membCls) {
		return membCls.getLegacyCodeName();
	}
	

	
	default MembStatusCd hashmap(Integer value) {
		return MembStatusCd.valueOf(value);
	}
	
	default Integer hashmap(MembStatusCd membStatusCd) {
		return membStatusCd.getValue();
	}
	
}
