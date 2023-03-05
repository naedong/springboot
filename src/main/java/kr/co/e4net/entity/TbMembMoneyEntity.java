package kr.co.e4net.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.co.e4net.enums.MembCls;
import kr.co.e4net.enums.MembStatusCd;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
@Getter@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="TB_MEMB_MONEY")
@SequenceGenerator(
		name="seq_memb_money_generator",
		sequenceName = "seq_money_hst", 
		initialValue = 1,
		allocationSize = 1
		)

public class TbMembMoneyEntity extends TableData implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_memb_money_generator")
	@Column(name = "money_sn", length = 10)
	private Long moneySn;
	
	@OneToOne(fetch = FetchType.LAZY)  
	@JoinColumn(name = "memb_sn", referencedColumnName = "memb_sn") 
	@JsonBackReference
	private TbMembEntity tbMembEntity;

	
	
	@Column(columnDefinition = "int8 default 0")
	private int moneyBlce;


	
	
	@Builder
	public TbMembMoneyEntity (Long  moneySn, int moneyBlce, TbMembEntity tbMembEntity)
	{
		
		this.moneySn = moneySn;
		this.moneyBlce = moneyBlce;
		this.tbMembEntity = tbMembEntity;
		
//		this.tbMembEntity.setMoneyEntity(this);
		// this.변수명.add(this); 양방향일때 가능 단방향일때 save를 따로따로 만들어야함
	}
	
//	public static TbMembMoneyEntity createMoneyEntity(TbMembEntity TbMembEntity) {
//		return TbMembMoneyEntity.builder()
//				.tbMembEntity(TbMembEntity)
//				.build();
//	}	
}
