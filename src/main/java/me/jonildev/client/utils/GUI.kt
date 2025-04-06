package me.jonildev.client.utils

import me.jonildev.client.utils.Constants.mc
import me.jonildev.client.utils.Constants.player
import me.jonildev.client.utils.Constants.removeFormatting
import net.minecraft.item.Item

object GUI {

    data class ItemWrapper(
        val slot: Int,
        val displayName: String?,
        val lore: List<String>?
    )

    fun clickSlot(slotId: Int, mouseButton: Int, mode: Int) {
        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, slotId, mouseButton, mode, player)
    }

    fun getItemByNames(names: List<String>): ItemWrapper? {
        for (name in names) {
            for (i in 0..53) {
                val stack = player?.inventory?.mainInventory?.get(i) ?: continue
                if (stack.displayName?.removeFormatting()?.contains(name) == true) {
                    return ItemWrapper(
                        i,
                        stack.displayName,
                        stack.getTooltip(player, mc.gameSettings.advancedItemTooltips)
                    )
                }
            }
        }
        return null
    }

    fun getItemByName(name: String): ItemWrapper? {
        for (i in 0..53) {
            val stack = mc.thePlayer?.inventory?.mainInventory?.get(i) ?: continue
            val unformattedName = stack.displayName?.removeFormatting()

            // Log every item name in the inventory for debugging purposes
            ChatUtils.message("Item $i: ${unformattedName}")

            if (unformattedName?.contains(name, ignoreCase = true) == true) {  // Case-insensitive search
                return ItemWrapper(i, stack.displayName, stack.getTooltip(mc.thePlayer, mc.gameSettings.advancedItemTooltips))
            }
        }
        return null
    }


    fun getItemByLore(line: String): ItemWrapper? {
        for (i in 0..53) {
            val stack = mc.thePlayer.inventory.mainInventory[i] ?: continue
            val lore = stack.getTooltip(player, mc.gameSettings.advancedItemTooltips)
            if (lore.any { it.contains(line) }) {
                return ItemWrapper(i, stack.displayName, lore)
            }
        }
        return null
    }

    fun getItemByIds(ids: List<Int>): ItemWrapper? {
        for (i in 0..53) {
            val stack = player?.inventory?.mainInventory?.get(i) ?: continue
            val lore = stack.getTooltip(player, mc.gameSettings.advancedItemTooltips)
            if (ids.contains(Item.getIdFromItem(stack.item))) {
                return ItemWrapper(i, stack.displayName, lore)
            }
        }
        return null
    }
}