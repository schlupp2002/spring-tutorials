package de.steve72.tutorials.mvcjparest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * City
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

@Entity
public class City {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Countrycode")
    private String countrycode;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private Integer population;


    public City() {

    }


    public Long getId() {

        return id;
    }


    public void setId(Long id) {

        this.id = id;
    }


    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getCountrycode() {

        return countrycode;
    }


    public void setCountrycode(String countrycode) {

        this.countrycode = countrycode;
    }


    public String getDistrict() {

        return district;
    }


    public void setDistrict(String district) {

        this.district = district;
    }


    public Integer getPopulation() {

        return population;
    }


    public void setPopulation(Integer population) {

        this.population = population;
    }


    @Override
    public String toString() {

        return String.format("[%s] (%d, %s, {%s}, %s, %d)",
              this.getClass().getSimpleName(),
              id,
              name,
              countrycode,
              district,
              population
        );
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return id != null ? id.equals(city.id) : city.id == null;

    }


    @Override
    public int hashCode() {

        return id != null ? id.hashCode() : 0;
    }
}
