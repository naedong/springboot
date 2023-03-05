package kr.co.e4net.dto;

import java.util.Date;

import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyDefault;
import kr.co.e4net.entity.PublicData;
import kr.co.e4net.entity.TableData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class TbMerchantDto {
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbMerchantDefault extends TableData{
		private String merchantNm;
		private String merchantDesc;
		private String merchantUrl;
		private String telNo;
		private Long goodsAmt;
		private String goodsNm;
		private String goodsModelNo;
		private String goodsShopCost;
		private String goodsDesc;
		private PublicData publicData;
		private Long goodsQtt;
		private Long goodsSellQtt;
		private String realFileNm;
		private String goodsClsDt;
		private String goodsImgPath;
	}
}
