package base.lvsl.com.drawtest.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import base.lvsl.com.drawtest.R;

/**
 * 图片加载工具类
 *
 * @author JueYes
 * @Time 2018/1/16
 */

public class ImageUtils {
    /**
     * 加载图片
     *
     * @param context   Content
     * @param imageView ImageView
     * @param image     ImageUrl
     */
    public static void loadImage(Context context, ImageView imageView, int image) {
        Picasso.with(context)
                .load(image)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    /**
     * 加载图片
     *
     * @param context   Content
     * @param imageView ImageView
     * @param imageUrl  ImageUrl
     */
    public static void loadImage(Context context, ImageView imageView, String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) imageUrl = "null";
        Picasso.with(context)
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    /**
     * 加载图片
     *
     * @param context      Content
     * @param imageView    ImageView
     * @param imageUrl     ImageUrl
     * @param imageDefault 默认图片
     */
    public static void loadImage(Context context, ImageView imageView, String imageUrl, int imageDefault) {
        if (imageUrl == null || imageUrl.isEmpty()) imageUrl = "null";
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(imageDefault)
                .fit()
                .centerCrop()
                .error(imageDefault)
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, File imageFile) {
        Picasso.with(context)
                .load(imageFile)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, File imageFile, int imageDefault) {
        Picasso.with(context)
                .load(imageFile)
                .placeholder(imageDefault)
                .fit()
                .centerCrop()
                .error(imageDefault)
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, Uri imageUri) {
        loadImage(context, imageView, imageUri, R.drawable.ic_launcher_background);
    }

    public static void loadImage(Context context, ImageView imageView, Uri imageUri, int imageDefault) {
        Picasso.with(context)
                .load(imageUri)
                .placeholder(imageDefault)
                .fit()
                .centerCrop()
                .error(imageDefault)
                .into(imageView);
    }


    public static void loadImageRound(Context context, ImageView imageView, String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) imageUrl = "null";
        Picasso.with(context)
                .load(imageUrl)
                // .placeholder(R.mipmap.ic_launcher)
                // .error(R.mipmap.ic_launcher)
                .transform(new CircleImageTransformation())// 圆角处理
                .into(imageView);
    }

    public static void loadImageRound(Context context, ImageView imageView, int resourceId) {
        Picasso.with(context)
                .load(resourceId)
                // .placeholder(R.mipmap.ic_launcher)
                // .error(R.mipmap.ic_launcher)
                .transform(new CircleImageTransformation())// 圆角处理
                .into(imageView);
    }

