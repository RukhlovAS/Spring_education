package ruhlov.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ruhlov.test.dao.PersonDao;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao){
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //получим одного человека по id и передадим на отображение
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }
}
