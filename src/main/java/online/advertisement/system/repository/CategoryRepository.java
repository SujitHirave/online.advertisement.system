package online.advertisement.system.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.advertisement.system.model.Category;

/**
 * 
 * repository for Category functionalities
 *
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findBycatid(int catid);

}
