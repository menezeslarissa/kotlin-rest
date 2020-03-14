package br.com.laris.wsbase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WsbaseApplication

fun main(args: Array<String>) {
	runApplication<WsbaseApplication>(*args)
}
