package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Category;
import com.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@RequestMapping(value = "/category/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Category> listCategories = service.listAll();
		model.addAttribute("listCategories", listCategories);
		return "categorylist";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("category", new Category());
		return "categoryadd";
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("category") Category category) {
		service.save(category);
		return "redirect:/admin/category/list";
	}

	@RequestMapping(value = "/category/edit/{id}")
	public String edit(@PathVariable long id, Model m) {
		Category category = service.get(id);
		m.addAttribute("category", category);
		return "categoryedit";
	}

	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.POST)
	public String editsave(@PathVariable long id, @ModelAttribute("category") Category category) {
		category.setId(id);
		service.save(category);
		return "redirect:/admin/category/list";
	}

	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/admin/category/list";
	}

}
