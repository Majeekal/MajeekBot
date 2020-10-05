package me.majeek.discord.commands;

import me.majeek.Main;
import me.majeek.utils.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.ErrorHandler;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.ErrorResponse;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Spam extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        EmbedBuilder builder = new EmbedBuilder();
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("~spam")) {
            if(message.length >= 4) {
                if (Whitelist.getWhitelisted().contains(event.getAuthor().getAsTag())) {
                    User user = Main.getInstance().getJda().getUserByTag(message[1]);
                    int amount = Integer.parseInt(message[2]);
                    String send = Arrays.toString(Arrays.copyOfRange(message, 3, message.length));

                    send = send.replace("[", "");
                    send = send.replace(",", "");
                    send = send.replace("]", "");

                    if (user != null) {
                        String finalSend = send;

                        builder.setColor(Color.GREEN.getColor());
                        builder.setTitle("You are now spamming " + user.getAsTag() + "!");
                        event.getChannel().sendMessage(builder.build()).queue();

                        new BukkitRunnable() {
                            int i = 1;

                            @Override
                            public void run() {
                                if (i > amount) {
                                    cancel();
                                } else {
                                    AtomicBoolean sent = new AtomicBoolean(true);
                                    user.openPrivateChannel().flatMap(channel -> channel.sendMessage(finalSend)).queue(null, new ErrorHandler().ignore(ErrorResponse.UNKNOWN_MESSAGE).handle(ErrorResponse.CANNOT_SEND_TO_USER, (e) -> sent.set(false)));

                                    if(!sent.get()){
                                        builder.setColor(Color.RED.getColor());
                                        builder.setTitle("Unable to spam " + user.getAsTag() + "!");
                                        event.getChannel().sendMessage(builder.build()).queue();
                                        return;
                                    }
                                }

                                i++;
                            }
                        }.runTaskTimer(Main.getInstance(), 0L, 25L);
                    } else{
                        builder.setColor(Color.RED.getColor());
                        builder.setTitle("User is invalid");
                        event.getChannel().sendMessage(builder.build()).queue();
                    }
                } else {
                    builder.setColor(Color.RED.getColor());
                    builder.setTitle("You are not whitelisted to use this command!");

                    event.getChannel().sendMessage(builder.build()).queue();
                }
            } else{
                builder.setColor(Color.RED.getColor());
                builder.setTitle("Invalid use of this command!");

                event.getChannel().sendMessage(builder.build()).queue();
            }
        }
    }
}
