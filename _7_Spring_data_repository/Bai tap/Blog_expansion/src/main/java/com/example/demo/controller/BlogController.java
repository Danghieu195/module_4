package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("")
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam(name = "author") Optional<String> author,
                       @RequestParam(name = "categoryID") Optional<Integer> categoryID){
        boolean authorNotNull = author.isPresent() && !author.get().equals("");
        boolean categoryNotNull = categoryID.isPresent();

        if (authorNotNull)
            model.addAttribute("author",author.get());

        if (categoryNotNull)
            model.addAttribute("categoryID",categoryID.get());

        Page<Blog> blogs = null;

        if (!authorNotNull && !categoryNotNull)
            blogs = iBlogService.findAll(pageable);

        if (authorNotNull && !categoryNotNull)
            blogs = iBlogService.findAllByAuthor(author.get(),pageable);

        if (!authorNotNull && categoryNotNull)
            blogs = iBlogService.findAllByCategory_Id(categoryID.get(),pageable);

        if (authorNotNull && categoryNotNull)
            blogs = iBlogService.findAllByAuthorAndCategory_Id(author.get(),categoryID.get(),pageable);

        model.addAttribute("blogs",blogs);

        return "list";
    }

}
