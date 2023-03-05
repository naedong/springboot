package kr.co.e4net.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.e4net.entity.TbMerchantEntity;
import kr.co.e4net.entity.TbMerchantEntity.TbMerchantEntityBuilder;

@Repository
public interface TbMerchantRepository extends JpaRepository<TbMerchantEntity, Long>
,
TbMerchantRepositoryCustom
{


}
