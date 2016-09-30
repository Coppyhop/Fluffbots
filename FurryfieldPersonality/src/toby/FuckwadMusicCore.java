package toby;

import fluffbots.Core;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.entities.MessageChannel;
import net.dv8tion.jda.entities.VoiceChannel;

public class FuckwadMusicCore extends Core{

	String musicUrl = "http://198.24.145.146:9780/stream";

	public FuckwadMusicCore(JDA toby){
	
		VoiceChannel channel = toby.getGuildById("182574336039845889").getVoiceChannels().stream().filter(vChan -> vChan.getId().equalsIgnoreCase("182944905914613760")).findFirst().orElse(null);
		toby.getGuildById("182574336039845889").getAudioManager().openAudioConnection(channel);
		
	}
	
	public void processMessage(MessageChannel channel, String message, String id) {
		
		
		
	}
	
}
