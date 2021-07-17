package online.advertisement.system.repository;

import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.AppUser;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminUserRepository extends JpaRepository<AppUser, Integer> {

//	View user list
	@Modifying
	@Transactional
	@Query( value = "SELECT * FROM user_adv u WHERE u.username = 'username' ", nativeQuery = true)
	public abstract List<AppUser> viewUserList();
	
//	Delete user by id
	@Modifying
	@Transactional
	@Query("DELETE from AppUser a WHERE a.userid = :userid")
	public abstract void deleteById(int userid);
}