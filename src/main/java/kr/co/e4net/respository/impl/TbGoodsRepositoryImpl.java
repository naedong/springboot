package kr.co.e4net.respository.impl;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.config.Querydslconfig;
import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.respository.TbGoodsRepositoryCustom;
import static kr.co.e4net.entity.QTbGoodsEntity.tbGoodsEntity;
import static kr.co.e4net.entity.QTbMerchantEntity.tbMerchantEntity;

import java.util.List;

import kr.co.e4net.respository.TbMerchantRepositoryCustom;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TbGoodsRepositoryImpl implements TbGoodsRepositoryCustom{

	
	private final Querydslconfig querydslconfig;

	@Override
	public List<TbMerchantEntity> checkGoods() {
		// TODO Auto-generated method stub
		System.out.println("쿼리 시작");
		return querydslconfig.jpaQueryFactory()
				.select(tbMerchantEntity)
				.from(tbMerchantEntity)
				.distinct()
//				.where(
//						//bMerchantEntity.merchantSn.eq(tbGoodsEntity.goodsNo))
//						tbGoodsEntity.goodsNo.loe(
//						querydslconfig.jpaQueryFactory()
//						.select(tbMerchantEntity.merchantSn)
//						.from(tbMerchantEntity)
//						.fetchOne()
//						))
						
//						querydslconfig.jpaQueryFactory()
//						.select(tbMerchantEntity.merchantSn)
//						.from(tbMerchantEntity)
//						.limit(1)
//						.fetchOne()))

				.fetch();
//				.selectFrom(tbMerchantEntity)
//				.where( tbGoodsEntity.goodsNo.loe(querydslconfig.jpaQueryFactory()
//						.select(tbGoodsEntity.count())
//						.from(tbGoodsEntity)
//						.where(tbGoodsEntity.goodsNo.loe(1))
//						.fetchFirst()
//						))
//				.offset(0)
//				.fetchFirst();
	}

	@Override
	public BooleanExpression check(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbGoodsEntity checkGoodsNumber(TbTradeBuy tbTradeBuy) {
		// TODO Auto-generated method stub
		return querydslconfig.jpaQueryFactory().select(
				tbGoodsEntity)
				.from(tbGoodsEntity)
				.where(tbGoodsEntity.tbMerchantEntity.merchantSn.eq(
						querydslconfig.jpaQueryFactory()
						.select(tbGoodsEntity.tbMerchantEntity.merchantSn)
						.from(tbGoodsEntity)
						.where(tbGoodsEntity.goodsNm.eq(tbTradeBuy.getGoodsNm())
						.and(tbGoodsEntity.goodsModelNo.eq(
								tbTradeBuy.getGoodsModelNo())))
						.fetchFirst()
						)
						)
				.fetchOne();
				
				
	}


	@Override
	public BooleanExpression selectGoodsNoModelCheck(String modelno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooleanExpression selectGoodsMerchant(String merchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long tradeNumber(TbTradeBuy tbMembTrade) {
		// TODO Auto-generated method stub
		return querydslconfig.jpaQueryFactory()
				.update(tbGoodsEntity)
				.set(tbGoodsEntity.goodsSellQtt, tbGoodsEntity.goodsSellQtt.add(Long.parseLong("1")))
				.set(tbGoodsEntity.goodsQtt, tbGoodsEntity.goodsQtt.add(Long.parseLong("-1"))
						)
				.where(tbGoodsEntity.goodsSellQtt.ne(Long.parseLong("0")), tbGoodsEntity.goodsNo.eq(
						querydslconfig.jpaQueryFactory().select(tbGoodsEntity.goodsNo)
						.from(tbGoodsEntity)
						.where(tbGoodsEntity.goodsNm.eq(tbMembTrade.getGoodsNm())
								.and(tbGoodsEntity.goodsModelNo.eq(tbMembTrade.getGoodsModelNo()))).fetchFirst()
						)).execute();
						
					
	}
	
	
}
