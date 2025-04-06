package me.jonildev.client

import me.jonildev.client.commands.CommandManager
import me.jonildev.client.features.EntityFinder
import me.jonildev.client.features.PolinexWalker
import me.jonildev.client.features.ScanGUI
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = "joniliesh", name = "Joniliesh", version = "1.0.0", clientSideOnly = true)
class Joniliesh {

    @Mod.EventHandler
    fun preInit(event: FMLInitializationEvent) {
        CommandManager()
        MinecraftForge.EVENT_BUS.register(ScanGUI())
        MinecraftForge.EVENT_BUS.register(EntityFinder())
        MinecraftForge.EVENT_BUS.register(PolinexWalker())
    }

}