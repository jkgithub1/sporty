package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Category;
import com.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService {

	 @Autowired	
	private CategoryRepo repo;
	
	public List<Category> listAll() {
	        return repo.findAll();
	}
	public void save(Category category) {
        repo.save(category);
    }
     
    public Category get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
	
}
