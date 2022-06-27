package ru.logstream.creditapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.logstream.creditapp.entities.CreditEntity;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public interface CreditRepository extends CrudRepository<CreditEntity, Long> {
    Collection<CreditEntity> getCreditEntitiesByUserId(Long userId);
}
