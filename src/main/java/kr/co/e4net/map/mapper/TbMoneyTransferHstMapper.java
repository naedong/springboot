package kr.co.e4net.map.mapper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.format.datetime.DateFormatter;

import kr.co.e4net.dto.TbMoneyTransferHstDto;
import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembLogin.TbMembLoginBuilder;
import kr.co.e4net.dto.TbMembMoneyDto.TbMembMoneyCharge;
import kr.co.e4net.dto.TbMoneyTransferHstDto.TbMembMoneyBoard;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity.TbMoneyTransferHstEntityBuilder;
import kr.co.e4net.entity.TbMembLoginHstEntity.TbMembLoginHstEntityBuilder;
import kr.co.e4net.enums.MembCls;
import kr.co.e4net.enums.MembStatusCd;
import kr.co.e4net.enums.PayMeanCd;
import kr.co.e4net.enums.TransferTyCd;
import kr.co.e4net.map.BaseMapper;

@Mapper(componentModel = "spring")
public interface TbMoneyTransferHstMapper extends BaseMapper<TbMembMoneyCharge, TbMoneyTransferHstEntity> {
	TbMoneyTransferHstMapper INSTANCE = Mappers.getMapper(TbMoneyTransferHstMapper.class);
	
	
	String dateformatter(Timestamp frstRegistDt);
	
	
	default  List<TbMembMoneyBoard> listtoListEntity(List<TbMoneyTransferHstEntity> listEntity){
		
		 List<TbMoneyTransferHstDto.TbMembMoneyBoard> list = new ArrayList<TbMoneyTransferHstDto.TbMembMoneyBoard>( listEntity.size() );
	        for ( TbMoneyTransferHstEntity tbMoneyTransferHstEntity : listEntity ) {
//	        	String pattern = "yyyy.MM.dd";
//	        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//	        	
	        	SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
	        	
	        	
	        	TbMembMoneyBoard tbMembMoneyBoard =	
	        	TbMembMoneyBoard.builder().membSn(tbMoneyTransferHstEntity.getTbMembEntity().getMembSn())
	        	.moneyTransferHstSn(tbMoneyTransferHstEntity.getMoneyTransferHstSn())
//	        	.payMeanCd(tbMoneyTransferHstEntity.getPayMeanCD())
	        	.payTransferNo(tbMoneyTransferHstEntity.getPayTransferNo())
	        	.TransferAmt(Long.valueOf(tbMoneyTransferHstEntity.getTransferAmt()))
	        	.transferTyCd(tbMoneyTransferHstEntity.getTransferTyCd().name())
	        	.frstRegistDt(format.format(tbMoneyTransferHstEntity.getFrstRegistDt()))
	        	.lastRegistDt(format.format(tbMoneyTransferHstEntity.getLastRegistDt()))
	        	.build();
	        	
	 
	            list.add( tbMembMoneyBoard);
	        }
		return list;
	}
	
	
	


	default TbMoneyTransferHstEntity toEntity(TbMembMoneyCharge tbMembMoneyCharge) {
		
		if(tbMembMoneyCharge == null) {
			return null;
		}
		TbMoneyTransferHstEntityBuilder tbMoneyTransferHstEntity = TbMoneyTransferHstEntity.builder();
		tbMoneyTransferHstEntity
		.transferAmt(tbMembMoneyCharge.getTransferAmt())
		.payMeanCd(PayMeanCd.valueOf(tbMembMoneyCharge.getPayMeanCd().name()))
		.payTransferNo(tbMembMoneyCharge.getPayTransferNo())
		.transferTyCd(TransferTyCd.valueOf(tbMembMoneyCharge.getTransferTyCd().name()));
		return tbMoneyTransferHstEntity.build();
	}

	default PayMeanCd map(Integer value) {
		return PayMeanCd.valueOf(value);
	}
	
	default Integer map(PayMeanCd payMeanCd) {
		return payMeanCd.getValue();
	}
	

	
	default TransferTyCd hashmap(Integer value) {
		return TransferTyCd.valueOf(value);
	}
	
	default Integer hashmap(TransferTyCd transferTyCd) {
		return transferTyCd.getValue();
	}
	
}
