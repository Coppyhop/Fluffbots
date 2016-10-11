package fluffbots;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

public class Main {

	static JDA toby;
	
	static String ts;
	static String token;
	
	static TobyAdapter adapter;
	
	public static void main(String[] args) {
		
		try
		
        {
			
			Properties prop = new Properties();
			
			File file1 = new  File("config.properties");
			File file2 = new File(file1.getAbsolutePath().trim());
			
			System.out.println(file2.getAbsolutePath());
			
			InputStream stream = new FileInputStream(file2);
			
			prop.load(stream);
 
			token = prop.getProperty("token");
			ts = prop.getProperty("version");
			
			toby = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken(token).buildBlocking();
			toby.getAccountManager().setGame(ts);
			
			adapter = new TobyAdapter();
			adapter.addCore(new TestCore());
			
			toby.addEventListener(adapter);

        }
		
        catch (Exception e)
		
        {
        	e.printStackTrace();
        }

	}
	
}
