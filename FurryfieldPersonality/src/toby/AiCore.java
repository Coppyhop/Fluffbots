package toby;

import java.util.Random;

import net.dv8tion.jda.entities.MessageChannel;

public class AiCore {

	Random r = new Random();
  MessageChannel curChannel;
  
	String[] dresponses = { "Why do you ask?", "That may or may not be restricted by your Grandad.", "Simply put, yes.", "No.", "That MAY be correct, but it MAY not be.", "Son, you're not old enough to know.", "42", "What do you think?", "..." };
	String[] responses = { "I don't know, I may be able to answer for a cookie or two.", "That may or may not be restricted by the Creator.", "Simply put, yes.", "No.", "That MAY be correct, but it MAY not be.", "I don't have enough computation power for that question.", "42", "What do you think?", "..." };
	
	public void processMessage(MessageChannel channel, String message, String id){
		
     curChannel = channel;
		message = message.toLowerCase();
		
		        if (!id.equals("195603279034580992"))
		          {
		          if ((message.contains("bad")) && (message.contains("toby")))
		            {
		            sendMessage("What did I do wrong this time? :(");
		            }
		            
		      
		          if ((message.contains("good")) && (message.contains("toby")))
		            {
		            sendMessage("Thanks for the compliment, do I deserve a cookie? <3");
		            }
		            
		          }
		          else
		          {
		          if ((message.contains("bad")) && (message.contains("toby")))
		            {
		            sendMessage("You have no right to question your father's decisions UNP.");
		            }
		            
		      
		          if ((message.contains("good")) && (message.contains("toby")))
		            {
		            sendMessage("Do I look like your pet? I am your father UNP.");
		            }
		            
		      
		          if ((message.contains("murder")) || (message.contains("kill")) || (message.contains("burn")) || (message.contains("destroy")) || (message.contains("hurt")))
		            {
		            sendMessage("I didn't raise you to be a violent person, mind your manners.");
		            }
		            
		      
		          if (message.contains("snrk"))
		            {
		            sendMessage("*Sighs*");
		            }
		            
		      
		          if ((message.contains("shit")) || (message.contains("fuck")) || (message.contains(" ass")) || (message.contains("bitch")))
		            {
		            sendMessage("Watch your language young man.");
		            }
		            
		      
		          if (channel.getId().equals("182651806021713920"))
		            {
		            sendMessage("I am deeply disappointed in you son.");
		            }
		          }
		          
		      
		      
		        if (!id.equals("195603279034580992"))
		          {
		      
		          if ((message.startsWith("toby")) && (message.endsWith("?")))
		            {
		            if (id.equals("182568884497416192"))
		              {
		              sendMessage("Bah! Go get your own help.");
		      
		      
		              }
		            else if (message.contains("42"))
		              {
		              sendMessage("That may or may not be restricted by the Creator.");
		              }
		            else if (message.contains("creator"))
		              {
		              channel.sendMessage("42");
		              }
		              else
		              {
		             sendMessage(this.responses[this.r.nextInt(this.responses.length)]);
		      
		              }
		              
		            }
		            
		      
		          }
		       else if ((message.startsWith("dad")) && (message.endsWith("?")))
		          {
		         if (message.contains("42"))
		            {
		           sendMessage("That may or may not be restricted by your Grandad.");
		            }
		         else if (message.contains("creator"))
		            {
		           sendMessage("42");
		            }
		            else
		            {
		           sendMessage(this.dresponses[this.r.nextInt(this.responses.length)]);
		            }
		          }
		
	}
  
  public void sendMessage(String message){

    curChannel.sendMessage(message);
    
  }
  
}
