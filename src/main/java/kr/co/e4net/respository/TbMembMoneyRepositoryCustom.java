package kr.co.e4net.respository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;

import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.entity.TbMembMoneyEntity;

public interface TbMembMoneyRepositoryCustom {
	
	
	TbMembMoneyEntity nowMoney(Long membSn);
	
	
	
	TbMembMoneyEntity chargeMoney(TbMembMoneyCharge charge);
	
	BooleanExpression checkUd(String id);
	

	
	BooleanExpression offSet(Long id);



	BooleanExpression checkSn(NumberPath<Long> membSn);
	
}
