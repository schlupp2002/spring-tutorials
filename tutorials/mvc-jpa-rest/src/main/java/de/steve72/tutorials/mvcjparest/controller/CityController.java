package de.steve72.tutorials.mvcjparest.controller;

import de.steve72.tutorials.mvcjparest.model.City;
import de.steve72.tutorials.mvcjparest.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * CityController
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

@Controller
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;


    @Autowired
    public CityController(CityRepository cityRepository) {

        this.cityRepository = cityRepository;
    }


    @RequestMapping("/{id}")
    public String showCity(@PathVariable Long id, Model model) {

        City city = cityRepository.findOne(id);

        model.addAttribute("city", city);

        return "city-details";
    }
}
