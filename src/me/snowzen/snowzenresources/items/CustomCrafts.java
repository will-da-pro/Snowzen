package me.snowzen.snowzenresources.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class CustomCrafts extends GetCustomItem {
	public static ShapedRecipe hardDiamondSword() {
		ItemStack hds = getItemFromConfig("hardened-diamond-sword");
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "recipe-name"), hds);
		recipe.shape("ada", "ada", "asa");
		recipe.setIngredient('a', Material.AIR);
		recipe.setIngredient('d', Material.DIAMOND_BLOCK);
		recipe.setIngredient('s', Material.STICK);
		return recipe;
	}
	public static ShapedRecipe compressedDiamond() {
		ItemStack compressedDiamond = getItemFromConfig("compressed-diamond");
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "recipe-name"), compressedDiamond);
		recipe.shape("ada", "ddd", "ada");
		recipe.setIngredient('d', Material.DIAMOND);
		return recipe;
	}
	public static ShapedRecipe masterSword() {
		ItemStack masterSword = getItemFromConfig("master-sword");
		RecipeChoice compressedDiamond = new RecipeChoice.ExactChoice(getItemFromConfig("compressed-diamond"));
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "recipe-name"), masterSword);
		recipe.shape("ada", "ada", "asa");
		recipe.setIngredient('a', Material.AIR);
		recipe.setIngredient('d', compressedDiamond);
		recipe.setIngredient('s', Material.STICK);
		return recipe;
	}
}
