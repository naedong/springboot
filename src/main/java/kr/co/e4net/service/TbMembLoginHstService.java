package kr.co.e4net.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMembLoginHstEntity;
import kr.co.e4net.entity.TbMembMoneyEntity;
import kr.co.e4net.map.mapper.TbMembLoginMapper;
import kr.co.e4net.map.mapper.TbMembMoneyMapper;
import kr.co.e4net.respository.TbMembLoginRepository;
import kr.co.e4net.respository.TbMembMoneyRepository;
import kr.co.e4net.respository.TbMembRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TbMembLoginHstService {
	
	private final TbMembLoginRepository tbMembLoginRepository;
	private final TbMembLoginMapper tbMembLoginHstMapper;
	
	@Transactional
    public boolean LoginCheck(TbMembLogin tbMembLogin, TbMembEntity MembSn) {
		if(tbMembLogin == null) { System.out.println("리턴 null 장소"); return false;	}
		
		TbMembLoginHstEntity tbMembLoginHstEntity = TbMembLoginHstEntity.builder().connectIp(tbMembLogin.getConnectIp()).tbMembEntities(MembSn).build();
//		tbMembLoginRepository.save(tbMembLoginHstEntity)

		return tbMembLoginRepository.save(tbMembLoginHstEntity) != null;
//		return tbMembLoginRepository.save(tbMembMoneyEntity) != null;	
	}
	
	
	

}
