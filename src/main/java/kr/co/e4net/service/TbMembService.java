package kr.co.e4net.service;



import kr.co.e4net.map.mapper.TbMembLoginMapper;
import kr.co.e4net.map.mapper.TbMembSignMapper;
import kr.co.e4net.respository.TbMembRepositoryCustom;
import kr.co.e4net.respository.TbMembMoneyRepository;
import kr.co.e4net.respository.TbMembRepository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.dto.TbMembDto;
import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.PublicData;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity;
import lombok.RequiredArgsConstructor;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbMembService {
	
	
	private final TbMembSignMapper tbMembSignMapper;
	private final TbMembLoginHstService tbMembLoginHstService;
	private final TbMembMoneyService tbMembMoneyService;
	private final TbBuyHstService tbBuyHstService;
	// Named Query 사용용 원래 사용할 필요 없음
//	private final EntityManager entityManager;
	private final TbGoodsService goodsService;
	private final TbMembRepository tbMembRespositoy;
		
	private final TbMembLoginMapper tbMembLoginMapper;
	private final TbMoneyTransferHstService tbMoneyTransferHstService;
	private final TbMerchantService tbMerchantService;

	// https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/batch.html#batch-direct 
//	@PersistenceContext
//	private final EntityManager entityManager;
	
	
	
		@Transactional
	    public boolean insertUser(TbMembSign tbMembSign) {
			TbMembEntity tbMembEntity = TbMembSignMapper.INSTANCE.toEntity(tbMembSign);
			tbMembRespositoy.save(tbMembEntity);
			System.out.println(tbMembEntity.getMembSn());
			System.out.println("여기까진 확인");
			return tbMembMoneyService.insertUser(tbMembEntity);
	    }
		
		@Transactional
		public Boolean CheckID(String membId) {
			return tbMembRespositoy.selectMeId(membId).equals(true);
		}
		
//		@Transactional
//		public List<TbMemb> ListMoney(){
//			
//		}
//		
		
		
		@Transactional
		public TbMembMoneyDefault money(TbMembLogin tbMembMoneyDto) {
			System.out.println("check"+tbMembMoneyDto.getMembId());
			return tbMembMoneyService.nowMoney(tbMembRespositoy.checkId(tbMembMoneyDto.getMembId()));
		}
		
		
		@Transactional
		public TbMembSign webLogin(TbMembLogin tbMembLogin) {
			TbMembEntity membSn = tbMembRespositoy.checkId(tbMembLogin.getMembId());
			TbMembLoginHstEntity tbMembEntity = tbMembLoginMapper.INSTANCE.toEntity(tbMembLogin, membSn);
			if(tbMembLoginHstService.LoginCheck(tbMembLogin, membSn) == false) {return null;}
			return tbMembRespositoy.webLogin(tbMembLogin);
		}
		
		@Transactional
		public void insertMerchants(List<TbMerchantDefault> tbMerchantDefault) {
			TbMembEntity tbMembEntity =	tbMembRespositoy.masterShop(tbMerchantDefault);
			tbMerchantService.insertTbMerchant(tbMerchantDefault, tbMembEntity);
		}
		
		
		@Transactional
		public void trading(TbTradeBuy tbMembTrade ) {
			tbBuyHstService.tradeBuyHst( tbMembTrade);
			tbMoneyTransferHstService.tradingTable( tbMembTrade);			
			goodsService.transGoods(tbMembTrade);
			
		}
		
		
		
		@Transactional
		public void defaultAdmin(TbMembSign tbMembDto) {
			tbMembDto.setMembId("master");
			tbMembDto.setMembPwd("master");
			tbMembDto.setMembCls("관리자");
			tbMembDto.setMembStatusCd(10);
			tbMembDto.setMobileNo("010-0000-0000");
			tbMembDto.setMembNm("master");
			TbMembEntity tbMembEntity = tbMembSignMapper.INSTANCE.toEntity(tbMembDto);
			tbMembRespositoy.save(tbMembEntity);
			// 네임드 쿼리
//			entityManager.createNamedQuery("TbMembEntity.findById", TbMembEntity.class)
//			.setParameter("MEMB_ID", tbMembEntity.getMembId())
//			.setParameter("MEMB_PWD", tbMembEntity.getMembPwd())
//			.setParameter("MEMB_NM", tbMembEntity.getMembNm())
//			.setParameter("MEMB_CLS", tbMembEntity.getMembCls())
//			.setParameter("MOBILE_NO", tbMembEntity.getMobileNo())
//			.executeUpdate();
			
		}
//		@Transactional
//		public String mastermav(TbMembDto tbMembDto) {
//		return	entityManager.createNamedQuery("TbMembEntity.findByMembId", TbMembEntity.class)
//			.setParameter("MEMB_ID", "master")
//			.getParameter("MEMB_ID")
//			.getName();
//			
//			
//		}
//		 
}
