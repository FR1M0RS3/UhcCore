package com.gmail.val59000mc.scenarios.scenariolisteners;

import com.gmail.val59000mc.events.UhcStartedEvent;
import com.gmail.val59000mc.exceptions.UhcPlayerNotOnlineException;
import com.gmail.val59000mc.players.UhcPlayer;
import com.gmail.val59000mc.scenarios.ScenarioListener;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public class GoneFishingListener extends ScenarioListener{

    @EventHandler
    public void onGameStarted(UhcStartedEvent e){
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        rod.addEnchantment(Enchantment.LURE, 7);
        rod.addEnchantment(Enchantment.LUCK, 250);
        rod.addEnchantment(Enchantment.DURABILITY, 250);

        for (UhcPlayer uhcPlayer : e.getPlayersManager().getOnlinePlayingPlayers()){
            try {
                uhcPlayer.getPlayer().getInventory().addItem(rod);
                player.setLevel(Integer.MAX_VALUE);
            }catch (UhcPlayerNotOnlineException ex){
                // No rod for offline players
            }
        }
    }

}
