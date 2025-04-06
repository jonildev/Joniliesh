package me.jonildev.client.utils

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityPlayerSP
import net.minecraft.client.multiplayer.WorldClient

object Constants {
    val mc: Minecraft = Minecraft.getMinecraft()
    val world: WorldClient? = Minecraft.getMinecraft().theWorld
    val player: EntityPlayerSP? = Minecraft.getMinecraft().thePlayer

    fun String.removeFormatting(): String {
        return this.replace(Regex("§[0-9a-fA-Fklmnor]"), "")
    }


}