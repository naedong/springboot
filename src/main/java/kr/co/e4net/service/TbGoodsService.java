package kr.co.e4net.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.map.mapper.TbGoodsMapper;
import kr.co.e4net.map.mapper.TbMembMoneyMapper;
import kr.co.e4net.respository.TbGoodsRepository;
import kr.co.e4net.respository.TbMembMoneyRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbGoodsService {
	
	private final TbGoodsRepository tbGoodsRepository;
	private final TbGoodsMapper tbGoodsMapper;
	
	@Transactional
	public void defaultInsetGoods(List<TbMerchantDefault> tbMerchantDefault) {
		Long a = (long) 1;
		for(TbMerchantDefault e : tbMerchantDefault) {
//		 TbMerchantEntity tbMerchantEntity = tbGoodsRepository.checkGoods();
		 TbMerchantEntity tbMerchantEntity = TbMerchantEntity.builder().merchantSn(a).build();
			 TbGoodsEntity tbGoodsEntity = tbGoodsMapper.INSTANCE.toEntity(e, tbMerchantEntity);
			 tbGoodsRepository.save(tbGoodsEntity);
			 a += 1L;
		 
		}
		
	}
	
	@Transactional
	public boolean transGoods(TbTradeBuy tbMembTrade) {
		
		
		return tbGoodsRepository.tradeNumber(tbMembTrade) != null;
	}
	
}
