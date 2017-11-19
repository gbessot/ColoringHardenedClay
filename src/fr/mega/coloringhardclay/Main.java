package fr.mega.coloringhardclay;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import static java.lang.Math.abs;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ColoringHardClay] Enabled.");

        for(short i = 0; i < 16; i++) {
            for(short j = 0; j < 16; j++) {
                if(i != j)
                    setHCCraft(i, j);
            }
        }

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ColoringHardClay] Disabled.");
    }

    public void setHCCraft(short srcColor, short dstColor) {
        ItemStack resultat = new ItemStack(Material.STAINED_CLAY, 8);
        resultat.setDurability((short) (15-dstColor));

        ShapedRecipe hcColored = new ShapedRecipe(new ItemStack(resultat));
        hcColored.shape("SSS", "SDS", "SSS");
        hcColored.setIngredient('S', Material.STAINED_CLAY, abs(srcColor-15));
        hcColored.setIngredient('D', Material.INK_SACK, dstColor);

        getServer().addRecipe(hcColored);
    }
}