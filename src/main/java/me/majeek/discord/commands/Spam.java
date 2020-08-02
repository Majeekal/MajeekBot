package me.majeek.discord.commands;

import me.majeek.Main;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Spam extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getAuthor().getAsTag().equalsIgnoreCase("Majeek#2260")){
            String[] message = event.getMessage().getContentRaw().split(" ");

            if(message[0].equalsIgnoreCase("~spam") && message.length > 3){
                User user = Main.getInstance().getJda().getUserByTag(message[1]);
                int amount = Integer.parseInt(message[2]);
                String send = Arrays.toString(Arrays.copyOfRange(message, 3, message.length));

                send = send.replace("[", "");
                send = send.replace(",", "");
                send = send.replace("]", "");

                if(user != null){
                    String finalSend = send;

                    new BukkitRunnable() {
                        int i = 1;

                        @Override
                        public void run() {
                            if(i > amount){
                                cancel();
                            } else{
                                user.openPrivateChannel().flatMap(channel -> channel.sendMessage(finalSend)).queue();
                            }

                            i++;
                        }
                    }.runTaskTimer(Main.getInstance(), 0L, 25L);
                }
            }
        }
    }
}
