package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.CategoryForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Sportsman;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/category")
public class CategoryWEBController {
    @Autowired
    CategoryServiceImpl service;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("categories", service.getAll());
        return "categoryList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Category> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("categories", list);
        return "categoryList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Category> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("categories", list);
        return "categoryList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Category> list = service.sortByMark();
        model.addAttribute("categories", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "categoryList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Category> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("categories", list);
        return "categoryList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("categories", service.getAll());
        return "categoryList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CategoryForm categoryForm = new CategoryForm();
        model.addAttribute("categoryForm", categoryForm);
        return "categoryAdd";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("categoryForm") CategoryForm categoryForm) {
        Category category = new Category();
        category.setCategory_name(categoryForm.getCategory_name());
        category.setCategory_mark(Integer.parseInt(categoryForm.getCategory_mark()));
        category.setMore_than(Integer.parseInt(categoryForm.getMore_than()));
        service.save(category);
        model.addAttribute("categories", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/category/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Category category = service.get(id);
        CategoryForm categoryForm = new CategoryForm();
        categoryForm.setCategory_name(category.getCategory_name());
        categoryForm.setCategory_mark(category.getCategory_mark().toString());
        categoryForm.setMore_than(category.getMore_than().toString());
        model.addAttribute("categoryForm", categoryForm);
        return "categoryAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("categoryForm") CategoryForm categoryForm) {
        Category category = new Category();
        category.setId(id);
        category.setCategory_name(categoryForm.getCategory_name());
        category.setCategory_mark(Integer.parseInt(categoryForm.getCategory_mark()));
        category.setMore_than(Integer.parseInt(categoryForm.getMore_than()));
        service.save(category);
        model.addAttribute("categories", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/category/list";
    }

}
