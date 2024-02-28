
package dev.m1sk9.discordnotice

import org.bukkit.plugin.java.JavaPlugin

class DiscordNotice : JavaPlugin() {

    private val webHook = WebHook()
    private val pluginConfig = Config(config)

    override fun onEnable() {
        saveDefaultConfig()
        webHook.sendNotice(pluginConfig.getWebHookURL(), "サーバーが起動しました")
        logger.info("Discord Notice is enabled!")
    }

    override fun onDisable() {
        webHook.sendNotice(pluginConfig.getWebHookURL(), "サーバーが停止しました")
        logger.info("Discord Notice is disabled!")
    }
}
