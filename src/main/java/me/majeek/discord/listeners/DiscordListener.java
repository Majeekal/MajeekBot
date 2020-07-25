package me.majeek.discord.listeners;

import me.majeek.Main;
import me.majeek.discord.commands.Help;
import me.majeek.discord.commands.Username;
import me.majeek.minecraft.MinecraftChat;

public class DiscordListener {
    public DiscordListener(Main instance){
        instance.getJda().addEventListener(new Help());
        instance.getJda().addEventListener(new Username());
        instance.getJda().addEventListener(new MinecraftChat());
    }
}
