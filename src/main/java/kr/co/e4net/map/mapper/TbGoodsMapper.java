package kr.co.e4net.map.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.co.e4net.dto.TbGoodsDto;
import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;


import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbGoodsEntity.TbGoodsEntityBuilder;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.map.BaseMapper;

@Mapper(componentModel = "spring")
public interface TbGoodsMapper extends BaseMapper<TbMerchantDefault, TbGoodsEntity> {
	TbGoodsMapper INSTANCE = Mappers.getMapper(TbGoodsMapper.class);
	
	
		default TbGoodsEntity toEntity(TbMerchantDefault tbMerchantDefault, TbMerchantEntity tbMerchantEntities) {
				
				if(tbMerchantDefault == null) {
					return null;
				}
				
						TbGoodsEntityBuilder tbGoodsEntity = TbGoodsEntity.builder();
						tbGoodsEntity.goodsClsDt(tbMerchantDefault.getGoodsClsDt());
						tbGoodsEntity.goodsDesc(tbMerchantDefault.getGoodsDesc());
						tbGoodsEntity.goodsImgPath(tbMerchantDefault.getGoodsImgPath());
						tbGoodsEntity.goodsModelNo(tbMerchantDefault.getGoodsModelNo());
						tbGoodsEntity.goodsNm(tbMerchantDefault.getGoodsNm());
						tbGoodsEntity.goodsQtt(tbMerchantDefault.getGoodsQtt());
						tbGoodsEntity.goodsSellQtt(tbMerchantDefault.getGoodsSellQtt());
						tbGoodsEntity.goodsShopCost(tbMerchantDefault.getGoodsShopCost());
						tbGoodsEntity.goodsAmt(tbMerchantDefault.getGoodsAmt());
						tbGoodsEntity.realFileNm(tbMerchantDefault.getRealFileNm());
						tbGoodsEntity.tbMerchantEntity(tbMerchantEntities);				
						return tbGoodsEntity.build();
				
			}

}
