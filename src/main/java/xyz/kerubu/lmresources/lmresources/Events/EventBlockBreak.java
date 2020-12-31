package xyz.kerubu.lmresources.lmresources.Events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EventBlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack Item = new ItemStack(event.getBlock().getType());

        if (!player.getGameMode().equals(GameMode.CREATIVE)) {
            if (player.getInventory().firstEmpty() == -1){
                player.sendMessage("§cYour inventory is full.");
                block.getDrops().forEach(drops -> {
                    drops.setAmount(drops.getAmount());
                    block.getLocation().getWorld().dropItemNaturally(block.getLocation(), drops);
                });
                event.setCancelled(true);
            }else{
                player.getInventory().addItem(Item);
                event.setCancelled(true);
            }
        }
    }
}
