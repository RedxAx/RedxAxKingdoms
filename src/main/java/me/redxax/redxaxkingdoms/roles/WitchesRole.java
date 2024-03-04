package me.redxax.redxaxkingdoms.roles;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class WitchesRole implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;

        Player player = (Player) event.getDamager();

        if (player.hasPermission("k.witches") && Math.random() < 0.1) {
            if (Math.random() < 0.9) {
                // Apply a good effect
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 600, 1));

            } else {
                // Apply a bad effect
                player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 600, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 4));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 2));
            }
        }
    }
}