package kr.co.e4net.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class TbBuyHstDto {
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbBuyHst{
		// 우선 생성되고 머니 거래 이력에 남긴다. // 시퀀스 
		private Long buyQtt;
		private Long buyAmt;
		
	}
	
	
	
	
}
