package online.advertisement.system.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import online.advertisement.system.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
///repo