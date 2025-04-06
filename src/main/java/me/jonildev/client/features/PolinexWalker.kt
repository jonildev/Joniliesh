package me.jonildev.client.features

import me.jonildev.client.utils.ChatUtils
import me.jonildev.client.features.EntityFinder.Companion.entities
import me.jonildev.client.utils.Constants.mc
import net.minecraftforge.client.ClientCommandHandler
import net.minecraftforge.fml.client.FMLClientHandler
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
class PolinexWalker {

    @SubscribeEvent
    fun pathfind(event: TickEvent.ClientTickEvent) {
        val forger = entities.find {
            it.name.equals("Forger", ignoreCase = true)
        }

        forger?.let {
            ChatUtils.message("/pathfind start ${it.posX.toInt()} ${it.posY.toInt()} ${it.posZ.toInt()}")
        }
    }
}