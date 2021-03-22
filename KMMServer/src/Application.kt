package com.chathil

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.slf4j.event.Level
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    routing {
        get("/games") {
            val path = Paths.get("").toAbsolutePath().toString()
            call.respondText(readFileDirectlyAsText(path + File.separatorChar + "resources" + File.separatorChar + "games.json"), contentType = ContentType.Application.Json)
        }
    }
}

fun readFileDirectlyAsText(fileName: String): String
        = File(fileName).readText(Charsets.UTF_8)