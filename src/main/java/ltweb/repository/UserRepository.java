package ltweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ltweb.entitiy.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsernameContaining(String username);
	Page<User> findByUsernameContaining(String username, Pageable pageable);
}
