package me.jonildev.client.utils

import me.jonildev.client.utils.Constants.mc
import net.minecraft.util.ChatComponentText

object ChatUtils {

    fun message(text: String) {
        mc.ingameGUI.chatGUI.printChatMessage(ChatComponentText(text))
    }
}