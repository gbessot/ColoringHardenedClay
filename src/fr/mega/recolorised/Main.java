package fr.mega.recolorised;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import static java.lang.Math.abs;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        for(short i = 0; i < 16; i++) {
            for(short j = 0; j < 16; j++) {
                if(i != j) {
                    setHCCraft(i, j);
                    setSGCraft(i, j);
                    setGPCraft(i, j);
                }
            }
        }
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Recolorised] Enabled.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Recolorised] Disabled.");
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

    public void setSGCraft(short srcColor, short dstColor) {
        ItemStack resultat = new ItemStack(Material.STAINED_GLASS, 8);
        resultat.setDurability((short) (15-dstColor));

        ShapedRecipe sgColored = new ShapedRecipe(new ItemStack(resultat));
        sgColored.shape("SSS", "SDS", "SSS");
        sgColored.setIngredient('S', Material.STAINED_GLASS, abs(srcColor-15));
        sgColored.setIngredient('D', Material.INK_SACK, dstColor);

        getServer().addRecipe(sgColored);
    }

    public void setGPCraft(short srcColor, short dstColor) {
        ItemStack resultat = new ItemStack(Material.STAINED_GLASS_PANE, 8);
        resultat.setDurability((short) (15-dstColor));

        ShapedRecipe gpColored = new ShapedRecipe(new ItemStack(resultat));
        gpColored.shape("SSS", "SDS", "SSS");
        gpColored.setIngredient('S', Material.STAINED_GLASS_PANE, abs(srcColor-15));
        gpColored.setIngredient('D', Material.INK_SACK, dstColor);

        getServer().addRecipe(gpColored);
    }
}