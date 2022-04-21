package ru.masterclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;

public class Events implements Listener
{
	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEvent e)
	{
		ItemStack item = e.getPlayer().getItemInHand();
		if (item == null) {return;}
		
		if (item.getType().equals(Material.STICK))
		{
			ItemMeta meta = item.getItemMeta();
			if (meta.getDisplayName().equals("SUPER STICK")) 
			{
				Location loc = e.getClickedBlock().getLocation().add(0, 1, 0);
				Entity ent = e.getPlayer().getWorld().spawnEntity(loc, EntityType.VILLAGER);
				ent.setCustomName("SUPER TRADER");
				ent.setCustomNameVisible(true);
			}
		}
	}
	
	@EventHandler
	public void PlayerInterewfjgfu(PlayerInteractAtEntityEvent e)
	{
		if (e.getRightClicked().getType().equals(EntityType.VILLAGER))
		{
			Villager villager = (Villager) e.getRightClicked();
			if (villager.getCustomName().equals("SUPER TRADER"))
			{
				ItemStack resultItem = new ItemStack(Material.CARROT);
				ItemMeta meta = resultItem.getItemMeta();
				meta.setDisplayName("ß6ßl –”“¿ﬂ ÃŒ– Œ¬ ¿");
				resultItem.setItemMeta(meta);
				
				MerchantRecipe recipe = new MerchantRecipe(resultItem, 5);
				recipe.setIngredients(Arrays.asList(new ItemStack(Material.DIRT, 6)));
	
				villager.setProfession(Profession.FLETCHER);
				villager.setRecipes(Arrays.asList(recipe));
			}
		}
	}
}