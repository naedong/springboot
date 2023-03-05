package kr.co.e4net.dto;

import kr.co.e4net.entity.PublicData;
import kr.co.e4net.entity.TableData;
import kr.co.e4net.enums.PayMeanCd;
import kr.co.e4net.enums.TransferTyCd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class TbMembMoneyDto {
	
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbMembMoneyDefault extends TableData{
		private Long membSn;
		@Builder.Default
		private int moneyBlce = 0;	
	}
	

	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbMembMoneyCharge{
		private Long membSn;
		private String membId;
		private Integer transferAmt;
		private TransferTyCd transferTyCd;
		private String payTransferNo;
		private PayMeanCd payMeanCd;
	}
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbTradeBuy extends TableData{
		private String membId;
		private Integer transferTyCd;
		private Integer transferAmt;
		private Integer payMeanCd;
		private String payTransferNo;
		private Long buyQtt;
		private Long buyAmt;
		private Long goodsAmt;
	
		
		private String goodsNm;
		private String goodsModelNo;
	
	
	}
	
	
	
	
	
	
	
	
	
	
}
