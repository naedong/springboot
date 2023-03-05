package kr.co.e4net.map.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.entity.TbMerchantEntity.TbMerchantEntityBuilder;
import kr.co.e4net.entity.TbMoneyTransferHstEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity.TbMoneyTransferHstEntityBuilder;
import kr.co.e4net.enums.PayMeanCd;
import kr.co.e4net.enums.TransferTyCd;
import kr.co.e4net.map.BaseMapper;

@Mapper(componentModel = "spring")
public interface TbMerchantListMapper extends BaseMapper<TbMerchantDefault, TbMerchantEntity> {
	TbMerchantListMapper INSTANCE = Mappers.getMapper(TbMerchantListMapper.class);
	
	default TbMerchantEntity toEntity(TbMerchantDefault tbMerchantDefault, TbMembEntity tbMembEntity) {
		
		if(tbMerchantDefault == null) {
			return null;
		}
		TbMerchantEntityBuilder tbMerchantEntity = TbMerchantEntity.builder();
		 tbMerchantEntity
				.merchantDesc(tbMerchantDefault.getMerchantDesc()).
				merchantNm(tbMerchantDefault.getMerchantNm()).
				merchantSn(tbMembEntity.getMembSn()).
				merchantUrl(tbMerchantDefault.getMerchantUrl()).
				tbMembEntity(tbMembEntity).
				publicData(tbMembEntity.getPublicData()).
				telNo(tbMerchantDefault.getTelNo()).
				build();
		
		return tbMerchantEntity.build();
	}
	default List<TbMerchantEntity> ListToEntity(List<TbMerchantDefault> tbMerchantDefault, TbMembEntity tbMembEntity) {
		
		if(tbMerchantDefault == null) {
			return null;
		}
		else {
			List<TbMerchantEntity> tbMerchantEntities = new ArrayList<>();
		for(TbMerchantDefault e : tbMerchantDefault) {
			
			TbMerchantEntity tbMerchantEntity = TbMerchantEntity.builder()
					.merchantDesc(e.getMerchantDesc()).
					merchantNm(e.getMerchantNm()).
					merchantUrl(e.getMerchantUrl()).
					tbMembEntity(tbMembEntity).
					publicData(e.getPublicData()).
					telNo(e.getTelNo()).
					build();
			 	tbMerchantEntities.add(tbMerchantEntity);
		}
			return tbMerchantEntities;
		}
		
	}
	
	
}
