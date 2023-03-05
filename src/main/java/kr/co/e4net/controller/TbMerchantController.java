package kr.co.e4net.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.service.TbMembService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TbMerchantController {

	
	private final TbMembService tbMembService;
	
	@PostMapping("merchant/list")
	public ResponseEntity<List<TbMerchantDefault>> ManyMerchant(@RequestBody List<TbMerchantDefault> may){
		System.out.println("여기 확인 리스트값 확인");
		System.out.println(may);
		
		for(TbMerchantDefault a : may) {
			System.out.println(a.getGoodsClsDt());
			System.out.println(a.getGoodsDesc());
			System.out.println(a.getGoodsImgPath());
			System.out.println(a.getGoodsModelNo());
			System.out.println(a.getGoodsNm());
			System.out.println(a.getGoodsShopCost());
			System.out.println(a.getMerchantDesc());
			System.out.println(a.getMerchantNm());
			System.out.println(a.getMerchantUrl());
			System.out.println(a.getRealFileNm());
			System.out.println(a.getTelNo());
			System.out.println(a.getGoodsAmt());
			System.out.println(a.getGoodsQtt());
		}
		tbMembService.insertMerchants(may);
		return ResponseEntity.ok(may);
	}
	
}
