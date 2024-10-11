package de.tieman114.items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class CrystalMeth {
    private static final String CHAT_MESSAGE = "You feel a sudden kick...";

    public static void use(Player player, ItemStack handheldItem) {
        // Send chat message
        player.sendMessage(ChatColor.DARK_PURPLE + CHAT_MESSAGE);
        // Add effects to player
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 600, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 600, 3));
        player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_DAMAGE, 2, 1));

        // Decrement item ammount
        int ammount = handheldItem.getAmount();
        if (ammount > 1) {
            handheldItem.setAmount(ammount - 1);
        } else if (ammount == 1) {
            player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
        }
        
        player.updateInventory();
        
        // Play eating sound
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1.0f, 1.0f);

    }

}
