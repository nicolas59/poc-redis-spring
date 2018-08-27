package com.nro.poc.redisspring.persistence.model

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@ApiModel(value="Person", description="Entité représentant une personne physique")
@RedisHash("persons")
data class Person(
        @ApiModelProperty(value = "Identifiant", position = 0)
        @Id @JsonInclude(JsonInclude.Include.NON_NULL) var identifier:String,

        @ApiModelProperty(value = "Civilite", position = 1)
        val civilite:String?,

        @ApiModelProperty(value = "Nom", position = 2, required = true)
        @Indexed val nom:String,

        @ApiModelProperty(value = "Nom marital", position = 3)
        var nomMarital:String?,

        @ApiModelProperty(value = "Prenom", position = 4, required = true)
        @Indexed val prenom:String,

        @ApiModelProperty(value = "Adresse de la personne", position = 5)
        val adresse:Adresse?
)


data class Adresse (
        @ApiModelProperty(value = "Adresse (rue, avenue, boulevard)", required = true)
        var adresse1:String,

        @ApiModelProperty(value = "Information complementaire sur l'adresse")
        var adresse2:String?,

        @ApiModelProperty(value = "Code Postal", required = true)
        var cp:String,

        @ApiModelProperty(value = "Ville", required = true)
        var ville:String,

        @ApiModelProperty(value = "Pays", required = true)
        var pays:String
)

