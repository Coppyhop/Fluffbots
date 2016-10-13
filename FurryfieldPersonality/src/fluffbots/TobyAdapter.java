package fluffbots;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public class TobyAdapter  extends ListenerAdapter{

	List<Core> cores = new ArrayList<Core>();	
		
    public void onMessageReceived(MessageReceivedEvent event)
    {    		    	
    	
    	for(Core core:cores){
    		
    		core.processMessage(event);
    	
    	}    	
    	
    	
    	if(event.getMessage().getContent().equals("t!debug@cores")){
    		
    		String clist = "";
    		
    		for(Core name:cores){
    			clist = clist + name.toName()+ ", ";
    		}
    		
    		event.getChannel().sendMessage("Currently loaded cores: " + clist + "Fluffbot Debug");
    		
    	}
    	
    	if(event.getMessage().getContent().equals("t!debug@restart")){
    		
    		event.getChannel().sendMessage("[ERROR] No string found for \"com.funzy.fluffbot.debug.reboot\"");
    		
    		if(event.getAuthor().getId().equals("125716989569269760")){
    			System.exit(0);
    		} else {
    			event.getChannel().sendMessage("[ERROR] The user is missing the required permission");
    		}
    		
    	}
    	 
    }	
    
    public void addCore(Core core){
    	
    	cores.add(core);
    	
    }

}
