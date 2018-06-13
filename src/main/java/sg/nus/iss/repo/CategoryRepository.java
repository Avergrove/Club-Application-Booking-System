package sg.nus.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query("SELECT c FROM Category c where c.categoryId = :id")
	Category findCategoryById(@Param("id") Integer id);



}
