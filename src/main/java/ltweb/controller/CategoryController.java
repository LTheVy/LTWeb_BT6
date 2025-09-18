package ltweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ltweb.entitiy.Category;
import ltweb.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(path = "admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("")
	public String list(ModelMap model) {
		model.addAttribute("categories", categoryService.findAll());
		return "admin/categories/list";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("category", new Category());
		return "admin/categories/add";
	}

	@PostMapping("add")
	public String add(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("edit/{id}")
	public String edit(ModelMap model, @PathVariable("id") int categoryId) {
		model.addAttribute("category", categoryService.findById(categoryId).get());
		return "admin/categories/edit";
	}
	
	@PostMapping("edit")
	public String edit(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("delete/{categoryId}")
	public String delete(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteById(categoryId);
		return "redirect:/admin/categories";
	}

	@RequestMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<Category> list = null;

		if (StringUtils.hasText(name)) {
			list = categoryService.findByCategoryNameContaining(name);
		} else {
			list = categoryService.findAll();
		}
		model.addAttribute("categories", list);
		return "admin/categories/list";
	}

}
