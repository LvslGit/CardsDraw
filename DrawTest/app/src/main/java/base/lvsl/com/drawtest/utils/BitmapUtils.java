package base.lvsl.com.drawtest.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

import base.lvsl.com.drawtest.R;

/**
 * Bitmap 工具类
 * Created by JueYes on 2018/3/15.
 */

public class BitmapUtils {

    /**
     * 从资源文件中获取Bitmap图片
     * @param context
     * @param fileName
     * @return
     */
    public static Bitmap getBitmap2Assets(Context context, String fileName) {

        Bitmap bitmap;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            // 默认图片
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        }
        return bitmap;
    }
}
