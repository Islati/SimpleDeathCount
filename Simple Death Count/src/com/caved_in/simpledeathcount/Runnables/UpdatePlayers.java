package com.caved_in.Runnables;

import com.caved_in.DeathCount;

public class UpdatePlayers implements Runnable
{

	@Override
	public void run()
	{
		DeathCount.Scoreboard.UpdatePlayers();
	}

}
