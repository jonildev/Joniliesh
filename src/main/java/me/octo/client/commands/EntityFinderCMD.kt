package me.octo.client.commands

import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import me.octo.client.config.Config
import me.octo.client.utils.ChatUtils

class EntityFinderCMD : Command("EntityFinder", true, false){

        @DefaultHandler
        fun handle() {
            Config.entityFinder = !Config.entityFinder // Toggle the value
            val status = if (Config.entityFinder) "§aENABLED" else "§cDISABLED"
            ChatUtils.messageToChat("EntityFinder is now $status")
        }
}