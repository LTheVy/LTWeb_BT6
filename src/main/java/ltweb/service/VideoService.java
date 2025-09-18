package ltweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ltweb.entitiy.Video;

public interface VideoService {

	void deleteById(Integer id);

	Optional<Video> findById(Integer id);

	List<Video> findAll();

	<S extends Video> S save(S entity);

	Page<Video> findByTitleContaining(String title, Pageable pageable);

	List<Video> findByTitleContaining(String title);

}
