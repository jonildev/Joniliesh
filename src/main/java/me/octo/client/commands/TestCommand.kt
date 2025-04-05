package me.octo.client.commands

import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import me.octo.client.config.Config
import me.octo.client.utils.ChatUtils

class TestCommand : Command("testtoggle", true, false) {

    @DefaultHandler
    fun handle() {
        Config.chatFeatures = !Config.chatFeatures // Toggle the value
        val status = if (Config.chatFeatures) "§aENABLED" else "§cDISABLED"
        ChatUtils.messageToChat("ChatFeature is now $status")
    }
}