package kr.co.e4net.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.dto.TbMoneyTransferHstDto.TbMembMoneyBoard;
import kr.co.e4net.entity.TbBuyHstEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity.TbMoneyTransferHstEntityBuilder;
import kr.co.e4net.enums.PayMeanCd;
import kr.co.e4net.enums.TransferTyCd;
import kr.co.e4net.map.mapper.TbMembLoginMapper;
import kr.co.e4net.map.mapper.TbMoneyTransferHstMapper;
import kr.co.e4net.respository.TbBuyHstRepository;
import kr.co.e4net.respository.TbMembLoginRepository;
import kr.co.e4net.respository.TbMoneyTransferHstRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbMoneyTransferHstService {
	
	private final TbMoneyTransferHstRepository tbmoneyTransferHstRepository;
	private final TbMoneyTransferHstMapper tbMoneyTransferHstMapper;
	private final TbBuyHstRepository tbBuyHstRepository;
	

	public boolean insertTable(TbMembMoneyCharge membMoneyCharge) {
//	TbMoneyTransferHstEntityBuilder tbMoneyTransferHstEntity = TbMoneyTransferHstEntity.builder();
//	
//	tbMoneyTransferHstEntity.payMeanCd(PayMeanCd.valueOf(membMoneyCharge.getPayMeanCd().name()))
//		.payTransferNo(membMoneyCharge.getPayTransferNo())
//		.transferTyCd(TransferTyCd.valueOf(membMoneyCharge.getTransferTyCd().name()))
//		.build();
			TbMoneyTransferHstEntity tthe = TbMoneyTransferHstMapper.INSTANCE.toEntity(membMoneyCharge);
			//tbmoneyTransferHstRepository.save(tthe);
//		tbmoneyTransferHstRepository.save(tbMoneyTransferHstEntity);
			tbmoneyTransferHstRepository.save(tthe);
		return tbmoneyTransferHstRepository.save(tthe) != null;
	}
	
	
	
	@Transactional
	public void tradingTable(TbTradeBuy membTrade) {
//		TbMoneyTransferHstEntity.builder().payMeanCd(tb)
//			tbmoneyTransferHstRepository.trade(tbTradeBuy, membTrade);
		
		
		TbMoneyTransferHstEntity tbMoneyTransferHstEntity =
		TbMoneyTransferHstEntity.builder()
		.payMeanCd(PayMeanCd.valueOf(membTrade.getPayMeanCd()))
		.tbMembEntity(tbmoneyTransferHstRepository.trade( membTrade))
		.transferTyCd(TransferTyCd.valueOf(membTrade.getTransferTyCd()))
		.payTransferNo(membTrade.getPayTransferNo())
		.transferAmt(membTrade.getTransferAmt())
		.tbBuyHstEntity(tbBuyHstRepository.tbBuyhstEntity(membTrade))
		.build();
		
		tbmoneyTransferHstRepository.save(tbMoneyTransferHstEntity);
	}
	
	
	@Transactional
	public List<TbMembMoneyBoard> boardTable(String id) {
	
		return tbMoneyTransferHstMapper.INSTANCE
				.listtoListEntity(tbmoneyTransferHstRepository.boardTable(id));
//		TbMoneyTransferHstEntity.builder().payMeanCd(tb)
//			tbmoneyTransferHstRepository.trade(tbTradeBuy, membTrade);
		
		
	}
	
	
}


