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
public interface UserRepository extends JpaRepository<AppUser, Integer> {

	//List<Advertise> findByName(String advertisetitle);

	//public abstract List<Advertise> findByName(String advertisetitle);

//	public abstract List<User> registerUser(String users);
}

