package kr.co.e4net.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.e4net.entity.TbMembEntity;

@Repository
public interface TbMembRepository extends JpaRepository<TbMembEntity, Long>
, TbMembRepositoryCustom
 {
	void findByMembId(String id);
}
