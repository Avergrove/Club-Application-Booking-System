package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.model.Category;
import sg.nus.iss.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CategoryRepository crepos;

	@Override
	public Category CreateCategory(Category ca) {
		return crepos.saveAndFlush(ca);
	}

	@Override
	public ArrayList<Category> findAllCategory() {
		ArrayList<Category> cl = (ArrayList<Category>) crepos.findAll();
		return cl;
	}
	
	
   @Override
	public Category findCategoryById(int s) {
		return crepos.findCategoryById(s);
	}
   
   
	
	@Override
	public Category changeCategory(Category c) {
		return crepos.saveAndFlush(c);
	}
	
	
}
