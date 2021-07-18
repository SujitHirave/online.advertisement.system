package online.advertisement.system.repository;

import online.advertisement.system.model.AppUser;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public AppUser findByUsername(String username);

//	@Modifying
//	@Transactional
////	@Query(value = "SELECT * FROM user_adv WHERE username,password", nativeQuery = true)
////	@Query(value = "SELECT username,password FROM user_adv ;", nativeQuery = true)
//	@Query(value = "SELECT p FROM user_adv WHERE p.username=:usename , p.password=:password", nativeQuery = true)
//	public abstract AppUser findByUsernameAndPassword(String username, String password);

}