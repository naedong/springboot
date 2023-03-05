package kr.co.e4net.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbBuyHstEntity;
import kr.co.e4net.entity.TbGoodsEntity;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.map.mapper.TbGoodsMapper;
import kr.co.e4net.respository.TbBuyHstRepository;
import kr.co.e4net.respository.TbGoodsRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbBuyHstService {
	
	
	private final TbGoodsRepository tbGoodsRepository;
	private final TbBuyHstRepository tbBuyHstRepository;
		
	@Transactional
	public void tradeBuyHst(
			TbTradeBuy tbMembTrade) {
		System.out.println(tbMembTrade.getMembId()+"check id");
		System.out.println(tbMembTrade.getMembId());
		TbMembEntity tbEntity =
		TbMembEntity.of().membSn(tbBuyHstRepository.tbTradeBuy(tbMembTrade)).build();
		
		
		TbBuyHstEntity tbBuyHstEntity =
		TbBuyHstEntity.builder().buyAmt(tbMembTrade.getBuyAmt())
		.buyQtt(tbMembTrade.getBuyQtt())
		.tbMembEntity(tbEntity)
		.goodsAmt(tbMembTrade.getGoodsAmt())
		.build();
		tbBuyHstRepository.save(tbBuyHstEntity);
		}
	
}
