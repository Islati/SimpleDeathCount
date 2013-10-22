package com.caved_in.simpledeathcount.handler.config;

import org.bukkit.entity.Player;

import com.caved_in.simpledeathcount.handler.YML.YML_Wrapper;

public class ScoreKeep
{
	private YML_Wrapper Wrapper;
	private String Player_Death_Path = ".Deaths";
	
	public ScoreKeep(String Location)
	{
		this.Wrapper = new YML_Wrapper(Location);
	}
	
	public String getPlayerPath(Player Player)
	{
		return this.getPlayerPath(Player.getName());
	}
	
	public String getPlayerPath(String PlayerName)
	{
		return PlayerName + this.Player_Death_Path;
	}
	
	public int getDeaths(String PlayerName)
	{
		return Wrapper.getInt(this.getPlayerPath(PlayerName));
	}
	
	public void setDeath(String PlayerName, int Deaths)
	{
		Wrapper.setInt(this.getPlayerPath(PlayerName), Deaths);
	}
	
	public void addDeath(String PlayerName)
	{
		this.setDeath(PlayerName, (this.getDeaths(PlayerName) + 1));
	}
	
	public boolean hasScore(String PlayerName)
	{
		return this.Wrapper.Contains(this.getPlayerPath(PlayerName));
	}
	
	public void defaultScore(String PlayerName)
	{
		this.setDeath(PlayerName, 0);
	}
}
