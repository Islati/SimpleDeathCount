package com.caved_in.simpledeathcount.handler.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.caved_in.simpledeathcount.DeathCount;

public class ScoreboardHandler
{
	private DeathCount Plugin;
	private ScoreboardManager Manager;
	private Scoreboard Board;
	private Objective Objective;

	public ScoreboardHandler(DeathCount Plugin)
	{
		this.Plugin = Plugin;
		this.Manager = this.Plugin.getServer().getScoreboardManager();
		this.Board = this.Manager.getNewScoreboard();
		this.Objective = this.Board.registerNewObjective("Deaths", "dummy");
		this.Objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
		this.Objective.setDisplayName(ChatColor.RED + "Deaths");
	}

	public void UpdatePlayer(Player Player)
	{
		Player.setScoreboard(this.Board);
	}
	
	public void setScore(Player Player, int Deaths)
	{
		Score DeathScore = this.Objective.getScore(Player);
		DeathScore.setScore(Deaths);
	}
	
	public int getScore(Player Player)
	{
		return this.Objective.getScore(Player).getScore();
	}

	public void UpdatePlayers()
	{
		for (Player P : Bukkit.getOnlinePlayers())
		{
			UpdatePlayer(P);
		}
	}

	public OfflinePlayer getFakePlayer(String Name)
	{
		return Bukkit.getOfflinePlayer(Name);
	}
}