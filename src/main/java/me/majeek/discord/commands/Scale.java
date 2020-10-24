package me.majeek.discord.commands;

import me.majeek.utils.Color;
import me.majeek.utils.ModeType;
import me.majeek.utils.Note;
import me.majeek.utils.NoteType;
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

            String root_input = message[1];

            if(Note.stringToNote(root_input) == null){
                builder.setColor(Color.RED.getColor());
                builder.setDescription("Invalid note!");
                event.getChannel().sendMessage(builder.build()).queue();
                return;
            }

            NoteType root = Note.stringToNote(root_input);
            ModeType mode = null;

            if(message.length >= 3){
                for(ModeType modeType : ModeType.values()){
                    if(modeType.getName().equalsIgnoreCase(message[2])){
                        mode = modeType;
                    }
                }

                if(mode == null){
                    builder.setColor(Color.RED.getColor());
                    builder.setDescription("Invalid mode!");
                    event.getChannel().sendMessage(builder.build()).queue();
                    return;
                }
            } else{
                mode = ModeType.IONIAN;
            }

            me.majeek.utils.Scale scale = new me.majeek.utils.Scale(root, mode);

            List<NoteType> notes = scale.getNotes();
            StringBuilder formatted = new StringBuilder();

            for(int i = 0; i < notes.size(); i++){
                if(i == 0){
                    formatted.append(notes.get(i).getName());
                } else{
                    formatted.append(" ").append(notes.get(i).getName());
                }
            }

            builder.setColor(Color.GREEN.getColor());
            builder.setTitle(scale.getRoot().getName() + " " + scale.getMode().getName() + " Scale");
            builder.setDescription(formatted.toString());
            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
