package me.majeek.minecraft;

import me.majeek.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MinecraftChat extends ListenerAdapter implements Listener {
    private final Color green = new Color(67, 181, 129);
    private final Color red = new Color(255, 71, 15);

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event){
        List<String> names = Main.getInstance().getConfig().getStringList("minecraft-names");
        List<String> tags = Main.getInstance().getConfig().getStringList("discord-tags");

        Guild guild = Main.getInstance().getJda().getGuildById(Main.getInstance().getConfig().getString("server-id"));
        TextChannel channel = guild.getTextChannelById(Main.getInstance().getConfig().getString("chat-channel-id"));

        String author = event.getPlayer().getName();
        String url = guild.getIconUrl();

        if(names.contains(event.getPlayer().getName())) {
            for (Member member : guild.getMembers()) {
                if (member.getUser().getAsTag().equals(tags.get(names.indexOf(event.getPlayer().getName())))){
                    url = member.getUser().getAvatarUrl();
                }
            }
        }

        EmbedBuilder builder = new EmbedBuilder();

        builder.setColor(green);
        builder.setDescription(event.getMessage());
        builder.setThumbnail(url);
        builder.setAuthor(author, null, url);
        builder.setTimestamp(LocalDateTime.now());

        channel.sendMessage(builder.build()).queue();
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(!event.getAuthor().isBot() && Main.getInstance().getConfig().getString("server-id").equalsIgnoreCase(event.getGuild().getId()) && Main.getInstance().getConfig().getString("chat-channel-id").equalsIgnoreCase(event.getChannel().getId())){
            String message = event.getMessage().getContentRaw();

            event.getMessage().delete().queueAfter(1, TimeUnit.MILLISECONDS);

            EmbedBuilder builder = new EmbedBuilder();

            builder.setColor(green);
            builder.setDescription(message);
            builder.setThumbnail(event.getAuthor().getAvatarUrl());
            builder.setAuthor(event.getAuthor().getAsTag(), null, event.getAuthor().getAvatarUrl());
            builder.setTimestamp(LocalDateTime.now());

            event.getChannel().sendMessage(builder.build()).queue();
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&bDiscord&8]&r " + event.getAuthor().getAsTag() + " " + event.getMessage().getContentRaw()));
        }
    }
}
