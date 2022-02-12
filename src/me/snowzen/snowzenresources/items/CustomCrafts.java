package me.snowzen.snowzenresources.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CustomCrafts extends GetCustomItem {
	public void hardDiamondSword () {
		ItemStack hds = getItemFromConfig("hardened-diamond-sword");
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "recipe-name"), hds);
		recipe.shape("ada", "ada", "asa");
		recipe.setIngredient('a', Material.AIR);
		recipe.setIngredient('d', Material.DIAMOND_BLOCK);
		recipe.setIngredient('s', Material.STICK);
	}
}
