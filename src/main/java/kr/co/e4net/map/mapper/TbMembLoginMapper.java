package kr.co.e4net.map.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.co.e4net.dto.TbMembDto;
import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.dto.TbMembDto.TbMembLogin.TbMembLoginBuilder;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity.TbMembLoginHstEntityBuilder;
import kr.co.e4net.map.BaseMapper;



@Mapper(componentModel = "spring")
public interface TbMembLoginMapper extends BaseMapper<TbMembLogin, TbMembLoginHstEntity> {
	TbMembLoginMapper INSTANCE = Mappers.getMapper(TbMembLoginMapper.class);
	
		
		default TbMembLoginHstEntity toEntity(TbMembLogin tbMembLogin, TbMembEntity tbMembEntity) {
			
			if(tbMembLogin == null) {
				return null;
			}
			TbMembLoginHstEntityBuilder tbMembLoginEntity = TbMembLoginHstEntity.builder();
			tbMembLoginEntity.connectIp(tbMembLogin.getConnectIp());
			tbMembLoginEntity.tbMembEntities(tbMembEntity);
			return tbMembLoginEntity.build();
		}
		default TbMembLogin toDto(TbMembLoginHstEntity e) {
			if(e == null) {
				return null;
			}
			TbMembLoginBuilder tbMembDto = TbMembLogin.builder();
			tbMembDto.membId(e.getTbMembEntity().getMembId());
			tbMembDto.membPwd(e.getTbMembEntity().getMembPwd());
			tbMembDto.membSn(e.getTbMembEntity().getMembSn());
			return tbMembDto.build();
		}
	
}
