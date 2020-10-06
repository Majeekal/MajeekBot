package me.majeek.discord.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Meme extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("~meme")){
            TextChannel channel = event.getJDA().getTextChannelById("762463195633680405");
            List<Message> memes = channel.getHistoryFromBeginning(100).complete().getRetrievedHistory();

            Message random = memes.get((int) (Math.random() * memes.size()));

            if(random.getAttachments().size() != 0){
                Message.Attachment attachment = random.getAttachments().get(0);

                CompletableFuture<File> file = attachment.downloadToFile();

                try {
                    event.getChannel().sendFile(file.get()).queue();
                    boolean deleted = file.get().delete();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            } else{
                event.getChannel().sendMessage(random.getContentRaw()).queue();
            }
        }
    }
}
