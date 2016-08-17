package com.funsize.ffield.bots;

import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.MessageChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;
import toby.AiCore;

public class TobyAdapter  extends ListenerAdapter{

	AiCore core;
	
	public TobyAdapter(){
		
		core = new AiCore();
		
	}
	
    public void onMessageReceived(MessageReceivedEvent event)
    {
    	
		System.out.print("[INFO] Toby message recieved!");
		
    	MessageChannel channel = event.getChannel();
    	Message message = event.getMessage();
    	String id = event.getAuthor().getId();
    	
    	core.processMessage(channel, message.getContent(), id);
 
    	if (message.getContent().startsWith("!")) message.deleteMessage();
    	 
    }	

}
