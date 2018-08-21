package com.nro.poc.redisspring.persistence.model

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("persons")
data class Person(
        @Id @JsonInclude(JsonInclude.Include.NON_NULL) var identifier:String,
        @Indexed val nom:String,
        @Indexed val prenom:String)
