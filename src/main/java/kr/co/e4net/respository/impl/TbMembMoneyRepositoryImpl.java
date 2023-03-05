package kr.co.e4net.respository.impl;

import kr.co.e4net.config.Querydslconfig;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.entity.TbMembMoneyEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity;
import kr.co.e4net.map.mapper.TbMembSignMapper;

import static kr.co.e4net.entity.QTbMembEntity.tbMembEntity;
import static kr.co.e4net.entity.QTbMembMoneyEntity.tbMembMoneyEntity;

import org.jetbrains.annotations.Nullable;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;

import kr.co.e4net.respository.TbMembMoneyRepositoryCustom;
import kr.co.e4net.respository.TbMembRepositoryCustom;
import lombok.RequiredArgsConstructor;

//
//Entity보다는 Dto를 우선하자
//Entity를 조회하면 다음과 같은 단점이 있다.
//
//하이버네이트 1차, 2차 캐시 문제 발생
//불필요한 컬럼을 조회하게 된다.
//OneToOne N+1 쿼리 발생
//즉, 단순 조회 기능에서는 성능 이슈 요소가 많다.
//그럼 어떨 때 Entity, 어떨 때 Dto를 사용해야할까?
//실시간으로 Entity 변경이 필요한 경우에는 Entity를 사용하자.
//고강도 성능 개선 or 대량의 데이터 조회가 필요한 경우에는 Dto를 사용하자.


@RequiredArgsConstructor
public class TbMembMoneyRepositoryImpl  implements TbMembMoneyRepositoryCustom {

	private final Querydslconfig queryFactory;
	
	private final TbMembSignMapper tbMembSignMapper;

	@Override
	public TbMembMoneyEntity nowMoney(Long membSn) {
		// TODO Auto-generated method stub
		
	
		
		return queryFactory.jpaQueryFactory().selectFrom(tbMembMoneyEntity)
				.where(tbMembMoneyEntity.tbMembEntity.membSn.eq(membSn)
						).fetchFirst();
	}

	@Override
	public TbMembMoneyEntity chargeMoney(TbMembMoneyCharge charge) {
		// TODO Auto-generated method stub
		
		if( charge == null) { System.out.println("ImplCharge Error"); return null; } 
			queryFactory.jpaQueryFactory()
			.update(tbMembMoneyEntity)
			.set(tbMembMoneyEntity.moneyBlce, charge.getTransferAmt()+
					queryFactory.jpaQueryFactory()
			.select(tbMembMoneyEntity.moneyBlce)
			.from(tbMembMoneyEntity)
			.where(checkSn(tbMembMoneyEntity.tbMembEntity.membSn)
					).fetchFirst()
			)
			//.setNull(null))
			.where(checkSn(tbMembMoneyEntity
					.tbMembEntity.membSn))
			.execute();
					
					
//					checkUd(
//					queryFactory.jpaQueryFactory()
//					.select(tbMembEntity.membId)
//					.from(tbMembEntity)
//					.fetchOne()))
			
			
		
			
		return queryFactory.jpaQueryFactory().select(tbMembMoneyEntity)
				.from(tbMembMoneyEntity)
				.where(checkSn(tbMembMoneyEntity.tbMembEntity
						.membSn))
				.fetchOne();
	}

	@Override
	public BooleanExpression checkUd(String id) {
		// TODO Auto-generated method stub
		return id != null ? tbMembEntity.membId.eq(id) : null;
		
		
	}

	@Override
	public BooleanExpression offSet(Long id) {
		// TODO Auto-generated method stub
		return  id != null ? tbMembEntity.membSn.lt(id) : null;
	}

	@Override
	public BooleanExpression checkSn(NumberPath<Long> membSn) {
		// TODO Auto-generated method stub
		return  membSn != null ? tbMembMoneyEntity.tbMembEntity.membSn.eq(membSn) : null;
	}

	
}
