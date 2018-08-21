package com.nro.poc.redisspring.resources

import com.nro.poc.redisspring.persistence.model.Person
import com.nro.poc.redisspring.persistence.repository.PersonRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@Api(value = "API pour la gestion des personnes.")
@RestController
@RequestMapping("/person", produces = [MediaType.APPLICATION_JSON_VALUE])
class PersonResource {

    @Autowired
    lateinit var repository: PersonRepository

    @ApiOperation(value = "Retourne l'ensemble des personnes",
            response = Person::class,
            responseContainer = "List"
    )
    @GetMapping
    fun findAll() = this.repository.findAll()

    @ApiOperation(value = "Permet de rechercher une personne en fonction de son identifiant",
            response = Person::class
    )
    @GetMapping(path = ["/{id}"])
    fun findById(@ApiParam  @PathVariable id:String) = this.repository.findById(id)

    @ApiOperation(value = "Permet d'enregistrer une nouvelle personne")
    @PostMapping
    fun create(@ApiParam @RequestBody person:Person) : ResponseEntity<Void> {
        return this.repository.save(person).let {
            val location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/person/{id}")
                    .buildAndExpand(it.identifier).toUri()

            return ResponseEntity.created(location).build()
        }
    }
}