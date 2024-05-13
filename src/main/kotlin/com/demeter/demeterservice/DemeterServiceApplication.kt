package com.demeter.demeterservice

import OpenAIProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties(OpenAIProperties::class)
@ComponentScan(basePackages = ["com.demeter.demeterservice"])
class DemeterServiceApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(DemeterServiceApplication::class.java, *args)
		}
	}
}