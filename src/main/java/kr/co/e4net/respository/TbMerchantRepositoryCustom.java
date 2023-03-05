package kr.co.e4net.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;

import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMerchantEntity;


public interface TbMerchantRepositoryCustom{
		
	Long selctMerchantSN(TbMerchantDefault tbMerchantDefault);
	
	BooleanExpression selectSn(Long sn);
	
	BooleanExpression offSet(NumberPath<Long> sn);

	BooleanExpression selectId(String id);
	
	BooleanExpression checkGoods(Long sn);
	
}
