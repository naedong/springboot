package kr.co.e4net.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;

@Getter
@Entity
@Table(name = "TB_MEMB_LOGIN_HST")
@SequenceGenerator(
		  name = "LOGIN_SN_SEQ_GENERATOR", 
		  sequenceName = "LOGIN_SN_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbMembLoginHstEntity extends TableData{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGIN_SN_SEQ_GENERATOR") // jpa 넘버링전략이 아닌 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Column(nullable = false, name = "LOGIN_SN")
	private Long loginSn; //시퀀스 , auto_increment

	@Column(nullable = true, name = "CONNECT_IP")
	private String connectIp; //시퀀스 , auto_increment
	
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMB_SN",nullable = false,referencedColumnName = "MEMB_SN")
	private TbMembEntity tbMembEntity;
	
	
//	private Long membSn;
	

	
	@Builder
	public TbMembLoginHstEntity( Long loginSn, 
			String connectIp,
			TbMembEntity tbMembEntities
			) {
		this.loginSn = loginSn;
		this.connectIp = connectIp;
		this.tbMembEntity = tbMembEntities;

	}
}
