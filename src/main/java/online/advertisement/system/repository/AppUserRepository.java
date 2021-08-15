package online.advertisement.system.repository;

import online.advertisement.system.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * repository for AppUser functionalities
 *
 */

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

//	public AppUser findByUsername(String username);

	public AppUser findByEmail(String email);

}