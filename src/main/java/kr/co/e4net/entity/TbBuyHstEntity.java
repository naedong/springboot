package kr.co.e4net.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "TB_BUY_HST")
@SequenceGenerator(
		  name = "BUY_HST_SN_SEQ_GENERATOR", 
		  sequenceName = "BUY_HST_SN_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbBuyHstEntity extends TableData{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUY_HST_SN_SEQ_GENERATOR") // jpa 넘버링전략이 아닌 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Column(nullable = true, name = "BUY_HST_SN")
	private Long buyHstSn;
	

	@ManyToOne
	@JoinColumn(name = "MEMB_SN")
	private TbMembEntity tbMembEntity;
	
	@Column(nullable = true, name = "GOODS_AMT")
	private Long goodsAmt;
	
	@ManyToOne
	@JoinColumn( name = "GOODS_NO",referencedColumnName = "GOODS_NO")
	private TbGoodsEntity tbGoodsEntity;
	
	@Column
	private Long buyQtt;
	
	@Column
	private Long buyAmt;
	
	
	@Builder
	public TbBuyHstEntity(Long buyHstSn,
			TbMembEntity tbMembEntity,
			TbGoodsEntity tbGoodsEntity,
			Long goodsAmt,
			Long buyQtt,
			Long buyAmt) {
		this.buyHstSn = buyHstSn;
		this.tbGoodsEntity = tbGoodsEntity;
		this.goodsAmt = goodsAmt;
		this.buyAmt = buyAmt;
		this.buyQtt = buyQtt;
	}
	
}
