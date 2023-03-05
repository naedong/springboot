package kr.co.e4net.respository;

import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.entity.TbBuyHstEntity;
import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbMembEntity;

public interface TbBuyHstRepositoryCustom {

	
	Long tbTradeBuy(TbTradeBuy tbMembTrade);
	TbGoodsEntity tbGoodsEntity(TbTradeBuy tbTradeBuy);
	
	BooleanExpression tbGoodsCheck(String id);
	BooleanExpression tbMembCheckId(String id);
	
	TbBuyHstEntity tbBuyhstEntity(TbTradeBuy tbMembTrade);
	
}
