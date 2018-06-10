package sg.nus.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
