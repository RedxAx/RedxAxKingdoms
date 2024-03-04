package me.redxax.redxaxkingdoms.roles;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class SlimesRole implements Listener {

    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();

        if (player.hasPermission("k.slimes") && event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemThrow(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("k.slimes") && Math.random() < 0.3) {
            event.setCancelled(true);
            player.playSound(player.getLocation(), Sound.ENTITY_SLIME_JUMP, 1.0F, 1.0F);
        }
    }
}