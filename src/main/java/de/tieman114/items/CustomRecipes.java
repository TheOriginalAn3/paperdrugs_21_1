package de.tieman114.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class CustomRecipes {

    private static ItemStack weed = null;
    private static ItemStack cocaine = null;
    private static ItemStack midnightMarks = null;
    private static ItemStack chemicals = null;
    private static ItemStack liquidCrystalMeth = null;
    private static ItemStack crystalMeth = null;
    private static ItemStack decorativeAnvil = null;

    public static void register(Plugin plugin) {
        // Weed
        createWeedItemStack();
        // ShapelessRecipe recipe0 = new ShapelessRecipe(new NamespacedKey(plugin,
        // "WeedRecipe"), weed);
        // recipe0.addIngredient(3, Material.FERN);
        // Bukkit.addRecipe(recipe0);

        // Cocaine
        createCocaineItemStack();
        // ShapelessRecipe recipe1 = new ShapelessRecipe(new NamespacedKey(plugin,
        // "CocaineRecipe"), cocaine);
        // recipe1.addIngredient(1, Material.FERN);
        // recipe1.addIngredient(3, Material.GUNPOWDER);
        // recipe1.addIngredient(3, Material.BROWN_MUSHROOM);
        // Bukkit.addRecipe(recipe1);

        // Midnight Marks
        createMidnightMarks();

        // Chemicals
        createChemicals();
        ShapelessRecipe chemicalsRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "ChemicalsRecipe"), chemicals);
        chemicalsRecipe.addIngredient(1, Material.FERN);
        chemicalsRecipe.addIngredient(1, Material.BROWN_MUSHROOM);
        chemicalsRecipe.addIngredient(1, Material.FERMENTED_SPIDER_EYE);
        chemicalsRecipe.addIngredient(1, Material.SUGAR);
        chemicalsRecipe.addIngredient(1, Material.WATER_BUCKET);
        Bukkit.addRecipe(chemicalsRecipe);

        // Liquid Crystal Meth
        createLiquidCrystalMeth();
        FurnaceRecipe liquidCrystalMethRecipe = new FurnaceRecipe(new NamespacedKey(plugin, "LiquidCrystalMethRecipe"),
                getLiquidCrystalMeth(), new RecipeChoice.ExactChoice(getChemicals()), 20f, 20 * 10);
        Bukkit.addRecipe(liquidCrystalMethRecipe);

        // Crystal Meth
        createCrystalMeth();
        FurnaceRecipe crystalMethRecipe = new FurnaceRecipe(new NamespacedKey(plugin, "CrystalMethRecipe"),
                getCrystalMeth(), new RecipeChoice.ExactChoice(getLiquidCrystalMeth()), 20f, 20 * 10);
        Bukkit.addRecipe(crystalMethRecipe);

        // Decorative Anvil
        createDecorativeAnvil(plugin);
        ShapedRecipe decorativeAnvilRecipe = new ShapedRecipe(new NamespacedKey(plugin, "DecorativeAnvilRecipe"),
                getDecorativeAnvil());
        decorativeAnvilRecipe.shape("III",
                                    " I ",
                                    "III");
        decorativeAnvilRecipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.addRecipe(decorativeAnvilRecipe);

        // Iron from Enderpearls
        ShapelessRecipe ironFromEnderPearls = new ShapelessRecipe(
                new NamespacedKey(plugin, "IronFromEnderPearlsRecipe"), new ItemStack(Material.IRON_INGOT));
        ironFromEnderPearls.addIngredient(4, new ItemStack(Material.ENDER_PEARL));
        Bukkit.addRecipe(ironFromEnderPearls);
    }

    @SuppressWarnings("deprecation")
    private static void createWeedItemStack() {
        if (weed == null) {
            weed = new ItemStack(Material.LARGE_FERN);
            ItemMeta weedMeta = weed.getItemMeta();
            weedMeta.setDisplayName(ChatColor.GOLD + "Weed");
            weedMeta.addEnchant(Enchantment.BREACH, 1, true);
            weedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            weed.setItemMeta(weedMeta);
        }
    }

    @SuppressWarnings("deprecation")
    private static void createCocaineItemStack() {
        if (cocaine == null) {
            cocaine = new ItemStack(Material.SUGAR);
            ItemMeta cocaineMeta = cocaine.getItemMeta();
            cocaineMeta.setDisplayName(ChatColor.GOLD + "Cocaine");
            cocaineMeta.addEnchant(Enchantment.BREACH, 1, true);
            cocaineMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore = new ArrayList<>();
            lore.add("Like Meth but better");
            cocaineMeta.setLore(lore);
            cocaine.setItemMeta(cocaineMeta);
        }
    }

    @SuppressWarnings("deprecation")
    private static void createMidnightMarks() {
        if (midnightMarks == null) {
            midnightMarks = new ItemStack(Material.AMETHYST_SHARD);
            ItemMeta midnightMarksMeta = midnightMarks.getItemMeta();
            midnightMarksMeta.setDisplayName(ChatColor.DARK_PURPLE + "Midnight Marks");
            midnightMarksMeta.addEnchant(Enchantment.BREACH, 1, true);
            midnightMarksMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            midnightMarksMeta.setCustomModelData(1);
            midnightMarks.setItemMeta(midnightMarksMeta);
        }
    }

    @SuppressWarnings("deprecation")
    private static void createChemicals() {
        if (chemicals == null) {
            chemicals = new ItemStack(Material.WATER_BUCKET);
            ItemMeta chemicalsMeta = chemicals.getItemMeta();
            chemicalsMeta.setCustomModelData(2);
            chemicalsMeta.setDisplayName(ChatColor.GOLD + "Chemicals");
            chemicalsMeta.addEnchant(Enchantment.BREACH, 1, true);
            chemicalsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore = new ArrayList<>();
            lore.add("Used for the creation of Liquid Crystal Meth");
            chemicalsMeta.setLore(lore);
            chemicals.setItemMeta(chemicalsMeta);
        }
    }

    @SuppressWarnings("deprecation")
    private static void createLiquidCrystalMeth() {
        if (liquidCrystalMeth == null) {
            liquidCrystalMeth = new ItemStack(Material.AMETHYST_SHARD);
            ItemMeta liquidCrystalMethMeta = liquidCrystalMeth.getItemMeta();
            liquidCrystalMethMeta.setCustomModelData(3);
            liquidCrystalMethMeta.setDisplayName(ChatColor.GOLD + "Liquid Crystal Meth");
            liquidCrystalMethMeta.addEnchant(Enchantment.BREACH, 1, true);
            liquidCrystalMethMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            liquidCrystalMeth.setItemMeta(liquidCrystalMethMeta);
        }
    }

    @SuppressWarnings("deprecation")
    private static void createCrystalMeth() {
        if (crystalMeth == null) {
            crystalMeth = new ItemStack(Material.AMETHYST_SHARD);
            ItemMeta crystalMethMeta = crystalMeth.getItemMeta();
            crystalMethMeta.setCustomModelData(4);
            crystalMethMeta.setDisplayName(ChatColor.GOLD + "Crystal Meth");
            crystalMethMeta.addEnchant(Enchantment.BREACH, 1, true);
            crystalMethMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            crystalMeth.setItemMeta(crystalMethMeta);
        }
    }

    @SuppressWarnings("deprecation")
    private static void createDecorativeAnvil(Plugin plugin) {
        if (decorativeAnvil == null) {
            decorativeAnvil = new ItemStack(Material.ANVIL);
            ItemMeta decorativeAnvilMeta = decorativeAnvil.getItemMeta();
            decorativeAnvilMeta.setCustomModelData(5);
            decorativeAnvilMeta.setDisplayName(ChatColor.AQUA + "Decorative Anvil");
            decorativeAnvilMeta.addEnchant(Enchantment.BREACH, 1, true);
            decorativeAnvilMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore = new ArrayList<>();
            lore.add("Decoration Only - No use");
            decorativeAnvilMeta.setLore(lore);
            decorativeAnvil.setItemMeta(decorativeAnvilMeta);
        }
    }

    public static ItemStack getWeed() {
        if (weed != null) {
            return weed;
        } else
            throw new NullPointerException("Cannot return value of ItemStack weed because weed is NULL");
    }

    public static ItemStack getCocaine() {
        if (cocaine != null) {
            return cocaine;
        } else
            throw new NullPointerException("Cannot return value of ItemStack cocaine because cocaine is NULL");
    }

    public static ItemStack getMidnightMarks() {
        if (midnightMarks != null) {
            return midnightMarks;
        } else
            throw new NullPointerException(
                    "Cannot return value of ItemStack midnightMarks because midnightMarks is NULL");
    }

    public static ItemStack getChemicals() {
        if (chemicals != null) {
            return chemicals;
        } else
            throw new NullPointerException(
                    "Cannot return value of ItemStack chemicals because chemicals is NULL");
    }

    public static ItemStack getLiquidCrystalMeth() {
        if (liquidCrystalMeth != null) {
            return liquidCrystalMeth;
        } else
            throw new NullPointerException(
                    "Cannot return value of ItemStack liquidCrystalMeth because liquidCrystalMeth is NULL");
    }

    public static ItemStack getCrystalMeth() {
        if (crystalMeth != null) {
            return crystalMeth;
        } else
            throw new NullPointerException(
                    "Cannot return value of ItemStack crystalMeth because crystalMeth is NULL");
    }

    public static ItemStack getDecorativeAnvil() {
        if (decorativeAnvil != null) {
            return decorativeAnvil;
        } else
            throw new NullPointerException(
                    "Cannot return value of ItemStack decorativeAnvil because decorativeAnvil is NULL");
    }

    // Return a boolean value indicating whether the given material is a custom item
    @SuppressWarnings("deprecation")
    public static boolean isCustomItem(String material) {
        material = material.toLowerCase().replace('_', ' ');
        if (getChemicals().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        if (getCocaine().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        if (getCrystalMeth().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        if (getDecorativeAnvil().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        if (getLiquidCrystalMeth().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        if (getMidnightMarks().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        if (getWeed().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    public static ItemStack getCustomItem(String material) {
        material = material.toLowerCase().replace('_', ' ');
        if (getChemicals().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getChemicals();
        }
        if (getCocaine().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getCocaine();
        }
        if (getCrystalMeth().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getCrystalMeth();
        }
        if (getDecorativeAnvil().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getDecorativeAnvil();
        }
        if (getLiquidCrystalMeth().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getLiquidCrystalMeth();
        }
        if (getMidnightMarks().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getMidnightMarks();
        }
        if (getWeed().getItemMeta().getDisplayName().toLowerCase().contains(material)) {
            return getWeed();
        }
        return null;
    }



}
