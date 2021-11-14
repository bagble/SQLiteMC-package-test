package io.github.kill00.sqlitemc.Data;

import java.util.List;
import java.util.Objects;

import static io.github.kill00.sqlitemc.slm.getRow;

public class DataTypeConvert {
    private static String dbName;
    private static String tableName;

    public DataTypeConvert(String dbName, String tableName) {
        super();
        DataTypeConvert.dbName = dbName;
        DataTypeConvert.tableName = tableName;
    }

    /**
     * Get String value from key
     *
     * @param key key
     * @return return String value (Returns 'null' if not found)
     */
    public String getString(String key) {
        String result = null;
        try {
            result = String.valueOf(getRow(dbName, tableName, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get Integer value from key
     *
     * @param key key
     * @return return Integer value (Returns '0' if not found)
     */
    public int getInt(String key) {
        int result = 0;
        try {
            result = Integer.parseInt(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get Double value from key
     *
     * @param key key
     * @return return Double value (Returns '0' if not found)
     */
    public double getDouble(String key) {
        double result = 0;
        try {
            result = Double.parseDouble(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get Float value from key
     *
     * @param key key
     * @return return Float value (Returns '0' if not found)
     */
    public float getFloat(String key) {
        float result = 0;
        try {
            result = Float.parseFloat(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get Long value from key
     *
     * @param key key
     * @return return Long value (Returns '0' if not found)
     */
    public long getLong(String key) {
        long result = 0;
        try {
            result = Long.parseLong(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get Boolean value from key
     *
     * @param key key
     * @return return Boolean value (Returns '0' if not found)
     */
    public boolean getBoolean(String key) {
        boolean result = false;
        try {
            result = Boolean.getBoolean(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get List(?) value from key
     *
     * @param key key
     * @return return List(?) value (Returns 'null' if not found)
     */
    public List<?> getList(String key) {
        List<?> result = null;
        try {
            result = List.of(Objects.requireNonNull(getRow(dbName, tableName, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}