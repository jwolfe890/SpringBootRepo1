package mysql2jdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mysql2jdbc.jdbcclasses.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findUserByEmail(String email);
	
}
