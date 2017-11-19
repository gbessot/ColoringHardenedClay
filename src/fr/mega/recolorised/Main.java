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
                    setRecoloringCraft(Material.STAINED_CLAY, i, j);
                    setRecoloringCraft(Material.STAINED_GLASS, i, j);
                    setRecoloringCraft(Material.STAINED_GLASS_PANE, i, j);
                }
            }
        }
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Recolorised] Enabled.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Recolorised] Disabled.");
    }

    public void setRecoloringCraft(Material mat, short srcColor, short dstColor) {
        ItemStack resultat = new ItemStack(mat, 8);
        resultat.setDurability((short) (15-dstColor));

        ShapedRecipe recolored = new ShapedRecipe(new ItemStack(resultat));
        recolored.shape("SSS", "SDS", "SSS");
        recolored.setIngredient('S', mat, abs(srcColor-15));
        recolored.setIngredient('D', Material.INK_SACK, dstColor);

        getServer().addRecipe(recolored);
    }
}