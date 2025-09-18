package ltweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ltweb.entitiy.Video;
import ltweb.repository.VideoRepository;
import ltweb.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoRepository videoRepository;

	@Override
	public List<Video> findByTitleContaining(String title) {
		return videoRepository.findByTitleContaining(title);
	}

	@Override
	public Page<Video> findByTitleContaining(String title, Pageable pageable) {
		return videoRepository.findByTitleContaining(title, pageable);
	}

	@Override
	public <S extends Video> S save(S entity) {
		return videoRepository.save(entity);
	}

	@Override
	public List<Video> findAll() {
		return videoRepository.findAll();
	}

	@Override
	public Optional<Video> findById(Integer id) {
		return videoRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		videoRepository.deleteById(id);
	}
	
}
