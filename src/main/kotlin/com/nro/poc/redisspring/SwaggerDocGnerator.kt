package com.nro.poc.redisspring

import io.github.swagger2markup.Swagger2MarkupConverter
import java.net.URL
import java.nio.file.Paths

fun main(args:Array<String>) {
    val remoteSwaggerFile = URL("http://localhost:8080/v2/api-docs")
    val outputDirectory = Paths.get("build/asciidoc")

    Swagger2MarkupConverter.from(remoteSwaggerFile)
            .build()
            .toFolder(outputDirectory)
}