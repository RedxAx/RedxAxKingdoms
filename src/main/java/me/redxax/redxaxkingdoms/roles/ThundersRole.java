package me.redxax.redxaxkingdoms.roles;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class ThundersRole implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) return;

        Player damager = (Player) event.getDamager();
        Player damaged = (Player) event.getEntity();

        if (!damaged.hasPermission("k.thunders")) return;

        Material itemInHand = damager.getInventory().getItemInMainHand().getType();

        if (itemInHand == Material.REDSTONE || itemInHand == Material.REDSTONE_BLOCK || itemInHand == Material.REDSTONE_ORE) {
            if (damager.hasPermission("k.thunders")) return;
            damaged.getWorld().strikeLightning(damaged.getLocation());
        }

        if (damager.hasPermission("k.thunders") && (damaged.getWorld().hasStorm() || damaged.getWorld().isThundering())) {
            if (damaged.hasPermission("k.thunders")) return;
            if (Math.random() <= 0.33) {
                damaged.getWorld().strikeLightning(damaged.getLocation());
                damaged.setMetadata("StruckBy", new FixedMetadataValue((Plugin) this, damager.getName()));
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();

        if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            if (player.hasMetadata("StruckBy")) {
                String strikerName = player.getMetadata("StruckBy").get(0).asString();
                if (strikerName.equals(player.getName())) {
                    event.setCancelled(true);
                    player.removeMetadata("StruckBy", (Plugin) this);
                }
            }
        }
    }
}