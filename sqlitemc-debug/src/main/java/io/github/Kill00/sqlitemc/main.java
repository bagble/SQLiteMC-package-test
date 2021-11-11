package io.github.Kill00.sqlitemc;

import io.github.kill00.sqlitemc.slm;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    public void onEnable() {
        slm.register(this);
        getLogger().info("SQLiteMC has been enabled!");

        slm.setupDB("sqlitemc-test");

        slm.createTable("sqlitemc-test", "HelloWorld");

        System.out.println(slm.check("sqlitemc-test", "test").isLong("HelloWorld"));
    }
}
