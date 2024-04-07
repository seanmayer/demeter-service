package com.demeter.demeterservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemeterServiceApplication

fun main(args: Array<String>) {
	runApplication<DemeterServiceApplication>(*args)
}
