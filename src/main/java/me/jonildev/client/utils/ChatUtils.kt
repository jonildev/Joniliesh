package me.jonildev.client.utils

import me.jonildev.client.utils.constants.mc
import net.minecraft.util.ChatComponentText

object ChatUtils {

    fun messageToChat(text: String) {
        mc.ingameGUI.chatGUI.printChatMessage(ChatComponentText(text))
    }
}