package kr.co.e4net.respository;

import java.util.List;


import com.querydsl.core.types.dsl.BooleanExpression;

import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.dto.TbMerchantDto.TbMerchantDefault;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembMoneyEntity;



public interface TbMembRepositoryCustom {
	// 테스트용
	List<TbMembEntity> getByMembId(TbMembLogin tbMembDto);
	
	BooleanExpression selectMeId(String id);
	
	BooleanExpression selectMePwd(String pwd);

	BooleanExpression selectMeEmail(String email);
	
	TbMembEntity insertId(TbMembEntity membsn);
	
	TbMembEntity getMemb(Long membSn);
	
	BooleanExpression noOffSet(Long tbMembEntity);
	

	BooleanExpression checkSn(Long membSn);
	
	TbMembEntity checkId(String id);
	
	TbMembSign webLogin(TbMembLogin tbMembLogin);
	
	BooleanExpression checkIdPwd(TbMembLogin tbMembLogin);
	
	boolean checkId(Long id);

	BooleanExpression selectMeSn(TbMembEntity membsn);
	
	TbMembEntity masterShop(List<TbMerchantDefault> tbMerchantDefault);
	
    //NamedQuery 확인용
//    TbMembEntity findByMembId(Long membSn);

    //QueryDSL 처리용
//	TbMembEntity test();
//	TbMembEntity insertUser(TbMembEntity tbMembEntity);

}
