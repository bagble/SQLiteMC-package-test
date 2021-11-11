package io.github.kill00.sqlitemc.Data;

import java.util.List;
import java.util.Objects;

import static io.github.kill00.sqlitemc.slm.getRow;

public class DataTypeCheck {
    private static String dbName;
    private static String tableName;

    public DataTypeCheck(String dbName, String tableName) {
        super();
        DataTypeCheck.dbName = dbName;
        DataTypeCheck.tableName = tableName;
    }

    /**
     * Checks if the specified path is a String.
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isString(String key) {
        try {
            String s = String.valueOf(getRow(dbName, tableName, key));
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the specified path is an Integer.
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isInt(String key) {
        try {
            int i = Integer.parseInt(String.valueOf(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the specified path is a Double.
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isDouble(String key) {
        try {
            double d = Double.parseDouble(String.valueOf(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the specified path is a Float.
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isFloat(String key) {
        try {
            float f = Float.parseFloat(String.valueOf(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the specified path is a Long.
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isLong(String key) {
        try {
            long l = Long.parseLong(String.valueOf(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the specified path is a Boolean.
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isBoolean(String key) {
        try {
            boolean b = Boolean.parseBoolean(String.valueOf(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the specified path is a List(?).
     *
     * @param key key
     * @return Requested boolean.
     */
    public boolean isList(String key) {
        try {
            List<?> l = List.of(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}