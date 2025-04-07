package me.jonildev.client.features

import me.jonildev.client.config.Config
import me.jonildev.client.utils.ChatUtils
import me.jonildev.client.utils.Constants.mc
import me.jonildev.client.utils.Constants.player
import me.jonildev.client.utils.Constants.removeFormatting
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent

class ScanGUI {

    data class ItemWrapper(
        val slot: Int,
        val displayName: String?,
        val lore: List<String>?
    )

    fun clickSlot(slotId: Int, mouseButton: Int, mode: Int) {
        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, slotId, mouseButton, mode, player)
    }


    private fun getItemByName(name: String): ItemWrapper? {
        val inventory = mc.thePlayer?.openContainer?.inventorySlots ?: return null
        for (i in inventory.indices) {
            val slot = inventory[i]
            val stack = slot.stack ?: continue
            val unformattedName = stack.displayName?.removeFormatting()

            if (unformattedName != null) {

                if (unformattedName.contains(name, ignoreCase = true)) {
                    return ItemWrapper(
                        i,
                        stack.displayName,
                        stack.getTooltip(mc.thePlayer, mc.gameSettings.advancedItemTooltips)
                    )
                }
            }
        }
        return null
    }

    private var delay = 0;
    @SubscribeEvent
    fun clickanvil(event: ClientTickEvent) {
        if (!Config.GUIScanner || delay % 4 != 0) return
        val inventoryName = mc.thePlayer.inventory.displayName.formattedText
        ChatUtils.message(inventoryName)
        delay = 0
        val test = getItemByName("Zombie")
        if (test != null) {
            ChatUtils.message("${test.slot}")
            val slotID = test.slot
            clickSlot(slotID, 0, 0)

        }

    }
}