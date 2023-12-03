package org.acme.rest.client;

import com.fasterxml.jackson.annotation.JsonCreator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Map;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "countries")
public class Country extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="name")
    @Type(value=JsonType.class)
    public Map<String, Object> name;

    @Column(name="region")
    public String region;

    @Column(name="population")
    public Long population;

    @Column(name="flag")
    public String flag;

    public Country() {
    }

    public Country(Map<String, Object> name, String region, Long population, String flag) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.flag = flag;
    }

    @JsonCreator
    public static Country of(Map<String, Object> name, String region, Long population, String flag) {
        return new Country(name, region, population, flag);
    }

}