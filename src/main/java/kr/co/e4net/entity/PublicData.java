package kr.co.e4net.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PublicData {
	
	
	
	private String detailAddr;
	
	private String emailAddr;
	
	private String zipCd;
	
	private String zipAddr;
	
	@Builder
	public PublicData(String detailaddr, String emailAddr, String zipCd, String zipAddr) {
		this.detailAddr = detailaddr;
		this.emailAddr = emailAddr;
		this.zipCd = zipCd;
		this.zipAddr = zipAddr;		
	}
	
	
}
