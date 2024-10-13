package com.organisation.projectname

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.organisation.projectname"])
class ExampleApplication

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
    val hello = ""
    val hello2 = ""
}

private fun unsued() {
    val notUsed = true
}
