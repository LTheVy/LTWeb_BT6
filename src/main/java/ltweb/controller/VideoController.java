package ltweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ltweb.entitiy.Video;
import ltweb.service.VideoService;

@Controller
@RequestMapping(path = {"admin/videos"})
public class VideoController {
	@Autowired
	VideoService videoService;

	@RequestMapping("")
	public String list(ModelMap model) {
		model.addAttribute("videos", videoService.findAll());
		return "admin/videos/list";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("video", new Video());
		return "admin/videos/add";
	}

	@PostMapping("add")
	public String add(@ModelAttribute("video") Video video) {
		videoService.save(video);
		return "redirect:/admin/videos";
	}
	
	@GetMapping("edit/{id}")
	public String edit(ModelMap model, @PathVariable("id") int videoId) {
		model.addAttribute("video", videoService.findById(videoId).get());
		return "admin/videos/edit";
	}
	
	@PostMapping("edit")
	public String edit(@ModelAttribute("video") Video video) {
		videoService.save(video);
		return "redirect:/admin/videos";
	}
	
	
	@GetMapping("delete/{videoId}")
	public String delete(@PathVariable("videoId") int videoId) {
		videoService.deleteById(videoId);
		return "redirect:/admin/videos";
	}

	@RequestMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<Video> list = null;

		if (StringUtils.hasText(name)) {
			list = videoService.findByTitleContaining(name);
		} else {
			list = videoService.findAll();
		}
		model.addAttribute("videos", list);
		return "admin/videos/list";
	}
}
