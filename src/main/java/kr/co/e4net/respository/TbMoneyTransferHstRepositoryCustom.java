package kr.co.e4net.respository;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.dto.TbMoneyTransferHstDto.TbMembMoneyBoard;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity;

public interface TbMoneyTransferHstRepositoryCustom {

	
	TbMembEntity trade(TbTradeBuy tbMembTrade);
	
	BooleanExpression membIdCheck(String id);
	
	
	List<TbMoneyTransferHstEntity> boardTable(String id);
	
}
