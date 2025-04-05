package me.octo.client.commands

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import me.octo.client.config.Config
import me.octo.client.utils.ChatUtils

class ConfigCommand : Command("clientbase", true, false) {

    @DefaultHandler
    fun handle() {
        EssentialAPI.getGuiUtil().openScreen(Config.INSTANCE.gui())
        ChatUtils.messageToChat("§aTOGGLED")
    }
}