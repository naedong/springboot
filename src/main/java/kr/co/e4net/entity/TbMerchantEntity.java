package kr.co.e4net.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "TB_MERCHANT")
@SequenceGenerator(
		  name = "MERCHANT_SN_SEQ_GENERATOR", 
		  sequenceName = "MERCHANT_SN_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbMerchantEntity extends TableData{
	

	@ManyToOne
	@JoinColumn(name = "MEMB_SN",nullable = false,referencedColumnName = "MEMB_SN")
	private TbMembEntity tbMembEntity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MERCHANT_SN_SEQ_GENERATOR") // jpa 넘버링전략이 아닌 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Column(nullable = false, name = "MERCHANT_SN")
	private Long merchantSn; //시퀀스 , auto_increment
	
	@Column(name = "MERCHANT_NM")
	private String merchantNm;
	

	@Column(name = "MERCHANT_DESC")
	private String merchantDesc;
	

	@Column(name = "MERCHANT_URL")
	private String merchantUrl;

	@Column(name = "TEL_NO")
	private String telNo;
	
	@Embedded
	private PublicData publicData;

	
	@Builder
	public TbMerchantEntity( Long merchantSn,
			TbMembEntity tbMembEntity,
			String merchantNm, String merchantDesc, String
			merchantUrl, String telNo, PublicData publicData) {
		this.merchantSn = merchantSn;
		this.merchantNm = merchantNm;
		this.telNo = telNo;
		this.merchantDesc = merchantDesc;
		this.merchantUrl = merchantUrl;
		this.publicData = publicData;
		this.tbMembEntity = tbMembEntity;
	}
	
//	@Override
//	public String getEmailAddr() {
//		return null;
//	}
//	
//	@Override
//	public String getZipCd() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@Override
//	public String getZipAddr() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getDetailAddr() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	

}
