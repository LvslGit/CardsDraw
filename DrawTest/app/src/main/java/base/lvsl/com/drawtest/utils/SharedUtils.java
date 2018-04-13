package base.lvsl.com.drawtest.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 工具类
 *
 * @author JueYes
 * @Time 2018/1/19
 */

public class SharedUtils {

    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "yuanbao_data";

    /**
     * 保存数据的方法(使用默认的文件名称)
     *
     * @param context Context
     * @param key     key
     * @param object  String Integer Boolean Float Long
     */
    public static void setParam(Context context, String key, Object object) {
        setParam(context, FILE_NAME, key, object);
    }

    /**
     * 保存数据的方法
     *
     * @param context Context
     * @param file    FileName
     * @param key     key
     * @param object  String Integer Boolean Float Long
     */
    public static void setParam(Context context, String file, String key, Object object) {

        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }

        editor.commit();
    }


    /**
     * 得到保存的数据(使用默认的文件名)
     *
     * @param context       Context
     * @param key           key
     * @param defaultObject 默认值(String Integer Boolean Float Long)
     * @return 保存的数据, 数据类型和默认值相同
     */
    public static Object getParam(Context context, String key, Object defaultObject) {
        return getParam(context, FILE_NAME, key, defaultObject);
    }

    /**
     * 得到保存的数据
     *
     * @param context       Context
     * @param file          文件名
     * @param key           key
     * @param defaultObject 默认值(String Integer Boolean Float Long)
     * @return 保存的数据, 数据类型和默认值相同
     */
    public static Object getParam(Context context, String file, String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);

        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }
}
