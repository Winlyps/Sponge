package winlyps.sponge

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class WaterSpongeCommand(private val plugin: Sponge) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "Only players can use this command!")
            return true
        }

        if (!sender.hasPermission("sponge.watersponge")) {
            sender.sendMessage(ChatColor.RED.toString() + "You do not have permission to use this command!")
            return true
        }

        val waterSponge = ItemStack(Material.SPONGE)
        val meta = waterSponge.itemMeta
        meta?.setDisplayName(ChatColor.AQUA.toString() + "Water Sponge")
        waterSponge.itemMeta = meta

        sender.inventory.addItem(waterSponge)
        sender.sendMessage(ChatColor.GREEN.toString() + "You have received a Water Sponge!")
        return true
    }
}