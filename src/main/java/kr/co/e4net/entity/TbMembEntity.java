package kr.co.e4net.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import kr.co.e4net.enums.MembCls;
import kr.co.e4net.enums.MembStatusCd;
//import kr.co.e4net.enums.converter.MembClsTypeConverter;
//import kr.co.e4net.enums.converter.MembStatusCdTypeConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;

@Getter 
@Entity
@Table(name = "TB_MEMB", 
		uniqueConstraints = {
//				@UniqueConstraint(columnNames = "membSn")
		}
		)
@SequenceGenerator(
		  name = "MEMB_SN_SEQ_GENERATOR", 
		  sequenceName = "MEMB_SN_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@NamedQuery
(
		name = "TbMembEntity.findByMembId",
		query = "select membId from TbMembEntity m where m.membId = :membId"
		)
// insert 하는 네임드 쿼리 자꾸 길어지고 많아져서 지웁니다.
//@NamedQuery(
//		name="TbMembEntity.findById",
//		query="Insert Into TbMembEntity (MEMB_SN, MEME_CLS,"
//				+ "MEMB_ID,  MOBILE_NO, MEMB_NM, MOBILE_NO,"
//				+ "EMAIL_ADDR, ZIP_CD, ZIP_ADDR, DETAIL_ADDR) "
//				+ "SELECT 1, ?, ?, ?, "
//				+ "?, ?, 'email@email.net', 'cd', '00000', '강남'"
//				+ "from TbMembEntity"
//)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class TbMembEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMB_SN_SEQ_GENERATOR") // jpa 넘버링전략이 아닌 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Column(nullable = true, name = "MEMB_SN")
	private Long membSn;
	
	@Column(name = "MEMB_ID")
	private String membId;
	

	@OneToOne(mappedBy = "tbMembEntity", cascade = CascadeType.PERSIST) // 애가 저장이 되면 영속성을 뿌림 ALL은 지워지거나 모든걸 방지
	private TbMembMoneyEntity tbMembMoneyentity;

	// 회원 ID ,, length == 10이런식으로 차후에 한다.
//	@Column(nullable = true, length = 20)
//	private String membCls; //ROLE_ADMIN:어드민, ROLE_SELLER:판매자, ROLE_USER: 사용자
// 	
	
	@Enumerated(EnumType.STRING)
//	@Convert(converter = MembClsTypeConverter.class)
	@Column(name = "MEMB_CLS", length = 20)
	private MembCls membCls;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;

	@Enumerated(EnumType.STRING)
//	@Convert(converter = MembStatusCdTypeConverter.class)
	@Column(name = "MEMB_STATUSCD",length = 10)
	private MembStatusCd membStatusCd;

	
	
	
	@Column(name = "MEMB_PWD",nullable = true, length = 20)
	private String membPwd;
	
	@Column(name = "MEMB_NM",nullable = true, length = 100)
	private String membNm;
	
//
//	@Column( length = 150)
//	private String detailAddr;

	//@Column(length = 14)
	@CreatedDate
	@LastModifiedDate
	@Column(name = "LAST_LOGIN_DTM")
	private LocalDateTime lastLoginDtm;
	
//    
//    private LocalDateTime modifiedDateDtm;
//	
	
	
	@Embedded
	private PublicData publicData;
//
//	public static TbMembEntity createTbMembEntity(TbMembEntity tbMembEntity) {
//		return TbMembEntity.builder()
//				.membNm(tbMembEntity.getMembNm())
//				.membPwd(tbMembEntity.getMembPwd())
//				.membId(tbMembEntity.getMembId())
//				.membSn(tbMembEntity.getMembSn())
//				.membStatusCd(tbMembEntity.getMembStatusCd())
//				.lastLoginDtm(tbMembEntity.getLastLoginDtm())
//				.mobileNo(tbMembEntity.getMobileNo())
//				.membCls(tbMembEntity.getMembCls())
//				.tbMembMoneyEntity(tbMembEntity.getTbMembMoneyentity())
//				.build();
//	}

	
	public void setTbMembMoneyEntity(TbMembMoneyEntity tbMembMoneyEntity) {
		this.tbMembMoneyentity = tbMembMoneyEntity;
	}

//
	@Builder(builderMethodName = "of")
	public TbMembEntity(@Default Long membSn,
						TbMembMoneyEntity tbMembMoneyEntity,
						MembCls membCls,
						MembStatusCd membStatusCd,
						String membId,
						String membPwd,
						String mobileNo,
						String membNm,
						LocalDateTime lastLoginDtm,
						PublicData publicData
	) {
		this.mobileNo = mobileNo;
		this.membSn = membSn;
		this.tbMembMoneyentity = tbMembMoneyEntity;
		this.membCls = membCls;
		this.membStatusCd = membStatusCd;
		this.membId = membId;
		this.membNm = membNm;
		this.membPwd = membPwd;
		this.lastLoginDtm = lastLoginDtm;
		this.publicData = publicData;

	}
	
	
	
	
	
}
