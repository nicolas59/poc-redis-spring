package com.nro.poc.redisspring.resources

import com.nro.poc.redisspring.persistence.model.Person
import com.nro.poc.redisspring.persistence.repository.PersonRepository
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@Api(value = "/person", description = "API pour la gestion des personnes." )
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
    fun findById(@ApiParam(required = true, example = "1", value = "Identifiant fonctionnel de la personne recherchée")  @PathVariable id:String) = this.repository.findById(id)

    @ApiOperation(value = "Permet d'enregistrer une nouvelle personne",
            notes = "Enregistre la personne en base de données. Le resultat de la requete contient une entete Location indiquant l'url pour la récupération du nouveau client.")
    @ApiResponses(
            value = [
                ApiResponse(code = 500, message = "Erreur interne serveur"),
                ApiResponse(code = 201, message = "Entité crée",
                        responseHeaders= [(ResponseHeader(name = "Location", description = "URL d'acces à la nouvelle personne"))])
            ]
    )
    @PostMapping
    fun create(@RequestBody person:Person) : ResponseEntity<Void> {
        return this.repository.save(person).let {
            val location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/person/{id}")
                    .buildAndExpand(it.identifier).toUri()

            return ResponseEntity.created(location).build()
        }
    }
}