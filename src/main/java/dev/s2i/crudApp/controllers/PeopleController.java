package dev.s2i.crudApp.controllers;


import dev.s2i.crudApp.dao.PersonDAO;
import dev.s2i.crudApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.people());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable ("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPersonById(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model, Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.addPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable ("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPersonById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable ("id") int id) {
        personDAO.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") int id) {
        personDAO.deletePerson(id);
        return "redirect:/people";
    }


}
