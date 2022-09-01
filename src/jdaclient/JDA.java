package jdaclient;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

import static jdaclient.panels.Chat.serverListArray;

public class JDA {

    public static JDABuilder builder;
    public static net.dv8tion.jda.api.JDA shardMan;

    public static String botToken;
    public static String botActivity;
    public static Activity.ActivityType botActivityType;

    public static void build(String token) throws LoginException, InterruptedException {
        builder = JDABuilder.createDefault(token);
        //builder = JDABuilder.createDefault("OTc5MDMzNDU0MTM2MTM5ODU3.GHPoi9.OpJxtDf8l9yfodr1auto1KIhsWGyn7zj9NUBwM");
        shardMan = builder.build();

        botToken = token;

        if(botActivityType != null || botActivity != null) {
            setActivity(botActivityType, botActivity);
        }

        System.out.println("[JDA Client] Bot ready!");
    }

    public static void stop() {
        //builder.setStatus(OnlineStatus.OFFLINE);
        shardMan.shutdown();

        System.out.println("[JDA Client] Bot offline!");
    }

    public static void setActivity(Activity.ActivityType activityType, String activity) throws InterruptedException {
        shardMan.awaitReady();
        shardMan.getPresence().setActivity(Activity.of(activityType, activity));

        botActivityType = activityType;
        botActivity = activity;

        System.out.println("[JDA Client] Set activity to " + activityType + ": " + activity + "!");
    }

    public static void serverList() {
        serverListArray = shardMan.getGuilds();
        for(int i = 0; i <= serverListArray.size(); i++) {
            //serverList.addItem(serverListArray.get(i));
            System.out.println(i);
            System.out.println(serverListArray.get(i).toString());
        }
    }

    public static void channelList() {

    }

    public static void memberList() {

    }
}
