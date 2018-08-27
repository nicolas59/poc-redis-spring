package com.nro.poc.redisspring.persistence.repository

import com.nro.poc.redisspring.persistence.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository: CrudRepository<Person, String>{

}