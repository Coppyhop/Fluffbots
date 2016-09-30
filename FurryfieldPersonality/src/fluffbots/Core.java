package fluffbots;

import net.dv8tion.jda.entities.MessageChannel;

public abstract class Core {

	public abstract void processMessage(MessageChannel channel, String message, String id);
}
