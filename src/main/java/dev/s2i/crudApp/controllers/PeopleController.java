package dev.s2i.crudApp.controllers;


import dev.s2i.crudApp.dao.PersonDAO;
import dev.s2i.crudApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
//@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;


    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    @GetMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", personDAO.getPeople());
        return "people/index";
    }

    @GetMapping("/person")//show person by Id
    public String show(@RequestParam (value = "id")int id, Model model) {
        model.addAttribute("person", personDAO.getPersonById(id));
        return "people/show";
    }

    @GetMapping("/person/new")
    public String newPerson(Model model, Person person) {
        return "people/new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "people/new";
        }
        personDAO.addPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/person/edit")
    public String edit(@RequestParam (value = "id")int id, Model model) {
        model.addAttribute("person", personDAO.getPersonById(id));
        return "people/edit";
    }

    @PatchMapping( "/people")
//    @RequestMapping(path = "/people", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult result,
                         @RequestParam (value = "id")int id) {
        if (result.hasErrors()) {
            return "people/edit";
        }
        personDAO.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/people")
    public String delete(@RequestParam (value = "id")int id) {
        personDAO.deletePerson(id);
        return "redirect:/people";
    }


}
