package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Category;

public interface CategoryService {
	
Category CreateCategory(Category ca);
	
	ArrayList<Category> findAllCategory();

}
