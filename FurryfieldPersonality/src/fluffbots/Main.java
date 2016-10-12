package fluffbots;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

public class Main {

	static JDA toby;
	
	static String ts;
	static String token;
	
	static TobyAdapter adapter;
	
	static List<String> cores = new ArrayList<String>();
	static ModuleLoader<Core> loader = new ModuleLoader<Core>();  
	
	public static void main(String[] args) {
		
		try
		
        {
			
			System.out.println("[INFO] Loading main bot properties...");
			
			Properties prop = new Properties();
			
			File file1 = new  File("config.properties");
			File file2 = new File(file1.getAbsolutePath().trim());
			
			System.out.println("[INFO] Properties path should be " + file2.getAbsolutePath());
			
			InputStream stream = new FileInputStream(file2);
			
			prop.load(stream);
 
			System.out.println("[INFO] Properties loaded, trying to extract token...");
			
			token = prop.getProperty("token");
			ts = prop.getProperty("version");
			
			System.out.println("[INFO] Token extracted, building JDA...");
			
			toby = new JDABuilder().setBulkDeleteSplittingEnabled(false).setBotToken(token).buildBlocking();
			toby.getAccountManager().setGame(ts);
			
			System.out.println("[INFO] Loading Modules...");			
			System.out.println("[INFO] Loading definition file...");
			
			Scanner scanner = new Scanner(new File("modules.txt"));
			
			while(scanner.hasNextLine()){
				cores.add(scanner.nextLine());
			}
			
			scanner.close();
			
			adapter = new TobyAdapter();
			
			for(String s: cores){
			Core core = loader.LoadClass("/modules/", s, Core.class);
			System.out.println("[INFO] Adding new core " + core.toName());
			adapter.addCore(core);  
			}
			
			System.out.println("[INFO] Startup complete.");
			
			toby.addEventListener(adapter);

        }
		
        catch (Exception e)
		
        {
        	e.printStackTrace();
        }

	}
	
}
