package sg.nus.iss.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CategoryRepository crepos;

}
