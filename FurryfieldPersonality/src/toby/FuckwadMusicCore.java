package toby;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.UnsupportedAudioFileException;

import fluffbots.Core;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.audio.player.URLPlayer;
import net.dv8tion.jda.entities.MessageChannel;
import net.dv8tion.jda.entities.VoiceChannel;

public class FuckwadMusicCore extends Core{

	String musicUrl = "http://198.24.145.147:9780/;.mp3";
	Player player;
	
	public FuckwadMusicCore(JDA toby){
	
		VoiceChannel channel = toby.getGuildById("182574336039845889").getVoiceChannels().stream().filter(vChan -> vChan.getId().equalsIgnoreCase("182944905914613760")).findFirst().orElse(null);
		toby.getGuildById("182574336039845889").getAudioManager().openAudioConnection(channel);
		
		play(toby);
		
	}
	
	public void processMessage(MessageChannel channel, String message, String id) {
		
		
		
	}
	
	public void play(JDA toby){
		
		 if (player == null)
         {

             URL audioUrl = null;
             try
             {

                 audioUrl = new URL(musicUrl);


                 player = new URLPlayer(toby, audioUrl);

                 toby.getGuildById("182574336039845889").getAudioManager().setSendingHandler(player);

                 player.play();
                 
             }
             catch (IOException e)
             {
            	 toby.getGuildById("182574336039845889").getTextChannels().get(2).sendMessage("Could not load the file. Does it exist?");
                 e.printStackTrace();
             }
             catch (UnsupportedAudioFileException e)
             {
            	 toby.getGuildById("182574336039845889").getTextChannels().get(2).sendMessage("Could not load file. It either isn't an audio file or isn't a" +
                         " recognized audio format.");
                 e.printStackTrace();
}
         }          
	}
}
