package kr.co.e4net.respository.impl;

import kr.co.e4net.config.Querydslconfig;
import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.entity.TbBuyHstEntity;
import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbMembEntity;
import static kr.co.e4net.entity.QTbBuyHstEntity.tbBuyHstEntity;
import static kr.co.e4net.entity.QTbGoodsEntity.tbGoodsEntity;
import static kr.co.e4net.entity.QTbMembEntity.tbMembEntity;

import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.respository.TbBuyHstRepositoryCustom;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TbBuyHstRepositoryImpl implements TbBuyHstRepositoryCustom{
	
	private final Querydslconfig querydslconfig;
	
	@Override
	public Long tbTradeBuy(TbTradeBuy tbMembTrade) {
		// TODO Auto-generated method stub
		return querydslconfig.jpaQueryFactory().select(tbMembEntity.membSn)
				.from(tbMembEntity)
				.where(tbMembEntity.membSn
						.eq(
								querydslconfig.jpaQueryFactory()
								.select(tbMembEntity.membSn)
								.from(tbMembEntity)
								.where(
						tbMembCheckId(tbMembTrade.getMembId()
								))
								.fetchOne()
				))
				.fetchOne();
	}

	@Override
	public BooleanExpression tbMembCheckId(String id) {
		// TODO Auto-generated method stub
		return id != null ? tbMembEntity.membId.eq(id) : null;
	}

	@Override
	public TbGoodsEntity tbGoodsEntity(TbTradeBuy tbTradeBuy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooleanExpression tbGoodsCheck(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbBuyHstEntity tbBuyhstEntity(TbTradeBuy tbMembTrade) {
		// TODO Auto-generated method stub
		return querydslconfig.jpaQueryFactory().select(tbBuyHstEntity)
				.from(tbBuyHstEntity)
				.join(tbBuyHstEntity.tbMembEntity, tbMembEntity)
				.where(tbMembEntity.membSn.eq(
						querydslconfig.jpaQueryFactory()
						.select(tbMembEntity.membSn)
						.from(tbMembEntity)
						.fetchFirst()))
				.fetchFirst();
	}
		
	
	

}
