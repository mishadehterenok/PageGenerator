package by.mdhtrnk.pagegenerator.controller;

import by.mdhtrnk.pagegenerator.entity.PageEntity;
import by.mdhtrnk.pagegenerator.service.PageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FormController {

    private final PageEntityService pageEntityService;

    @Autowired
    public FormController(PageEntityService pageEntityService) {
        this.pageEntityService = pageEntityService;
    }

    @GetMapping("/form")
    public String showFormPage(Model model){
        PageEntity pageEntity = new PageEntity();
        model.addAttribute("pageEntity", pageEntity);
        return "form";
    }

    @PostMapping("/form")
    public String savePage(@ModelAttribute("pageEntity") PageEntity pageEntity){
        pageEntity.setPublished_at(LocalDateTime.now());
        pageEntityService.save(pageEntity);
        return "redirect:/page/" + pageEntity.getSlug();
    }
    @ExceptionHandler
    public String handleException(RuntimeException ex){
        return "redirect:/form";
    }
}
