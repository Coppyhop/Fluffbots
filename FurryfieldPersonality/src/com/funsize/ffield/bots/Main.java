package com.funsize.ffield.bots;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

public class Main {

	static JDA toby, zira;
	static String ts = "Toby v3.0.0", zs = "Zira v0.0.1";
	
	public static void main(String[] args) {
		
		try
		
        {
			
			toby = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken("").buildBlocking();
			toby.getAccountManager().setGame(ts);
			toby.getAccountManager().setNickname(toby.getGuildById("182574336039845889"), "Toby");
			toby.addEventListener(new TobyAdapter());

			zira = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken("").buildBlocking();
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
