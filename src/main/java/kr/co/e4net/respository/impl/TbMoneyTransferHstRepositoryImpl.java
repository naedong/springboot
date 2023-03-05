package kr.co.e4net.respository.impl;

import kr.co.e4net.config.Querydslconfig;
import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.dto.TbMoneyTransferHstDto.TbMembMoneyBoard;
import kr.co.e4net.entity.TbMembEntity;
import static kr.co.e4net.entity.QTbMoneyTransferHstEntity.tbMoneyTransferHstEntity;
import static kr.co.e4net.entity.QTbMembEntity.tbMembEntity;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.entity.TbMoneyTransferHstEntity;
import kr.co.e4net.respository.TbMoneyTransferHstRepositoryCustom;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TbMoneyTransferHstRepositoryImpl implements TbMoneyTransferHstRepositoryCustom{

	
	private final Querydslconfig querydslconfig;
	
	@Override
	public TbMembEntity trade( TbTradeBuy tbMembTrade) {
		// TODO Auto-generated method stub
		return querydslconfig.jpaQueryFactory()
				.selectFrom(tbMembEntity)
				.where(membIdCheck(tbMembTrade.getMembId())
						)
				.fetchFirst();
	}

	@Override
	public BooleanExpression membIdCheck(String id) {
		// TODO Auto-generated method stub
		return id != null ? tbMembEntity.membId.eq(id) : null;
	}

	@Override
	public List<TbMoneyTransferHstEntity> boardTable(String id) {
		// TODO Auto-generated method stub
		return querydslconfig.jpaQueryFactory()
				.select(tbMoneyTransferHstEntity)
				.from(tbMoneyTransferHstEntity)
				.where(tbMoneyTransferHstEntity.tbMembEntity.membSn.eq(
						querydslconfig.jpaQueryFactory()
						.select(tbMembEntity.membSn)
						.from(tbMembEntity)
						.where(tbMembEntity.membId.eq(id))
						.fetchFirst()
						))
				.fetch();
	}


//	@Override
//	public Page<TbMoneyTransferHstEntity> boardTable(String id, Pageable pageable) {
//		// TODO Auto-generated method stub
//	
//		List<TbMoneyTransferHstEntity> result = querydslconfig.jpaQueryFactory().select(tbMoneyTransferHstEntity)
//				.from(tbMoneyTransferHstEntity)
//				.where(tbMoneyTransferHstEntity.tbMembEntity.membSn.eq(
//						querydslconfig.jpaQueryFactory()
//						.select(tbMembEntity.membSn)
//						.from(tbMembEntity)
//						.where(tbMembEntity.membId.eq(id))
//						.fetchFirst()
//						))
//				.offset(pageable.getPageNumber()).limit(pageable.getPageSize())
//				.fetch();
//		
//		Integer count = querydslconfig.jpaQueryFactory()
//				.select(tbMoneyTransferHstEntity.count())
//				.from(tbMoneyTransferHstEntity)
//				.where(tbMoneyTransferHstEntity.tbMembEntity.membSn.eq(
//						querydslconfig.jpaQueryFactory()
//						.select(tbMembEntity.membSn)
//						.from(tbMembEntity)
//						.where(tbMembEntity.membId.eq(id))
//						.fetchFirst()
//						))
//				.fetch().size();
//		
//		return new PageImpl<>(result, pageable, count);
	

}
