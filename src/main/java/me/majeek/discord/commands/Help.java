package me.majeek.discord.commands;

import me.majeek.utils.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("~help")){
            EmbedBuilder builder = new EmbedBuilder();

            builder.setColor(Color.YELLOW.getColor());
            builder.setDescription("**Commands:**\n`~help` - Displays help command." +
                    "\n`~scale <note> [mode]` - Displays scale of root note with optional mode." +
                    "\n`~whitelist <add/remove> <tag>` - Only available to Majeek :D." +
                    "\n`~whitelist <get>` - Displays people on the whitelist." +
                    "\n`~spam <tag> <amount> [message]` - Only available to whitelisted people." +
                    "\n`~meme` - Displays random memes.");

            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
