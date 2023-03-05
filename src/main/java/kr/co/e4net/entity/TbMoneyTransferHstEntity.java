package kr.co.e4net.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import kr.co.e4net.enums.PayMeanCd;
import kr.co.e4net.enums.TransferTyCd;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "TB_MONEY_TRANSFER_HST")
@SequenceGenerator(
		  name = "MONEY_TRANSFER_HST_SN_SEQ_GENERATOR", 
		  sequenceName = "MONEY_TRANSFER_HST_SN_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbMoneyTransferHstEntity extends TableData{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MONEY_TRANSFER_HST_SN_SEQ_GENERATOR") // jpa 넘버링전략이 아닌 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Column(nullable = true, name = "MONEY_TRANSFER_HST_SN")
	private Long moneyTransferHstSn; //시퀀스 , auto_increment
	
	@ManyToOne
	@JoinColumn(name = "MEMB_SN")
	private TbMembEntity tbMembEntity;
	

	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private TransferTyCd transferTyCd; //충전 : 01:카드, 02:계좌이체, 03: 머니사용
	
	@Column(nullable = true)
	private Integer transferAmt; 
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	//@ForeignKey
	private PayMeanCd payMeanCD;  //01:충전, 02:사용, 03:환전
	
	@Column(length = 50)
	private String payTransferNo;  //충전 시 결제 거래 고유번호
	
	@OneToOne
	@JoinColumn(name ="BUY_HST_SN", updatable = false, insertable = false, referencedColumnName = "BUY_HST_SN")
	private TbBuyHstEntity tbBuyHstEntity;
	
	
	@Builder
	public TbMoneyTransferHstEntity(
			Long moneyTransferHstSn
			,TbMembEntity tbMembEntity
			,Integer transferAmt
			,PayMeanCd payMeanCd
			,String payTransferNo
			,TransferTyCd transferTyCd
			,TbBuyHstEntity tbBuyHstEntity
			) {
		this.moneyTransferHstSn = moneyTransferHstSn;
		this.tbMembEntity = tbMembEntity;
		this.transferAmt = transferAmt;
		this.payMeanCD = payMeanCd;
		this.payTransferNo = payTransferNo;
		this.tbBuyHstEntity = tbBuyHstEntity;
		this.transferTyCd = transferTyCd;
	}
	
	
}
