package io.github.kill00.sqlitemc;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

/**
 * SQLiteMC
 *
 * @author Kill00
 * @version Docs: 1.0.0-SNAPSHOT
 *
 */

public class slm {
    private static Plugin plugin;
    private static boolean silentLogs = false;

    /**
     * Register Plugin
     *
     * @param plugin plugin
     */
    public static void register(Plugin plugin) {
        slm.plugin = plugin;
    }

    /**
     * Set Configure
     *
     * @param silentLogs silent logs
     */
    public static void setConfigure(boolean silentLogs) {
        slm.silentLogs = silentLogs;
    }

    /**
     * Logger
     *
     * @param contents Logs
     */
    private static void logger(String contents) {
        if (!silentLogs) {
            plugin.getLogger().info(contents);
        }
    }

    /**
     * Create a new SQLite database
     *
     * @param dbName database name
     * @param plugin plugin
     */
    public static void setupDB(Plugin plugin, String dbName) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        var dbPath = plugin.getDataFolder() + "/" + dbName;
        try {

            Class.forName("org.sqlite.JDBC");
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            connection.createStatement();

            logger("[SQLiteMC] Database connected.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Backup the database
     *
     * @param dbName database name
     * @return timestamp
     */
    public static long backupDB(String dbName) {
        var time = System.currentTimeMillis();
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var backupPath = new File(plugin.getDataFolder(), dbName + "-" + time + ".bak");

            if (dbPath.exists()) {
                Files.copy(dbPath.toPath(), backupPath.toPath());

                logger("[SQLiteMC] Database backup success.");
            } else {
                logger("[SQLiteMC] Database backup failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return time;
    }

    /**
     * Backup the database
     *
     * @param dbName database name
     * @param movePath move path
     */
    public static void backupDB(String dbName, String movePath) {
        var backupPath = new File(plugin.getDataFolder(), dbName + "-" + backupDB(dbName) + ".bak");
        var newPath = new File(plugin.getDataFolder().getPath() + "/" + movePath);

        if (backupPath.exists()) {
            if (!newPath.exists()) {
                newPath.mkdir();
            }

            try {
                Files.move(backupPath.toPath(), newPath.toPath().resolve(backupPath.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * SQLite statement execute
     *
     * @param dbName database name
     * @param sql sql
     */
    public static void execute(String dbName, String sql) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            statement.execute(sql);

            logger("[SQLiteMC] Executed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * SQLite statement executeUpdate
     *
     * @param dbName database name
     * @param sql sql
     */
    public static void executeUpdate(String dbName, String sql) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            statement.executeUpdate(sql);

            logger("[SQLiteMC] Executed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new table
     *
     * @param dbName database name
     * @param tableName table name
     */
    public static void createTable(String dbName, String tableName) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS " + tableName +" (\n" +
                    "KEY TEXT NOT NULL,\n" +
                    "VALUE TEXT NOT NULL\n" +
                    ")";

            statement.execute(sql);

            logger("[SQLiteMC] Table created/loaded.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new table (Custom)
     *
     * @param dbName database name
     * @param tableName table name
     * @param tableInfo table info
     *
     * @deprecated use {@link #createTable(String, String)} or {@link #execute(String, String)} instead
     */
    @Deprecated
    public static void createTable(String dbName, String tableName, String tableInfo) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " + tableInfo;

            statement.execute(sql);

            logger("[SQLiteMC] Table created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove a table
     *
     * @param dbName database name
     * @param tableName table name
     */
    public static void removeTable(String dbName, String tableName) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "DROP TABLE IF EXISTS " + tableName;

            statement.executeUpdate(sql);

            logger("[SQLiteMC] Table removed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert a new row
     *
     * @param dbName database name
     * @param tableName table name
     * @param key key
     * @param value value
     */
    public static void insertRow(String dbName, String tableName, String key, Object value) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "INSERT INTO " + tableName + " (KEY, VALUE) VALUES ('" + key + "', '" + value + "')";

            statement.executeUpdate(sql);

            logger("[SQLiteMC] Row inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update a row
     *
     * @param dbName database name
     * @param tableName table name
     * @param key key
     * @param value value
     */
    public static void updateRow(String dbName, String tableName, String key, Object value) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "UPDATE " + tableName + " SET VALUE = '" + value + "' WHERE KEY = '" + key + "'";

            statement.executeUpdate(sql);

            logger("[SQLiteMC] Row updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove a row
     *
     * @param dbName database name
     * @param tableName table name
     * @param key key
     */
    public static void removeRow(String dbName, String tableName, String key) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "DELETE FROM " + tableName + " WHERE KEY = '" + key + "'";

            statement.executeUpdate(sql);

            logger("[SQLiteMC] Row removed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a row
     *
     * @param dbName database name
     * @param tableName table name
     * @param key key
     * @return value
     */
    public static String getRow(String dbName, String tableName, String key) {
        var dbPath = new File(plugin.getDataFolder(), dbName);
        try {
            var connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            var statement = connection.createStatement();

            String sql = "SELECT VALUE FROM " + tableName + " WHERE KEY = '" + key + "'";
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                return resultSet.getString("VALUE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convert data type
     *
     * @param dbName database name
     * @param tableName table name
     */
    public static DataTypeConvert get(String dbName, String tableName) {
        return new DataTypeConvert(dbName, tableName);
    }

    /**
     * Check data type
     *
     * @param dbName database name
     * @param tableName table name
     */
    public static DataTypeCheck check(String dbName, String tableName) {
        return new DataTypeCheck(dbName, tableName);
    }
}
