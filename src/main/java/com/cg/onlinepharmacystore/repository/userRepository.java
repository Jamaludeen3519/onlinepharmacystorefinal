package com.cg.onlinepharmacystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.cg.onlinepharmacystore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
			
		//list all users under a user_Id
		//select * from User where user_Id= ?
		public Optional<User> findByUserId(Long userId);
		
		//select * from User where user_name = ?
		public Optional<User> findByUserNameOrEmail(String userName,String email);


}
