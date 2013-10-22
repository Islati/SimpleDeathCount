package com.caved_in.simpledeathcount.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.caved_in.simpledeathcount.DeathCount;

public class PlayerDied implements Listener
{
	
	public PlayerDied(DeathCount Plugin)
	{
		Plugin.getServer().getPluginManager().registerEvents(this, Plugin);
	}
	
	@EventHandler
	public void OnPlayerDeath(PlayerDeathEvent Event)
	{
		DeathCount.DeathScore.addDeath(Event.getEntity().getName());
		DeathCount.Scoreboard.setScore(Event.getEntity(), DeathCount.DeathScore.getDeaths(Event.getEntity().getName()));
	}

}
