package com.demeter.demeterservice

import com.demeter.demeterservice.config.OpenAiConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties(OpenAiConfig::class)
@ComponentScan(basePackages = ["com.demeter.demeterservice"])
class DemeterServiceApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(DemeterServiceApplication::class.java, *args)
		}
	}
}