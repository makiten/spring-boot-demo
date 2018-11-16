package com.harlandclarke.bootdemo.entity;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByLastName(String personIndex);
    Person findByPersonIndex(Integer pindex);

}
