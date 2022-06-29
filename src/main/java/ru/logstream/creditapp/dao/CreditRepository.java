package ru.logstream.creditapp.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.logstream.creditapp.models.entities.CreditEntity;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public interface CreditRepository extends CrudRepository<CreditEntity, Long> {
    Collection<CreditEntity> getCreditEntitiesByUserId(Long userId);

    Boolean existsByUserId(@Param("userId") Long userId);

    Integer countAllByUserIdAndIsPaidFalse(@Param("userId") Long userId);
}
