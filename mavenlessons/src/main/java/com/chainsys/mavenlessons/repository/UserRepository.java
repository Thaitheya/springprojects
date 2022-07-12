package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import com.chainsys.mavenlessons.entity.Passport;
import com.chainsys.mavenlessons.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
//	Passport findByPassportId(int id);
	List<User> findAll();
	@SuppressWarnings("unchecked")
	User save(User user);
	void deleteById(int id);
	@Query ("select u from User u where u.id=?1 ")
	User getUser(int uid); // this is example of JPQL @Query (value ="select * from users u where u.id=?1 ,nativeQuery = true) H
	User getUserNativeSQL (int uid); // Example of Native Query
	@Modifying
	@Query ("update User u set u.name=?2, u.city=?3 where u.id=?1")
	void modifyUser(int id, String name, String city);
	//@Param
	@Query("select u from User u where u.city = :newCity")
	List<User> getUsersFromCity(@Param("newCity") String city);
}