package me.majeek.discord.listeners;

import me.majeek.Main;
import me.majeek.discord.commands.*;

public class DiscordListener {
    public DiscordListener(Main instance){
        instance.getJda().addEventListener(new Help());
        instance.getJda().addEventListener(new Meme());
        instance.getJda().addEventListener(new Scale());
        instance.getJda().addEventListener(new Spam());
        instance.getJda().addEventListener(new Transpose());
        instance.getJda().addEventListener(new Whitelist());
    }
}
