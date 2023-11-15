package cz.maio.deps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DepsApplication

fun main(args: Array<String>) {
    runApplication<DepsApplication>(*args)
}
