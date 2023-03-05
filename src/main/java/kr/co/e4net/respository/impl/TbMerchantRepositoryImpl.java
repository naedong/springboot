package kr.co.e4net.respository.impl;

import static kr.co.e4net.entity.QTbMembEntity.tbMembEntity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;

import kr.co.e4net.config.Querydslconfig;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.map.mapper.TbMembSignMapper;
import static kr.co.e4net.entity.QTbMerchantEntity.tbMerchantEntity;
import static kr.co.e4net.entity.QTbGoodsEntity.tbGoodsEntity;
import org.jetbrains.annotations.Nullable;

import static kr.co.e4net.entity.QTbMembEntity.tbMembEntity;
import kr.co.e4net.respository.TbMerchantRepositoryCustom;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TbMerchantRepositoryImpl implements TbMerchantRepositoryCustom{

	
	private final Querydslconfig queryFactory;
	


	@Override
	public BooleanExpression selectSn(Long sn) {
		// TODO Auto-generated method stub
		return sn != null ? tbMembEntity.membSn.eq(sn) : null;
	}

	@Override
	public BooleanExpression offSet(NumberPath<Long> sn) {
		// TODO Auto-generated method stub
		return sn != null ? tbMembEntity.membSn.lt(sn) : null;
	}

	@Override
	public BooleanExpression selectId(String id) {
		// TODO Auto-generated method stub
		return id != null ? tbMembEntity.membId.eq(id) : null;
	}

	@Override
	public Long selctMerchantSN(TbMerchantDefault tbMerchantDefault) {
		// TODO Auto-generated method stub
		return	queryFactory.jpaQueryFactory()
						.select(tbMerchantEntity.merchantSn)
						.from(tbMerchantEntity)
						.where(check(1)
								)
						.offset(0)
						.fetchFirst();
						
				
				
	}
	
	public BooleanExpression check(int i) {
		return null;
		//	return tbGoodsEntity.goodsNo.loe(i);
	}

	@Override
	public BooleanExpression checkGoods(Long sn) {
		// TODO Auto-generated method stub
		return sn != null ? tbMembEntity.membSn.eq(sn) : null;
	}

}
