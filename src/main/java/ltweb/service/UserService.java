package ltweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ltweb.entitiy.User;

public interface UserService {

	void deleteById(Integer id);

	Optional<User> findById(Integer id);

	List<User> findAll();

	<S extends User> S save(S entity);

	Page<User> findByUsernameContaining(String username, Pageable pageable);

	List<User> findByUsernameContaining(String username);
	
}
