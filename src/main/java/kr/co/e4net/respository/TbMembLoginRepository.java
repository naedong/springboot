package kr.co.e4net.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.e4net.entity.TbMembLoginHstEntity;
import kr.co.e4net.entity.TbMembMoneyEntity;

@Repository
public interface TbMembLoginRepository  extends JpaRepository<TbMembLoginHstEntity, Long>

{

}
