package com.sunjoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunjoy.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Modifying
	@Transactional
	@Query("update UserEntity user set user.nickname=:qNickname, user.firstName=:qFirstName, user.lastName=:qLastName, user.password=:qPassword where"
			+ " user.id=:qId")
	public void updateUser(@Param("qNickname") String nickname,@Param("qFirstName") String firstName,
			@Param("qLastName") String lastName, @Param("qPassword") String password,@Param("qId") Long id);
	
}