    public static void loadImageHead(Context context, ImageView imageView, String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) imageUrl = "null";

        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .transform(new CircleImageTransformation())// 圆角处理
                .into(imageView);
    }

    public static void loadImageHead(Context context, ImageView imageView, int resourceId) {
        Picasso.with(context)
                .load(resourceId)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .transform(new CircleImageTransformation())// 圆角处理
                .into(imageView);
    }


    public static class CircleImageTransformation implements Transformation {

        /**
         * A unique key for the transformation, used for caching purposes.
         */
        private static final String KEY = "circleImageTransformation";

        @Override
        public Bitmap transform(Bitmap source) {

            int minEdge = Math.min(source.getWidth(), source.getHeight());
            int dx = (source.getWidth() - minEdge) / 2;
            int dy = (source.getHeight() - minEdge) / 2;

            // Init shader
            Shader shader = new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setTranslate(-dx, -dy);   // Move the target area to center of the source bitmap
            shader.setLocalMatrix(matrix);

            // Init paint
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setShader(shader);

            // Create and draw circle bitmap
            Bitmap output = Bitmap.createBitmap(minEdge, minEdge, source.getConfig());
            Canvas canvas = new Canvas(output);
            canvas.drawOval(new RectF(0, 0, minEdge, minEdge), paint);

            // Recycle the source bitmap, because we already generate a new one
            source.recycle();

            return output;
        }

        @Override
        public String key() {
            return KEY;
        }
    }


    public static HashMap<Long, Target> mTargetMap = new HashMap<>();

    public static long type = 0;

    public static void getBitmap4HttpUrl(final Context context, final String url, final BitmapLoaded loaded) {
        final long mTimeStamp = type++;
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                loaded.onBitmapLoaded(url, bitmap);
                mTargetMap.remove(mTimeStamp);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                // 填充失败的图片
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
                loaded.onBitmapLoaded(url, bitmap);
                mTargetMap.remove(mTimeStamp);
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        mTargetMap.put(mTimeStamp, target);
        Picasso.with(context).load(url).into(mTargetMap.get(mTimeStamp));
    }

    public interface BitmapLoaded {
        void onBitmapLoaded(String url, Bitmap bitmap);
    }


    public static void getBitmap4HttpUrl(final Context context, final ArrayList<String> imageUrlList, final BitmapListLoaded loaded) {

        final ArrayList<String> bitmapUrlList = new ArrayList<>();
        final ArrayList<Bitmap> bitmapList = new ArrayList<>();

        for (String imageUrl : imageUrlList) {

            getBitmap4HttpUrl(context, imageUrl, new BitmapLoaded() {

                @Override
                public void onBitmapLoaded(String url, Bitmap bitmap) {

                    // 保存图片
                    bitmapUrlList.add(url);
                    bitmapList.add(bitmap);

                    // 检测图片是否全部加载完毕
                    if (bitmapList.size() == imageUrlList.size())
                        loaded.onBitmapLoaded(bitmapUrlList, bitmapList);
                }
            });
        }
    }

    public interface BitmapListLoaded {
        void onBitmapLoaded(ArrayList<String> urlList, ArrayList<Bitmap> bitmapList);
    }

    public static class PicassoTarget {

        private Target target;

        public PicassoTarget(Target target) {
            this.target = target;
        }

        public Target getTarget() {
            return target;
        }

        public void setTarget(Target target) {
            this.target = target;
        }
    }

    /**
     * 通过uri获取图片并进行压缩
     *
     * @param uri
     * @param activity
     * @return
     * @throws IOException
     */
    public static Bitmap getBitmapFromUri(Uri uri, Activity activity) {
        InputStream inputStream = null;
        try {
            inputStream = activity.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        BitmapFactory.decodeStream(inputStream, null, options);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;
        if (originalWidth == -1 || originalHeight == -1) {
            return null;
        }

        float height = 800f;
        float width = 480f;
        int be = 1; //be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > width) {
            be = (int) (originalWidth / width);
        } else if (originalWidth < originalHeight && originalHeight > height) {
            be = (int) (originalHeight / height);
        }

        if (be <= 0) {
            be = 1;
        }
        BitmapFactory.Options bitmapOptinos = new BitmapFactory.Options();
        bitmapOptinos.inSampleSize = be;
        bitmapOptinos.inDither = true;
        bitmapOptinos.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            inputStream = activity.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, bitmapOptinos);

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return compressImage(bitmap);
    }

    /**
     * 质量压缩方法
     *
     * @param bitmap
     * @return
     */
    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int options = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差 ，第三个参数：保存压缩后的数据的流
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, byteArrayOutputStream);
            options -= 10;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        Bitmap bitmapImage = BitmapFactory.decodeStream(byteArrayInputStream, null, null);
        return bitmapImage;
    }

    public static File keepBitmap(Context context, Bitmap bitmap) {

        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "yuanbao");
        if (!appDir.exists()) appDir.mkdir();

        String fileName = System.currentTimeMillis() + ".png";
        File bitmapFile = new File(appDir, fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(bitmapFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmapFile.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + "/sdcard/namecard/")));
        return bitmapFile;
    }

    public static Bitmap readBitmap(File file) {
        Bitmap bitmap = null;
        try {
            if (file.exists()) {
                bitmap = BitmapFactory.decodeFile(file.getName());
            }
        } catch (Exception e) {
        }

        return bitmap;
    }
}
