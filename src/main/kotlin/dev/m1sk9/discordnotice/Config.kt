package dev.m1sk9.discordnotice

import org.bukkit.configuration.file.FileConfiguration
import java.lang.NullPointerException

class Config(val config: FileConfiguration) {

    fun getWebHookURL(): String {
        val result = config.getString("discord.webhookURL")
            ?: throw NullPointerException("WebHook URL is not found in the config.yml!")
        return result
    }

}
