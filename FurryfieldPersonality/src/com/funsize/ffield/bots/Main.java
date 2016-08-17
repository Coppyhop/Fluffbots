package com.funsize.ffield.bots;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

public class Main {

	static JDA toby, zira;
	static String ts = "Toby v3.0.0", zs = "Zira v0.0.1";
	
	static String token1, token2;
	
	public static void main(String[] args) {
		
		try
		
        {
			
			Properties prop = new Properties();
			
			
			File harold = new  File("config.properties");
			
			File ssss = new File(harold.getAbsolutePath().trim());
			
			System.out.println(ssss.getAbsolutePath());
			
			InputStream bob = new FileInputStream(ssss);
			
			prop.load(bob);
 
			token1 = prop.getProperty("token1");
			token2 = prop.getProperty("token2");
			
			toby = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken(token1).buildBlocking();
			toby.getAccountManager().setGame(ts);
			toby.getAccountManager().setNickname(toby.getGuildById("182574336039845889"), "Toby");
			toby.addEventListener(new TobyAdapter());

			zira = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken(token2).buildBlocking();
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
