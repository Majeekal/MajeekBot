package me.majeek.minecraft.listeners;

import me.majeek.Main;
import me.majeek.minecraft.events.MinecraftChat;

public class MinecraftListener {
    public MinecraftListener(Main instance){
        instance.getServer().getPluginManager().registerEvents(new MinecraftChat(), Main.getInstance());
    }
}
