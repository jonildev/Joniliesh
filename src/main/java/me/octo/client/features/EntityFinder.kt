package me.octo.client.features

import me.octo.client.config.Config
import me.octo.client.utils.ChatUtils
import me.octo.client.utils.constants.mc
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class EntityFinder {

    @SubscribeEvent
    fun onRender(event: RenderWorldLastEvent) {
        if (!Config.entityFinder) return

        val entities = mc.theWorld.loadedEntityList
            .find { entity ->
                entity.isEntityAlive && entity.name.equals("Forger")
            }

        entities?.let {
            val forgercoords = ("${it.posX.toInt()} ${it.posY.toInt()} ${it.posZ.toInt()}")
                ChatUtils.messageToChat(" ${it.name}, (${it.posX.toInt()}, ${it.posY.toInt()}, ${it.posZ.toInt()})")
            ChatUtils.messageToChat(forgercoords)
        }
    }
}