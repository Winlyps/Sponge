package winlyps.sponge

import org.bukkit.plugin.java.JavaPlugin

class Sponge : JavaPlugin() {

    override fun onEnable() {
        // Register the command and listener
        getCommand("watersponge")?.setExecutor(WaterSpongeCommand(this))
        server.pluginManager.registerEvents(WaterSpongeListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}