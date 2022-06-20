package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return iCategoryRepository.findAll();
    }

//    @GetMapping("")
//    public String list(Model model, @PageableDefault (size = 2) Pageable pageable, @RequestParam(name = "author") Optional<String> author,
//                       @RequestParam(name = "categoryID") Optional<Integer> categoryID){
//        boolean authorNotNull = author.isPresent() && !author.get().equals("");
//        boolean categoryNotNull = categoryID.isPresent();
//
//        if (authorNotNull)
//            model.addAttribute("author",author.get());
//
//        if (categoryNotNull)
//            model.addAttribute("categoryID",categoryID.get());
//
//        Page<Blog> blogs = null;
//
//        if (!authorNotNull && !categoryNotNull)
//            blogs = iBlogService.findAll(pageable);
//
//        if (authorNotNull && !categoryNotNull)
//            blogs = iBlogService.findAllByAuthor(author.get(),pageable);
//
//        if (!authorNotNull && categoryNotNull)
//            blogs = iBlogService.findAllByCategory_Id(categoryID.get(),pageable);
//
//        if (authorNotNull && categoryNotNull)
//            blogs = iBlogService.findAllByAuthorAndCategory_Id(author.get(),categoryID.get(),pageable);
//
//        model.addAttribute("blogs",blogs);
//
//        return "list";
//    }

    @GetMapping("")
    public String getList(Model model, @PageableDefault(size = 2) Pageable pageable){
        Page<Blog> blogs = iBlogService.findAll(pageable);
        model.addAttribute("blogs", blogs);
        return "list";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        Optional<Blog> blog = this.iBlogService.findByID(id);

        if (blog.isPresent()) {
            model.addAttribute("blog",blog.get());
            return "delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("msg","Delete blog successfully!");

        return "redirect:/blog";
    }

    @GetMapping(value = "/create")
    public String addNew(Model model) {
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes) {

        this.iBlogService.save(blog);

        redirectAttributes.addFlashAttribute("msg","Add new blog successfully!");

        return "redirect:/blog";
    }

}
