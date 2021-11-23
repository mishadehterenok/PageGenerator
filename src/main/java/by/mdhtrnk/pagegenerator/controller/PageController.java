package by.mdhtrnk.pagegenerator.controller;

import by.mdhtrnk.pagegenerator.entity.PageEntity;
import by.mdhtrnk.pagegenerator.service.PageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    private final PageEntityService pageEntityService;

    @Autowired
    public PageController(PageEntityService pageEntityService) {
        this.pageEntityService = pageEntityService;
    }

    @GetMapping("/page/{slug}")
    public String showPage(@PathVariable("slug") String slug, Model model){
        PageEntity pageEntity = pageEntityService.findBySlug(slug);
        model.addAttribute("pageEntity", pageEntity);
        return "page";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Long id, Model model){
        PageEntity pageEntity = pageEntityService.findById(id);
        model.addAttribute("pageEntity", pageEntity);
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") Long id){
        pageEntityService.deleteById(id);
        return "main";
    }
}
