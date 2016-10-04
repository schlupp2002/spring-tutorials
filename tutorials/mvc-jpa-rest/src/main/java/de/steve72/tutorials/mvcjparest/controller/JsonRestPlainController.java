package de.steve72.tutorials.mvcjparest.controller;

import de.steve72.tutorials.mvcjparest.model.City;
import de.steve72.tutorials.mvcjparest.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * JsonRestPlainController - alle Handler-Methoden liefern direkt den ResponseBody
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

@RestController
@RequestMapping("/rest-plain")
public class JsonRestPlainController {

    private final CityRepository cityRepository;


    @Autowired
    public JsonRestPlainController(CityRepository cityRepository) {

        this.cityRepository = cityRepository;
    }


    /**
     * Liefert eine einzelne Stadt anhand der Id als Json-Objekt
     *
     * @param id
     * @return
     */
    @RequestMapping("/city/id/{id}")
    public City getCityById(@PathVariable Long id) {

        City result = cityRepository.findOne(id);

        return result;
    }


    /**
     * Liefert eine Liste von Städten für Pagination
     *
     * @param page
     * @return
     */
    @RequestMapping("/city/page/{page}")
    public List<City> getCityById(@PathVariable Integer page) {

        List<City> result = new ArrayList<>();

        for (City c : cityRepository.findAll(new PageRequest(page, 10)))
            result.add(c);

        return result;
    }
}