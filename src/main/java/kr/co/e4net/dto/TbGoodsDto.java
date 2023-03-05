package kr.co.e4net.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class TbGoodsDto {
	
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbGoods{ // 판매수량 상품수량 업데이트 용
		private String goodsModelNo;
		private String goodsQtt;
	
	}
	
	
}
