package kr.co.e4net.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.dto.TbMembMoneyDto;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity;
import kr.co.e4net.entity.TbMembMoneyEntity;
import kr.co.e4net.map.mapper.TbMembMoneyMapper;
import kr.co.e4net.map.mapper.TbMembSignMapper;
import kr.co.e4net.respository.TbMembMoneyRepository;
import kr.co.e4net.respository.TbMoneyTransferHstRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbMembMoneyService {

	private final TbMembMoneyRepository tbMembMoneyRepository;
	private final TbMembMoneyMapper tbMembMoneyMapper;
	private final TbMoneyTransferHstService tbMoneyTransferHstService;

	
	@Transactional
    public boolean insertUser(TbMembEntity tbMembEntity) {
		if(tbMembEntity == null) { System.out.println("리턴 fasle 장소"); return false;	}
		System.out.println("리턴 no  장소"); 
		System.out.println(tbMembEntity);
		TbMembMoneyEntity tbMembMoneyEntity = TbMembMoneyEntity.builder().tbMembEntity(tbMembEntity).build();
		 tbMembMoneyRepository.save(tbMembMoneyEntity);
		 
		 
		return tbMembMoneyRepository.save(tbMembMoneyEntity) != null;	
	}
	
	@Transactional
	public TbMembMoneyDefault nowMoney(TbMembEntity tbMembEntity) {
		TbMembMoneyEntity df = tbMembMoneyRepository.nowMoney(tbMembEntity.getMembSn());
		
		return  tbMembMoneyMapper.INSTANCE.toDto(df);
	}
	
	@Transactional
	public TbMembMoneyDefault chargeMoney(TbMembMoneyCharge charge) {
		TbMembMoneyEntity tbEntity = tbMembMoneyRepository.chargeMoney(charge);
		
		if(tbEntity != null)
		tbMoneyTransferHstService.insertTable(charge);
		return tbMembMoneyMapper.INSTANCE.toDto(tbEntity);
	}
	
	
	
}
