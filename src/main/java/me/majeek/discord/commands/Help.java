package me.majeek.discord.commands;

import me.majeek.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Help extends ListenerAdapter {
    private Color yellow = new Color(255, 255, 0);

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(!event.getAuthor().isBot() && Main.getInstance().getConfig().getString("server-id").equalsIgnoreCase(event.getGuild().getId())){
            String[] message = event.getMessage().getContentRaw().split(" ");

            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(yellow);

            if(message[0].equalsIgnoreCase("~help")){
                builder.setDescription("**Commands:**\n`~help` - Displays help command.\n`~username <name>` - Sets your minecraft username.");
                event.getChannel().sendMessage(builder.build()).queue();
            }
        }
    }
}
