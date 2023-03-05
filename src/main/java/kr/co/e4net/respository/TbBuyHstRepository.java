package kr.co.e4net.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.e4net.entity.TbBuyHstEntity;
import kr.co.e4net.entity.TbGoodsEntity;

@Repository
public interface TbBuyHstRepository extends JpaRepository<TbBuyHstEntity, Long> 
, 
TbBuyHstRepositoryCustom
 {

}
