package me.majeek.discord.commands;

import me.majeek.utils.Color;
import me.majeek.utils.Note;
import me.majeek.utils.NoteUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Scale extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] message = event.getMessage().getContentRaw().split(" ");
        String command_input = message[0];

        if(command_input.equalsIgnoreCase("~scale")){
            EmbedBuilder builder = new EmbedBuilder();

            if(message.length < 2){
                builder.setColor(Color.RED.getColor());
                builder.setDescription("I need a note!");
                event.getChannel().sendMessage(builder.build()).queue();
                return;
            }

            String note_input = message[1];
            List<Note> scale = null;
            
            for(Note note : Note.values()){
                if(note.getName().equalsIgnoreCase(note_input)){
                        scale = NoteUtil.getScale(note);
                }
            }
            
            if(scale == null) {
                builder.setColor(Color.RED.getColor());
                builder.setDescription("Invalid note!");
                event.getChannel().sendMessage(builder.build()).queue();
                return;
            }

            StringBuilder formatted = new StringBuilder();
            for(int i = 0; i < scale.size(); i++){
                if(i == 0){
                    formatted.append(scale.get(i).getName());
                } else{
                    formatted.append(" ").append(scale.get(i).getName());
                }
            }

            builder.setColor(Color.GREEN.getColor());
            builder.setTitle(scale.get(0).getName() + " Major Scale");
            builder.setDescription(formatted.toString());
            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
