package kr.co.e4net.dto;

import kr.co.e4net.dto.TbMembMoneyDto.TbTradeBuy;
import kr.co.e4net.entity.PublicData;
import kr.co.e4net.enums.MembCls;
import kr.co.e4net.enums.MembStatusCd;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TbMembDto {
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbMembLogin{
		private Long membSn;
		private String membId;
		private String membPwd;
		private String connectIp;
	}
	

	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class TbMembSign{
		private Long membSn;
		private String membCls;
		private Integer membStatusCd;
		private String membId;
		private String membPwd;
		private String mobileNo;
		private String membNm;
		private PublicData publicData;
		private String lastLoginDtm;
	}
	
	
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)	
	public static class Phone{

	        private String phone;
	        private String certificationNumber;

	        @Builder
	        public Phone(String phone, String certificationNumber) {
	            this.phone = phone;
	            this.certificationNumber = certificationNumber;
	        }

	    }


	
	
}
