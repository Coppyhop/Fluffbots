package fluffbots;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import toby.TobyAdapter;
import zira.ZiraAdapter;

public class Main {

	static JDA toby;//, zira;
	static String ts = "Toby v3.0.0";//, zs = "Zira v0.0.1";
	
	static String token1;//, token2;
	
	public static void main(String[] args) {
		
		try
		
        {
			
			Properties prop = new Properties();
			
			
			File file1 = new  File("config.properties");
			
			File file2 = new File(file1.getAbsolutePath().trim());
			
			System.out.println(file2.getAbsolutePath());
			
			InputStream stream = new FileInputStream(file2);
			
			prop.load(stream);
 
			token1 = prop.getProperty("token1");
			//token2 = prop.getProperty("token2");
			
			toby = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken(token1).buildBlocking();
			toby.getAccountManager().setGame(ts);
			toby.addEventListener(new TobyAdapter());

			/*
			zira = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken(token2).buildBlocking();
        	zira.getAccountManager().setGame(zs);
        	zira.addEventListener(new ZiraAdapter());
        	*/

        }
		
        catch (Exception e)
		
        {
        	e.printStackTrace();
        }

	}
	
	

}
