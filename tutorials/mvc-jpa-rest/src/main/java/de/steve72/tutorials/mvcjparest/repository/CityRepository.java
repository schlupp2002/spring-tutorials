package de.steve72.tutorials.mvcjparest.repository;

import de.steve72.tutorials.mvcjparest.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * CityRepository
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    /*
        http://docs.spring.io/spring-data/jpa/docs/1.10.3.RELEASE/reference/html/#jpa.query-methods
     */

    Iterable<City> findByName(String name);
}
