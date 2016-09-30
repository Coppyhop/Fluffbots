package toby;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.MessageChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public class TobyAdapter  extends ListenerAdapter{

	AiCore core;
	FuckwadMusicCore mcore;
	
	public TobyAdapter(JDA toby){
		
		core = new AiCore();
		mcore = new FuckwadMusicCore(toby);
		
	}
	
    public void onMessageReceived(MessageReceivedEvent event)
    {
    		
    	MessageChannel channel = event.getChannel();
    	Message message = event.getMessage();
    	String id = event.getAuthor().getId();
    	
    	core.processMessage(channel, message.getContent(), id);
    	mcore.processMessage(channel, message.getContent(), id);
 
    	if (message.getContent().startsWith("!")) message.deleteMessage();
    	 
    }	

}
