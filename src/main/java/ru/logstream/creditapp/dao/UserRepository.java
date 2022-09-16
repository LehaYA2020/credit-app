package ru.logstream.creditapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.logstream.creditapp.models.entities.UserEntity;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query(nativeQuery = true,
            value = "SELECT EXTRACT(" +
                    "YEAR from (" +
                    "SELECT age(now(), birthday) " +
                    "from users " +
                    "where id= :userId));"
    )
    Integer getAge(@Param("userId") Long userId);
}
