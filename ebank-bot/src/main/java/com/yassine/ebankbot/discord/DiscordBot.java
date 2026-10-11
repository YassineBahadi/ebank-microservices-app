package com.yassine.ebankbot.discord;

import com.yassine.ebankbot.agents.EbankAIAgent;
import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.ai.chat.prompt.Prompt;

/**
 * @author pc
 **/
@DiscordController
public class DiscordBot {
    private EbankAIAgent ebankAIAgent;

    public DiscordBot(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @DiscordMapping
    private void perform(MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        String query=event.getMessage().getContentRaw();
        String response=ebankAIAgent.chat(query);
        event.getChannel().sendMessage(response).queue();
    }
}
