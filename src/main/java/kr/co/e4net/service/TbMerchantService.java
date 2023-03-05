package kr.co.e4net.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.entity.TbMerchantEntity.TbMerchantEntityBuilder;
import kr.co.e4net.map.mapper.TbMembLoginMapper;
import kr.co.e4net.map.mapper.TbMembSignMapper;
import kr.co.e4net.map.mapper.TbMerchantListMapper;
import kr.co.e4net.respository.TbMembRepository;
import kr.co.e4net.respository.TbMerchantRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbMerchantService {

	private final TbMerchantRepository tbMerchantRepository;
	private final TbMerchantListMapper tbMerchantListMapper;
	private final TbGoodsService tbGoodsService;
	
	
	public void insertTbMerchant(List<TbMerchantDefault> tbMerchantDefault, TbMembEntity tbMembEntity) {
		System.out.println(tbMerchantDefault+"디폴트");
	
		List<TbMerchantEntity> tbMerchantEntity = tbMerchantListMapper.INSTANCE.ListToEntity(tbMerchantDefault, tbMembEntity);
		tbMerchantRepository.saveAll(tbMerchantEntity);
		
		tbGoodsService.defaultInsetGoods(tbMerchantDefault);
	}
}
