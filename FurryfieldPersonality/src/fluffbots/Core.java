package fluffbots;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

public abstract class Core {

	public abstract void processMessage(MessageReceivedEvent event);
	
}
