package me.majeek.discord.commands;

import me.majeek.Main;
import me.majeek.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Username extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(!event.getAuthor().isBot() && Main.getInstance().getConfig().getString("server-id").equalsIgnoreCase(event.getGuild().getId())){
            String[] message = event.getMessage().getContentRaw().split(" ");

            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.YELLOW.getColor());

            if(message[0].equalsIgnoreCase("~username")){
                if(message.length <= 1){
                    builder.setDescription("Your username has been reset.");

                    List<String> names = Main.getInstance().getConfig().getStringList("minecraft-names");
                    List<String> tags = Main.getInstance().getConfig().getStringList("discord-tags");

                    for(int i = 0; i < tags.size(); i++){
                        if(tags.get(i).equals(event.getAuthor().getAsTag())){
                            names.remove(i);
                            tags.remove(i);
                            break;
                        }
                    }

                    Main.getInstance().getConfig().set("minecraft-names", names);
                    Main.getInstance().getConfig().set("discord-tags", tags);
                } else{
                    builder.setDescription("Your username has been set to **" + message[1] + "**.");

                    List<String> names = Main.getInstance().getConfig().getStringList("minecraft-names");
                    List<String> tags = Main.getInstance().getConfig().getStringList("discord-tags");

                    if(tags.contains(event.getAuthor().getAsTag())) {
                        for (int i = 0; i < tags.size(); i++) {
                            if (tags.get(i).equals(event.getAuthor().getAsTag())) {
                                names.set(i, message[1]);
                                break;
                            }
                        }
                    } else{
                        names.add(message[1]);
                        tags.add(event.getAuthor().getAsTag());
                    }

                    Main.getInstance().getConfig().set("minecraft-names", names);
                    Main.getInstance().getConfig().set("discord-tags", tags);
                }

                Main.getInstance().saveConfig();
                event.getChannel().sendMessage(builder.build()).queue();
            }
        }
    }
}
