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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> findAllCategory() {
		ArrayList<Category> cl = (ArrayList<Category>) crepos.findAll();
		return cl;
	}

}
