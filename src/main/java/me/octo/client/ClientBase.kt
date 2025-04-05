package me.octo.client

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import me.octo.client.commands.ConfigCommand
import me.octo.client.commands.EntityFinderCMD
import me.octo.client.commands.TestCommand
import me.octo.client.config.Config
import me.octo.client.features.ChatFeatures
import me.octo.client.features.EntityFinder
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = "clientbase", name = "ClientBase", version = "1.0.0", clientSideOnly = true)
class ClientBase {
    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
        Config().preload()
        registerCommand(ConfigCommand())
        registerCommand(TestCommand())
        registerCommand(EntityFinderCMD())
        MinecraftForge.EVENT_BUS.register(ChatFeatures())
        MinecraftForge.EVENT_BUS.register(EntityFinder())
    }

    private fun registerCommand(vararg commands: Command) {
        for (command in commands) EssentialAPI.getCommandRegistry().registerCommand(command)
    }

}