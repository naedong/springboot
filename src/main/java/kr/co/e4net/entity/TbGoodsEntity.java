package kr.co.e4net.entity;

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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import kr.co.e4net.util.SeqGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@DynamicInsert
@Table(name = "TB_GOODS")
//@SequenceGenerator(
//		  name = "GOODS_NO_SEQ_GENERATOR", 
//		  sequenceName = "GOODS_NO_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
//		  initialValue = 0000001,
//		  allocationSize = 1)

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbGoodsEntity {
	
	//private static final String goods = "000001";
	
	@Id	
	@GenericGenerator(name = "GOODS_NO_SEQ_GENERATOR",  // @GeneratedValue의 generator modifier에서 사용할 이름
	strategy = "kr.co.e4net.util.SeqGenerator", // 
	// 패키지 경로를 포함해야함 
	//IdentifierGenerator 인터페이스를 구현한 클래스 이름. 전체 패키지를 포함한 클래스 이름을 적어야 합니다.       
	       parameters = @Parameter( // Configurable 인터페이스 구현 클래스에 넘겨줄 파라미터 설정
	        name = SeqGenerator.SEQ_GENERATOR_PARAM_KEY, // 파라미터의 키 이름. SeqGenerator 클래스에 선언해둔 상수를 사용
	       value = "1" // 위의 name modifier에 선언한 키에 넘겨줄 파라미터 값
	)
//	     parameters = @Parameter(name ="goodsNo", value = "goodsNo")
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOODS_NO_SEQ_GENERATOR") // jpa 넘버링전략이 아닌 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Column(nullable = true, name = "GOODS_NO", updatable = false, length = 15)
	private String goodsNo; //시퀀스 , auto_increment


	@ManyToOne
	@JoinColumn(referencedColumnName = "MERCHANT_SN", name = "MERCHANT_SN")
	private TbMerchantEntity tbMerchantEntity;
	
	
	@Column(name = "GOODS_NM")
	private String goodsNm;
	
	@Column(name = "GOODS_MODEL_NO")
	private String goodsModelNo;
	
	
	@Column(name = "GOODS_AMT")
	private Long goodsAmt;

	@Column(name = "GOODS_QTT")
	private Long goodsQtt;

	@Column(name = "GOODS_SELL_QTT")
	private Long goodsSellQtt;
	

	@Column(name = "GOODS_CLS_DT")
	private String goodsClsDt;
	

	@Column(name = "GOODS_SHOP_COST")
	private String goodsShopCost;
	
	@Column(name = "REAL_FILE_NM")
	private String realFileNm;

	@Column(name = "GOODS_IMG_PATH")
	private String goodsImgPath;
	

	@Column(name = "GOODS_DESC")
	private String goodsDesc;
	
	@Builder
	public TbGoodsEntity(
			String goodsNo, 
			TbMerchantEntity tbMerchantEntity,
			String goodsNm, 
			String goodsModelNo,
			Long goodsAmt,
			Long goodsQtt,
			Long goodsSellQtt,
			String goodsClsDt, 
			String goodsShopCost,
			String realFileNm, 
			String goodsImgPath, 
			String goodsDesc) {
		this.goodsNo = goodsNo;
		this.tbMerchantEntity = tbMerchantEntity;
		this.goodsNm = goodsNm;
		this.goodsModelNo = goodsModelNo;
		this.goodsAmt = goodsAmt;
		this.goodsQtt = goodsQtt;
		this.goodsSellQtt = goodsSellQtt;
		this.goodsClsDt = goodsClsDt;
		this.goodsShopCost = goodsShopCost;
		this.realFileNm = realFileNm;
		this.goodsImgPath = goodsImgPath;
		this.goodsDesc = goodsDesc;
	}
	
}
