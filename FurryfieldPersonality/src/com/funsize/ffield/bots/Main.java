package com.funsize.ffield.bots;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

public class Main {

	static JDA toby, zira;
	static String ts = "Toby v3.0.0", zs = "Zira v0.0.1";
	
	public static void main(String[] args) {
		
		try
		
        {
			
			toby = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken("MjA2MjcwMDM2ODc1MjgwMzk0.CnSHcQ.pq-wNEPMUYFAWK243CS7H5mL-z4").buildBlocking();
			toby.getAccountManager().setGame(ts);
			toby.getAccountManager().setNickname(toby.getGuildById("182574336039845889"), "Toby");
			toby.addEventListener(new TobyAdapter());

			zira = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken("MjEzODM4ODE5MjIzNDA0NTQ0.CpAhdA.8QFhEFhIqcS80TvGcLHpJGqOrIw").buildBlocking();
        	zira.getAccountManager().setNickname(zira.getGuildById("182574336039845889"), "Zira");
        	zira.getAccountManager().setGame(zs);
        	zira.addEventListener(new ZiraAdapter());

        }
		
        catch (Exception e)
		
        {
        	e.printStackTrace();
        }

	}

}
