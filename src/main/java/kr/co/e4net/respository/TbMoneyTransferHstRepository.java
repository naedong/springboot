package kr.co.e4net.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.entity.TbMoneyTransferHstEntity;

@Repository
public interface TbMoneyTransferHstRepository  extends JpaRepository<TbMoneyTransferHstEntity, Long>, TbMoneyTransferHstRepositoryCustom
{
	
	
	
	
}
