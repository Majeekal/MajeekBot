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
                    "\n`~scale <note>` - Displays scale of root note." +
                    "\n`~transpose <instrument1> <instrument2> <note>` - Transposes <note> of <instrument1> to <instrument2>.");

            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
