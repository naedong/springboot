package kr.co.e4net.dto;

import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.entity.TableData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class TbMoneyTransferHstDto {

	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbMembMoneyDefault extends TableData{
		private Long transferTyCd;
		private Long TransferAmt;
		private Long payMeanCd;
		private String payTransferNo;
	}
	
	

	@Builder
	@Setter
	@Getter
	@AllArgsConstructor
	public static class TbMembMoneyBoard{
		private Long moneyTransferHstSn;
		private String transferTyCd;
		private Long TransferAmt;
		private String payMeanCd;
		private String payTransferNo;
		private Long membSn;
		private String frstRegistDt;
		private String lastRegistDt;
	}
	
	
}
