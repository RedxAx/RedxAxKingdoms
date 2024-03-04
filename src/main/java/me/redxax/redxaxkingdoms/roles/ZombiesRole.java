package me.redxax.redxaxkingdoms.roles;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ZombiesRole implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.hasPermission("k.zombies") && event.getEntity() instanceof Zombie) {
                event.setCancelled(true);
            } else if (player.hasPermission("k.zombies")) {
                if (event.getEntity() instanceof Player) {
                    Player damagedPlayer = (Player) event.getEntity();
                    if (damagedPlayer.hasPermission("k.zombies")) return;
                }
                if (Math.random() <= 0.25) {
                    reducePlayerHunger((Player) event.getEntity(), 0.5);
                }
            }
        }
    }

    private void reducePlayerHunger(Player player, double amount) {
        int currentFoodLevel = player.getFoodLevel();
        double newFoodLevel = currentFoodLevel - amount;
        if (newFoodLevel < 0) {
            newFoodLevel = 0;
        }
        player.setFoodLevel((int) newFoodLevel);
    }
}