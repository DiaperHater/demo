package val.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import val.example.demo.model.Author;
import val.example.demo.repo.AuthorRepo;

import java.util.List;

@Controller
public class IndexController {

    private AuthorRepo authorRepo;

    @Autowired
    public IndexController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/index")
    String index(Model model){

        model.addAttribute("authors", authorRepo.findAll());

        return "index";
    }
}
