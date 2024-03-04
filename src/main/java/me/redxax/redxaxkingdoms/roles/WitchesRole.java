package me.redxax.redxaxkingdoms.roles;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class WitchesRole implements Listener {
    private final PotionEffectType[] goodEffects = {
            PotionEffectType.REGENERATION,
            PotionEffectType.DAMAGE_RESISTANCE,
            PotionEffectType.JUMP,
            PotionEffectType.SPEED,
            PotionEffectType.FIRE_RESISTANCE,
            PotionEffectType.INCREASE_DAMAGE,
            PotionEffectType.INVISIBILITY,
            PotionEffectType.NIGHT_VISION,
            PotionEffectType.WATER_BREATHING,
            PotionEffectType.HEALTH_BOOST,
            PotionEffectType.ABSORPTION,
            PotionEffectType.SATURATION
    };

    private final PotionEffectType[] badEffects = {
            PotionEffectType.POISON,
            PotionEffectType.WITHER,
            PotionEffectType.BLINDNESS,
            PotionEffectType.CONFUSION,
            PotionEffectType.HARM,
            PotionEffectType.HUNGER,
            PotionEffectType.LEVITATION,
            PotionEffectType.SLOW,
            PotionEffectType.WEAKNESS
    };

    private final Random random = new Random();

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;

        Player player = (Player) event.getDamager();

        if (event.getEntity() instanceof Player) {
            Player damagedPlayer = (Player) event.getEntity();
            if (damagedPlayer.hasPermission("k.witches")) return;
        }

        if (player.hasPermission("k.witches") && Math.random() < 0.05) {
            if (Math.random() < 0.6) {
                // Apply a random good effect
                PotionEffectType effect = goodEffects[random.nextInt(goodEffects.length)];
                player.addPotionEffect(new PotionEffect(effect, 600, 1));
            } else {
                // Apply a random bad effect
                PotionEffectType effect = badEffects[random.nextInt(badEffects.length)];
                player.addPotionEffect(new PotionEffect(effect, 600, 1));
            }
        }
    }
}