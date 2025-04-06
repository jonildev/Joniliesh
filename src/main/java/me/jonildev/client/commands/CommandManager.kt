package me.jonildev.client.commands

import com.example.commands.SimpleCommand
import me.jonildev.client.config.Config
import me.jonildev.client.utils.ChatUtils
import net.minecraft.command.ICommandSender
import net.minecraft.util.BlockPos
import net.minecraftforge.client.ClientCommandHandler

class CommandManager {

    init {
        registerCommand("testcommand") {
            ChatUtils.messageToChat("Test successful.")
        }
        registerCommand("EntityFinder") {
            Config.entityFinder = !Config.entityFinder
            val status = if (Config.entityFinder) "§aENABLED" else "§cDISABLED"
            ChatUtils.messageToChat("EntityFinder is now $status")
        }
        registerCommand("testtoggle") {
            Config.chatFeatures = !Config.chatFeatures // Toggle the value
            val status = if (Config.chatFeatures) "§aENABLED" else "§cDISABLED"
            ChatUtils.messageToChat("ChatFeature is now $status")
        }
    }

    private fun registerCommand(name: String, function: (Array<String>) -> Unit) {
        ClientCommandHandler.instance.registerCommand(SimpleCommand(name, createCommand(function)))
    }

    private fun registerCommand0(
        name: String,
        function: (Array<String>) -> Unit,
        autoComplete: ((Array<String>) -> List<String>) = { listOf() }
    ) {
        val command = SimpleCommand(
            name,
            createCommand(function),
            object : SimpleCommand.TabCompleteRunnable {
                override fun tabComplete(sender: ICommandSender?, args: Array<String>?, pos: BlockPos?): List<String> {
                    return autoComplete(args ?: emptyArray())
                }
            }
        )
        ClientCommandHandler.instance.registerCommand(command)
    }

    private fun createCommand(function: (Array<String>) -> Unit) = object : SimpleCommand.ProcessCommandRunnable() {
        override fun processCommand(sender: ICommandSender?, args: Array<String>?) {
            if (args != null) function(args.asList().toTypedArray())
        }
    }

}