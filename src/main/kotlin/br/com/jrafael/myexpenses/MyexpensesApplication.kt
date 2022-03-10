package br.com.jrafael.myexpenses

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyexpensesApplication

fun main(args: Array<String>) {
	runApplication<MyexpensesApplication>(*args)
}
