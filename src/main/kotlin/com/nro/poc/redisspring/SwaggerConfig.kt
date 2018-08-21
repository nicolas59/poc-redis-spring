package com.nro.poc.redisspring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import java.util.*


@Configuration
@EnableSwagger2
internal class SwaggerConfig {

    @Bean
    fun api() = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.nro.poc.redisspring"))
            .paths(PathSelectors.any())
            .build().apiInfo(apiInfo())

    fun apiInfo()= ApiInfo(
                "API Rest Example",
                "API permettant de restituer des informations sur les clients.",
                "1.0.0",
                "Terms of service",
                Contact("Ma Societe", "", ""),
                "License of API", "API license URL", Collections.emptyList())

}