package com.caved_in.simpledeathcount;

import java.io.File;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import com.caved_in.simpledeathcount.handler.Scoreboard.ScoreboardHandler;
import com.caved_in.simpledeathcount.handler.config.ScoreKeep;
import com.caved_in.simpledeathcount.listeners.JoinEvent;
import com.caved_in.simpledeathcount.listeners.PlayerDied;

public class DeathCount extends JavaPlugin
{
	public static ScoreboardHandler Scoreboard;
	public static ScoreKeep DeathScore;
	
	@Override
	public void onEnable()
	{
		if (!new File(getDataFolder() + File.separator + "Deaths.yml").exists())
		{
			this.saveResource("Deaths.yml", false);
		}
		DeathScore = new ScoreKeep(getDataFolder() + File.separator + "Deaths.yml");
		Scoreboard = new ScoreboardHandler(this);
		new PlayerDied(this);
		new JoinEvent(this);
		//this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new UpdatePlayers(), 60L, 60L); <-- Commented as it's inefective
	}

	@Override
	public void onDisable()
	{
		HandlerList.unregisterAll(this);
	}
}
