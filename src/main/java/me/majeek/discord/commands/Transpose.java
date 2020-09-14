package me.majeek.discord.commands;

import me.majeek.utils.Color;
import me.majeek.utils.Note;
import me.majeek.utils.NoteUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Transpose extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("~transpose")){
            EmbedBuilder builder = new EmbedBuilder();

            if(message.length < 4){
                builder.setColor(Color.RED.getColor());
                builder.setDescription("Invalid command arguments.");
                event.getChannel().sendMessage(builder.build()).queue();
                return;
            }

            String first_input = message[1];
            String second_input = message[2];
            String note_input = message[3];

            Note first = NoteUtil.stringToNote(first_input);
            Note second = NoteUtil.stringToNote(second_input);
            Note note = NoteUtil.stringToNote(note_input);

            if(first == null || second == null || note == null){
                builder.setColor(Color.RED.getColor());
                builder.setDescription("Invalid note!");
                event.getChannel().sendMessage(builder.build()).queue();
                return;
            }

            builder.setColor(Color.GREEN.getColor());
            builder.setTitle(first.getName() + " instrument to " + second.getName() + " instrument");
            builder.setDescription(NoteUtil.halfStepDown(note, NoteUtil.halfStepDifference(first, second)).getName());

            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
