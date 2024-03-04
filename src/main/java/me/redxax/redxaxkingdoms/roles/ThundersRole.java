package me.redxax.redxaxkingdoms.roles;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ThundersRole implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.hasPermission("k.thunders") && (event.getEntity().getWorld().hasStorm() || event.getEntity().getWorld().isThundering())) {
                if (Math.random() <= 0.33) {
                    event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
                }
            }
        } else if (event.getEntity() instanceof Player) {
            Player entity = (Player) event.getEntity();
            if (event.getDamager() instanceof LivingEntity) {
                LivingEntity damager = (LivingEntity) event.getDamager();
                ItemStack itemInHand = damager.getEquipment().getItemInMainHand();
                Material materialInHand = itemInHand.getType();

                if (entity.hasPermission("k.thunders") && (materialInHand == Material.IRON_SWORD ||
                        materialInHand == Material.IRON_AXE ||
                        materialInHand == Material.IRON_PICKAXE ||
                        materialInHand == Material.IRON_SHOVEL ||
                        materialInHand == Material.IRON_HOE ||
                        materialInHand == Material.IRON_HELMET ||
                        materialInHand == Material.IRON_CHESTPLATE ||
                        materialInHand == Material.IRON_LEGGINGS ||
                        materialInHand == Material.IRON_BOOTS ||
                        materialInHand == Material.IRON_INGOT ||
                        materialInHand == Material.COPPER_INGOT) && Math.random() <= 0.3) {
                    entity.getWorld().strikeLightning(entity.getLocation());
                }
            }
        }
    }
}