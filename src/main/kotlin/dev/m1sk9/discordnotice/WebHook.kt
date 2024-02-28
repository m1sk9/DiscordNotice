package dev.m1sk9.discordnotice

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import java.net.HttpURLConnection
import java.util.logging.Logger

class WebHook {

    fun sendNotice(webhookUrl: String, message: String) {
        val logger = Logger.getLogger("DiscordNotice.WebHook")

        val payload = """
            {
                "content": "$message"
            }
        """.trimIndent()

        Fuel.post(webhookUrl).jsonBody(payload).response { _, response, result ->
            when (response.statusCode) {
                HttpURLConnection.HTTP_OK -> {
                    logger.info("Successfully sent a notice to Discord!")
                }
                else -> {
                    logger.warning("Failed to send a notice to Discord! ${result.component2()}")
                }
            }
        }
    }
}
