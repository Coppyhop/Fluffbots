package fluffbots;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

public class TestCore extends Core{

	public void processMessage(MessageReceivedEvent event) {
		
		
		if(event.getMessage().getContent().equals("Test Core working!")){
		event.getChannel().sendMessage("Test Core working!");
		}
		
	}	
	
	public String toName(){
		return "Test Core";
	}
  
}
