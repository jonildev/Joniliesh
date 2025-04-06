package me.jonildev.client.features

import me.jonildev.client.config.Config
import me.jonildev.client.utils.ChatUtils
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent
import me.jonildev.client.utils.Constants.player
import me.jonildev.client.utils.GUI.getItemByName

class ScanGUI {
    @SubscribeEvent
    fun clickanvil(event: ClientTickEvent) {
        if (!Config.GUIScanner) return
        val test = getItemByName("Chest")
        ChatUtils.message(test.toString())

    }
}
