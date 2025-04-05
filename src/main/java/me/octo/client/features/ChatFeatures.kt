package me.octo.client.features

import me.octo.client.config.Config
import me.octo.client.utils.ChatUtils
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class ChatFeatures {

    @SubscribeEvent(receiveCanceled = true)
    fun onChatReceive(event: ClientChatReceivedEvent) {
        if (!Config.chatFeatures) return

        if (event.type.toInt() == 2) return

        val message = event.message.formattedText
            ChatUtils.messageToChat(message)
    }
}