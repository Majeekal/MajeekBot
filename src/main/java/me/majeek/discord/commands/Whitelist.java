package me.majeek.discord.commands;

import me.majeek.utils.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Whitelist extends ListenerAdapter {
    private static List<String> whitelisted = new ArrayList<>();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        EmbedBuilder builder = new EmbedBuilder();
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("~whitelist")){
            if(event.getAuthor().getAsTag().equalsIgnoreCase("Majeek#3511")){
                if(message.length >= 3) {
                    if (message[1].equalsIgnoreCase("add")) {
                        if (whitelisted.contains(message[2])) {
                            builder.setColor(Color.RED.getColor());
                            builder.setTitle(message[2] + " is already whitelisted!");
                        } else {
                            whitelisted.add(message[2]);

                            builder.setColor(Color.GREEN.getColor());
                            builder.setTitle(message[2] + " is now whitelisted!");
                        }

                        event.getChannel().sendMessage(builder.build()).queue();
                    } else if (message[1].equalsIgnoreCase("remove")) {
                        if (whitelisted.contains(message[2])) {
                            whitelisted.remove(message[2]);

                            builder.setColor(Color.GREEN.getColor());
                            builder.setTitle(message[2] + " is now removed from the whitelist!");
                        } else {
                            builder.setColor(Color.RED.getColor());
                            builder.setTitle(message[2] + " was not whitelisted!");
                        }

                        event.getChannel().sendMessage(builder.build()).queue();
                    } else {
                        builder.setColor(Color.RED.getColor());
                        builder.setTitle("Invalid use of this command!");

                        event.getChannel().sendMessage(builder.build()).queue();
                    }
                } else if(message.length >= 2){
                    if(message[1].equalsIgnoreCase("get")){
                        builder.setColor(Color.GREEN.getColor());
                        builder.setTitle("Whitelist:");

                        StringBuilder tags = new StringBuilder();
                        for(int i = 0; i < whitelisted.size(); i++){
                            if(i == whitelisted.size() - 1){
                                tags.append(whitelisted.get(i));
                            } else{
                                tags.append(whitelisted.get(i));
                                tags.append("\n");
                            }
                        }

                        builder.setDescription(tags.toString());

                        event.getChannel().sendMessage(builder.build()).queue();
                    }
                } else{
                    builder.setColor(Color.RED.getColor());
                    builder.setTitle("Invalid use of this command!");

                    event.getChannel().sendMessage(builder.build()).queue();
                }
            } else{
                builder.setColor(Color.RED.getColor());
                builder.setTitle("Your not Majeek!");

                event.getChannel().sendMessage(builder.build()).queue();
            }
        }
    }

    public static List<String> getWhitelisted() {
        return whitelisted;
    }
}
