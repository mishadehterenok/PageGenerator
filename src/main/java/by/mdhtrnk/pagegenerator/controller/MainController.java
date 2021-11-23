package by.mdhtrnk.pagegenerator.controller;

import by.mdhtrnk.pagegenerator.entity.PageEntity;
import by.mdhtrnk.pagegenerator.service.PageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final PageEntityService pageEntityService;

    @Autowired
    public MainController(PageEntityService pageEntityService) {
        this.pageEntityService = pageEntityService;
    }

    @GetMapping("/main")
    public String showPage(Model model){
        List<PageEntity> allPages = pageEntityService.findAll();
        model.addAttribute("allPages", allPages);
        return "main";
    }

}
