package me.jonildev.client.commands


import me.jonildev.client.commands.SimpleCommand.ProcessCommandRunnable
import me.jonildev.client.config.Config
import me.jonildev.client.utils.Constants.mc
import me.jonildev.client.utils.ChatUtils
import net.minecraft.command.ICommandSender
import net.minecraft.util.BlockPos
import net.minecraftforge.client.ClientCommandHandler

class CommandManager {

    init {
        registerCommand("test") {
            ChatUtils.message("test")
        }
        registerCommand("EntityFinder") {
            Config.entityFinder = !Config.entityFinder
            val status = if (Config.entityFinder) "§aENABLED" else "§cDISABLED"
            ChatUtils.message("EntityFinder is now $status")
        }
        registerCommand("GUIScanner") {
            Config.GUIScanner = !Config.GUIScanner
            val status = if (Config.GUIScanner) "§aENABLED" else "§cDISABLED"
            ChatUtils.message("GUIScanner is now $status")
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

    private fun createCommand(function: (Array<String>) -> Unit) = object : ProcessCommandRunnable() {
        override fun processCommand(sender: ICommandSender?, args: Array<String>?) {
            if (args != null) function(args.asList().toTypedArray())
        }
    }
}