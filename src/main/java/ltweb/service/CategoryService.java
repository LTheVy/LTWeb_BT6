package ltweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ltweb.entitiy.Category;

public interface CategoryService {

	Page<Category> findByCategoryNameContaining(String name, Pageable pageable);

	List<Category> findByCategoryNameContaining(String name);

	List<Category> findAll();

	void deleteById(Integer id);

	Optional<Category> findById(Integer id);

	<S extends Category> S save(S entity);

	
}
