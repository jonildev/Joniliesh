package me.jonildev.client.features

import me.jonildev.client.config.Config
import me.jonildev.client.utils.ChatUtils
import me.jonildev.client.utils.Constants.mc
import net.minecraft.entity.Entity
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class EntityFinder {

    companion object {
        var entities: List<Entity> = listOf()
            private set
    }

    @SubscribeEvent
    fun onRender(event: RenderWorldLastEvent) {
        if (!Config.entityFinder) return

        entities = mc.theWorld.loadedEntityList
            .filter { it.isEntityAlive }

        entities.forEach {
            ChatUtils.message(" ${it.name}, (${it.posX.toInt()}, ${it.posY.toInt()}, ${it.posZ.toInt()})")
        }
    }
}