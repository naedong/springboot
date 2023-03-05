package kr.co.e4net.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//공통 문항



@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public abstract class TableData {

//		@CreatedDate
//	    private LocalDateTime registerTime;
//	    @LastModifiedDate
//	    private LocalDateTime modifyTime;
//
//
//	public String toStringDateTime(LocalDateTime localDateTime) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		return Optional.ofNullable(localDateTime)
//				.map(formatter::format)
//				.orElse("");
//	}
	// 등록회원번호 
	// 등록일시 date 타입으로
	// 수정회원번호
	// 수정일시 date 타입으로 공통문항
	
	@Column(name = "FRST_REGIST_MEMB_SN", length = 10)
	private  Long frstRegistMembSn;
	
	
	@CreatedDate // 객체가 생성되면 자동으로 생성이된다.
	@Column(name = "FRST_REGIST_DT")
	private  Timestamp frstRegistDt;
	
	
	@Column(name = "LAST_REGIST_MEMB_SN", length = 10, updatable = true, nullable = true)
	private  Long lastRegistMembSn;
	
	@LastModifiedDate // 객체가 수정되면 자동으로 수정이 된다.
	@Column(name = "LAST_REGIST_DT", updatable = true, nullable = true)
	private  Timestamp lastRegistDt;
	
	
	@Column(name = "USE_YN")
	private char useYn;
	
	protected TableData(Long frstRegistMembSn, Long lastRegistMembSn) {
		this.frstRegistMembSn = frstRegistMembSn;
		this.lastRegistMembSn = lastRegistMembSn;
	}
	
	
}
