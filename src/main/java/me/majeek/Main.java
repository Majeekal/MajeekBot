package me.majeek;

import me.majeek.discord.listeners.DiscordListener;
import me.majeek.minecraft.listeners.MinecraftListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public final class Main extends JavaPlugin {
    private static Main instance;
    private JDA jda;
    private DiscordListener discordListener;
    private MinecraftListener minecraftListener;

    private String prefix = "~";
    
    @Override
    public void onEnable() {
        // Instance
        instance = this;

        // Config
        saveDefaultConfig();

        // Discord API
        try{ jda = JDABuilder.createDefault("NzM2MDEwMjI2MjM0NDI1MzU0.Xxow4A.jEkmxD3stZEV_A3arkbt_ajf-oA").setChunkingFilter(ChunkingFilter.ALL).setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS).build(); }
        catch (LoginException e){ e.printStackTrace(); }
        jda.getPresence().setActivity(Activity.playing("~help"));

        // Managers and Listeners
        discordListener = new DiscordListener(this);
        minecraftListener = new MinecraftListener(this);
    }

    @Override
    public void onDisable() {
        jda.shutdown();
    }

    public static Main getInstance() {
        return instance;
    }

    public JDA getJda() {
        return jda;
    }

    public DiscordListener getDiscordListener() {
        return discordListener;
    }

    public MinecraftListener getMinecraftListener() {
        return minecraftListener;
    }

    public static void setInstance(Main instance) {
        Main.instance = instance;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

    public void setDiscordListener(DiscordListener discordListener) {
        this.discordListener = discordListener;
    }

    public void setMinecraftListener(MinecraftListener minecraftListener) {
        this.minecraftListener = minecraftListener;
    }
}
