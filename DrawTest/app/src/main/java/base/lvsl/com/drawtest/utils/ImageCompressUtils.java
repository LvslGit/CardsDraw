package base.lvsl.com.drawtest.utils;

import android.graphics.*;
import android.media.ExifInterface;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片压缩工具类
 * Created by JueYes on 2018/3/21.
 */

public class ImageCompressUtils {


    /**
     * 获取缓存图片唯一路径
     *
     * @return
     */
    public static String getImagePath() {
        return Environment.getExternalStorageDirectory().getPath() + "/YuanBaoImage_" + System.currentTimeMillis() + ".jpg";
    }

    /**
     * 质量压缩 (默认压缩率为80)
     *
     * @param bitmap
     * @param file
     */
    public static void compressImageToFile(Bitmap bitmap, File file) {
        compressImageToFile(bitmap, file, 80);
    }

    /**
     * 质量压缩
     *
     * @param bitmap
     * @param file
     * @param options 压缩率(0-100 100为不压缩)
     */
    public static void compressImageToFile(Bitmap bitmap, File file, int options) {
        // 0-100 100为不压缩
        if (options < 0) options = 0;
        if (options > 100) options = 100;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        bitmap.compress(Bitmap.CompressFormat.JPEG, options, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 尺寸压缩
     * 通过缩放图片像素来减少图片占用内存大小
     * 默认压缩倍率为2
     *
     * @param bitmap
     * @param file
     */
    public static void compressBitmapToFile(Bitmap bitmap, File file) {
        compressBitmapToFile(bitmap, file, 2);
    }

    /**
     * 尺寸压缩
     * 通过缩放图片像素来减少图片占用内存大小
     *
     * @param bitmap
     * @param file
     * @param ratio  尺寸压缩倍数,值越大，图片尺寸越小
     */
    public static void compressBitmapToFile(Bitmap bitmap, File file, int ratio) {

        Log.e("JueYes", "compressBitmapToFile: 压缩");
        // 压缩Bitmap到对应尺寸
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth() / ratio, bitmap.getHeight() / ratio, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, bitmap.getWidth() / ratio, bitmap.getHeight() / ratio);
        canvas.drawBitmap(bitmap, null, rect, null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        result.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置图片的采样率，降低图片像素
     * 图片采样率默认为 2
     *
     * @param filePath
     * @param file
     */
    public static void compressBitmapToSample(String filePath, File file) {
        compressBitmapToSample(filePath, file, 2);
    }

    /**
     * 设置图片的采样率，降低图片像素
     *
     * @param filePath
     * @param file
     * @param inSampleSize 数值越高，图片像素越低
     */
    public static void compressBitmapToSample(String filePath, File file, int inSampleSize) {


        BitmapFactory.Options options = new BitmapFactory.Options();
        //采样率
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);

        // 获取图片方向
        try {
            // 获取图片旋转角度
            int degree = 0;
            ExifInterface exifInterface = new ExifInterface(filePath);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }

            if (degree != 0) {
                // 对图片进行旋转操作
                Matrix matrix = new Matrix();
                matrix.postRotate(degree);
                // 创建新的图片
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
