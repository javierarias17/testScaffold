package co.com.pragma.jpa;

import co.com.pragma.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;
import java.util.Optional;

public interface JPARepository extends CrudRepository<UserEntity, BigInteger>, QueryByExampleExecutor<UserEntity> {

    Optional<UserEntity> findByIdNumber(Long idNumber);


}
