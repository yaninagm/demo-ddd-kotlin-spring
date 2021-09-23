package com.example.demoDDDYani.infrastructure.framework.configuration

import com.example.demoDDDYani.service.pruebas.AdventoOfCodeService
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties
@Suppress("TooManyFunctions")
class ApplicationConfiguration {
    @Bean
    fun adventoOfCodeService(
    ): AdventoOfCodeService =
        AdventoOfCodeService()

}