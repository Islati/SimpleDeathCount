package com.caved_in.simpledeathcount.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.caved_in.simpledeathcount.DeathCount;

public class JoinEvent implements Listener
{
	
	public JoinEvent(DeathCount Plugin)
	{
		Plugin.getServer().getPluginManager().registerEvents(this, Plugin);
	}

	@EventHandler
	public void PlayerJoins(PlayerJoinEvent Event)
	{
		DeathCount.Scoreboard.UpdatePlayer(Event.getPlayer());
		if (DeathCount.DeathScore.hasScore(Event.getPlayer().getName()))
		{
			DeathCount.Scoreboard.setScore(Event.getPlayer(), DeathCount.DeathScore.getDeaths(Event.getPlayer().getName()));
		}
		else
		{
			DeathCount.DeathScore.defaultScore(Event.getPlayer().getName());
			DeathCount.Scoreboard.setScore(Event.getPlayer(), 0);
		}
		//DeathCount.Scoreboard.UpdatePlayer(Event.getPlayer());
	}
	
}
