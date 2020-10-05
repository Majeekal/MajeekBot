package me.majeek;

import me.majeek.discord.listeners.DiscordListener;
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

    private final String prefix = "~";
    
    @Override
    public void onEnable() {
        // Instance
        instance = this;

        // Discord API
        try{ jda = JDABuilder.createDefault("").setChunkingFilter(ChunkingFilter.ALL).setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS).build(); }
        catch (LoginException e){ e.printStackTrace(); }
        jda.getPresence().setActivity(Activity.playing("~help"));

        // Managers and Listeners
        discordListener = new DiscordListener(this);
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

    public static void setInstance(Main instance) {
        Main.instance = instance;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

    public void setDiscordListener(DiscordListener discordListener) {
        this.discordListener = discordListener;
    }
}
