package kr.co.e4net.respository;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMerchantEntity;

public interface TbGoodsRepositoryCustom {
	
	
	List<TbMerchantEntity> checkGoods();
	BooleanExpression check(int i);
	
	TbGoodsEntity checkGoodsNumber(TbTradeBuy tbTradeBuy);
	BooleanExpression selectGoodsNoModelCheck(String modelno);
	BooleanExpression selectGoodsMerchant(String merchant);
	
	Long tradeNumber(TbTradeBuy tbMembTrade);
	
	
}
