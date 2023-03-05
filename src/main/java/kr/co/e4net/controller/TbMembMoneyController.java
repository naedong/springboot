package kr.co.e4net.controller;

import java.util.List;

import org.hibernate.loader.plan.build.internal.AbstractLoadPlanBuildingAssociationVisitationStrategy.PropertyPathStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.annotations.ApiOperation;
import kr.co.e4net.config.ApiKey;
import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembMoneyDto;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.service.TbMembMoneyService;
import kr.co.e4net.service.TbMembService;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TbMembMoneyController {

	// 빈 등록 문제였습니다. 싱글톤으로 만들면 우선적으로 빈등록이 안됨 AUtowired 나 Required로 사용
	private final ApiKey apiKey;
	private final TbMembMoneyService tbMembMoneyService;
	private final TbMembService tbMembService;
	
	@ApiOperation(value = "아임포트 TOKEN API",
            notes = "사용자 등록 및 업데이트시 사용")
	@GetMapping("test/test")
	public ResponseEntity<String> getToken() {
		  OkHttp3ClientHttpRequestFactory client = new OkHttp3ClientHttpRequestFactory();		
		System.out.println(apiKey.getRestportkey()+"키 값나오는 지 확인");
		return ResponseEntity.ok("test");
	}

	
	@PostMapping("money/now")
	public ResponseEntity<TbMembMoneyDefault> Money(@RequestBody TbMembLogin tbMembLogin){
		System.out.println("tbMembLogin" + tbMembLogin.getMembId());
		System.out.println(tbMembService.money(tbMembLogin)+ "why nyll?"+
		tbMembLogin.getMembId());
		return ResponseEntity.ok(tbMembService.money(tbMembLogin));
	}
	
	
	@PostMapping("money/updatemoney")
	public ResponseEntity<TbMembMoneyDefault> updateMoney(@RequestBody TbMembMoneyCharge now){
		System.out.println(now);
		System.out.println("전달 확인");
		return ResponseEntity.ok(tbMembMoneyService.chargeMoney(now));
	}
	
	
	@PostMapping("money/trade")
	public ResponseEntity<TbTradeBuy> tradeMoney(@RequestBody TbTradeBuy tbMembTrade){
		System.out.println("전달 확인");
	
		System.out.println(tbMembTrade.getPayTransferNo()+"!!!!!!!");		
		System.out.println(tbMembTrade.getMembId()+"!!!!!!!");

		//TEST 
//		tradebuy.setBuyAmt(Long.parseLong("1000"));
//		tradebuy.setBuyQtt(Long.parseLong("1"));
//		tradebuy.setGoodsAmt(tradebuy.getBuyAmt());
//		tradebuy.setPayMeanCd(01);
//		tradebuy.setPayTransferNo("01010101");
//		tradebuy.setTransferAmt(1000);
//		tradebuy.setTransferTyCd(01);
//
//		tbMembTrade.setMembId("qwerqwer@naver.com");	
		tbMembService.trading(tbMembTrade);
		return ResponseEntity.ok(tbMembTrade);
	}
	
}
