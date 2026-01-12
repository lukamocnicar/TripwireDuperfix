package me.tripwiredupe;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TripwireDupe extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (block.getType() != Material.TRIPWIRE_HOOK) return;

        // Only dupe if powered
        if (!block.isBlockPowered() && !block.isBlockIndirectlyPowered()) return;

        // Drop extra hook (simulate dupe)
        block.getWorld().dropItemNaturally(
                block.getLocation(),
                new ItemStack(Material.TRIPWIRE_HOOK, 1)
        );
    }
}
