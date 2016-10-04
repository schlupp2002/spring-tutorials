package de.steve72.tutorials.mvcjparest.controller;

import de.steve72.tutorials.mvcjparest.model.City;
import de.steve72.tutorials.mvcjparest.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * JsonRestViewController - Handler-Methoden leiten auf eine jsonTemplate-View um
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

@Controller
@RequestMapping("/rest-view")
public class JsonRestViewController {

    private final CityRepository cityRepository;


    @Autowired
    public JsonRestViewController(CityRepository cityRepository) {

        this.cityRepository = cityRepository;
    }


    /**
     * Liefert eine einzelne Stadt anhand der Id als Json-Objekt
     *
     * @param id
     * @return
     */
    @RequestMapping("/city/id/{id}")
    public String getCityById(@PathVariable Long id, Model model) {

        model.addAttribute(cityRepository.findOne(id));

        return "jsonTemplate";
    }


    /**
     * Liefert eine List von Städten für Pagination
     *
     * @param page
     * @return
     */
    @RequestMapping("/city/page/{page}")
    public String getCityById(@PathVariable Integer page, Model model) {

        List<City> result = new ArrayList<>();

        for (City c : cityRepository.findAll(new PageRequest(page, 10)))
            result.add(c);

        model.addAttribute(result);

        return "jsonTemplate";
    }


    /**
     * Füttert das UI-Modell für eine jsonTemplate-View mit einer Liste von Städten,
     * die anhand des Namens gefunden worden sind.
     *
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/city/name/{name}")
    public String getCityByName(@PathVariable String name, Model model) {

        model.addAttribute(cityRepository.findByName(name));

        return "jsonTemplate";
    }
}