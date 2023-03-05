package kr.co.e4net.respository.impl;



import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.e4net.config.Querydslconfig;
import kr.co.e4net.dto.TbMembDto;
import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembMoneyEntity;
import kr.co.e4net.map.mapper.TbMembLoginMapper;
import kr.co.e4net.map.mapper.TbMembSignMapper;
import static kr.co.e4net.entity.QTbMembMoneyEntity.tbMembMoneyEntity;
import kr.co.e4net.respository.TbMembRepositoryCustom;
import static kr.co.e4net.entity.QTbMembEntity.tbMembEntity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
//import static kr.co.e4net.entity.QTbMembLoginHstEntity.tbMembLoginHstEntity;
import java.util.List;
import java.util.logging.Logger;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;




@RequiredArgsConstructor
public class TbMembRepositoryImpl implements TbMembRepositoryCustom {

	private final Querydslconfig queryFactory;
	
	private final TbMembSignMapper tbMembSignMapper;

	
	
	@Override
	public List<TbMembEntity> getByMembId(TbMembLogin tbMembDto) {
		// TODO Auto-generated method stub
		return	queryFactory.jpaQueryFactory()
				.selectFrom(tbMembEntity)
				.where(tbMembEntity.membId
						.eq(tbMembDto.getMembId())
						).fetch();
	}

	@Override
	public BooleanExpression selectMeId(String id) {
		// TODO Auto-generated method stub
		return id != null ? tbMembEntity.membId.eq(id) : null;
	}
//	
//	public BooleanExpression NullZero() {
//		return tbMembEntity.membSn.isNotNull();  
//	}
//	
	
	@Override
	public TbMembSign webLogin(TbMembLogin tbMembLogin) {
		// TODO Auto-generated method stub
		try {

			TbMembEntity lotbMembEntity = queryFactory.jpaQueryFactory()
					.selectFrom(tbMembEntity)
					.where(selectMeId(tbMembLogin.getMembId())
							.and(checkIdPwd(tbMembLogin)))
					.fetchOne();
//					.where(selectMeId(tbMembLogin.getMembId())
//							.and(checkIdPwd(tbMembLogin))
//							).fetchOne();
							// nullzero 마스터 키 디폴트로 넣는 마스터 값 
							// Null 일시 Where pattern이 체크가 안됨 
//							.and(NullZero()))
//			
//			queryFactory.jpaQueryFactory().insert(tbMembLoginHstEntity)
//			.columns(tbMembLoginHstEntity.tbMembEntity, tbMembLoginHstEntity.connectIp )
//							.values(tbMembEntity.membSn, tbMembLogin.getConnectIp());
//			
			
			
			TbMembSign tbMembSign =	 tbMembSignMapper.INSTANCE.toDto(lotbMembEntity);
			
			
			return tbMembSign;
	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}			

	}

	public BooleanExpression checkIdPwd(TbMembLogin tbMembLogin) {
		return tbMembLogin.getMembPwd() != null ? tbMembEntity.membPwd.eq(tbMembLogin.getMembPwd()) : null;
	}

	
	@Override
	public boolean checkId(Long id) {
		// TODO Auto-generated method stub
		return queryFactory.jpaQueryFactory().from(tbMembEntity)
				.where(tbMembEntity.membSn.eq(id))
				.select(tbMembEntity.membSn)
				.fetch().isEmpty();				
	}

	@Override
	public BooleanExpression noOffSet(Long membSn) {
		// TODO Auto-generated method stub
		return membSn != null ? tbMembEntity.membSn.lt(membSn) : null;
	}

	@Override
	public BooleanExpression selectMePwd(String pwd) {
		// TODO Auto-generated method stub
		return pwd != null ? tbMembEntity.membPwd.lt(pwd) : null;
	}

	@Override
	public BooleanExpression selectMeSn(TbMembEntity membsn) {
		// TODO Auto-generated method stub
		return membsn != null ? tbMembEntity.membSn.eq(membsn.getMembSn()) : null;
	}

	@Override
	public @Nullable TbMembEntity insertId(TbMembEntity membsn) {
		// TODO Auto-generated method stub
		return queryFactory.jpaQueryFactory().selectFrom(tbMembEntity)
				.where(selectMeSn(membsn)).fetchOne();
	}	
	
	
	@Override
	public BooleanExpression selectMeEmail(String email) {
		// TODO Auto-generated method stub
		return email != null ? tbMembEntity.membPwd.lt(email) : null;
	}

	@Override
	public TbMembEntity checkId(String membId) {
		// TODO Auto-generated method stub
		System.out.println(membId);
		return  queryFactory.jpaQueryFactory()
				.select(tbMembEntity)
				.from(tbMembEntity)
				.where(selectMeId(membId)).fetchOne();
		}

	@Override
	public TbMembEntity getMemb(Long membSn) {
		// TODO Auto-generated method stub
		return queryFactory.jpaQueryFactory().selectFrom(tbMembEntity).where(noOffSet(membSn).and(checkSn(membSn))).fetchOne();
	}

	@Override
	public BooleanExpression checkSn(Long membSn) {
		// TODO Auto-generated method stub
		return membSn != null ? tbMembEntity.membSn.eq(membSn) : null;
	}

	@Override
	public TbMembEntity masterShop(List<TbMerchantDefault> tbMerchantDefault) {
		// TODO Auto-generated method stub
		return queryFactory.jpaQueryFactory()
				.selectFrom(tbMembEntity)
				.where(checkSn(
						queryFactory.jpaQueryFactory()
						.select(tbMembEntity.membSn)
						.from(tbMembEntity)
						.where(selectMeId("master"))
						.fetchFirst()
						)
						)
				.limit(1)
				.fetchFirst();
	}


	
	

}
