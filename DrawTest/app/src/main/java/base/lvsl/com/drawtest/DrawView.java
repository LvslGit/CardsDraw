package base.lvsl.com.drawtest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DrawView extends FrameLayout {

    Context mContext;
    LinearLayout mFlCardBack;
    LinearLayout mFlCardFront;
    FrameLayout mFlContainer;

    TextView tv;
    ImageView cardsImage;

    AnimatorSet mRightOutSet; // 右出动画
    AnimatorSet mLeftInSet; // 左入动画

    // 图片变化动画
    public static List<Bitmap> images;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_flipcardsview,  this);
        mFlContainer = (FrameLayout) findViewById(R.id.main_fl_container);
        mFlCardBack = (LinearLayout) findViewById(R.id.main_fl_card_back);
        mFlCardFront = (LinearLayout) findViewById(R.id.main_fl_card_front);
//        tv = (TextView) findViewById(R.id.tv);
        cardsImage = findViewById(R.id.imageView_Cards);

        initData();
        setAnimators(); // 设置动画
        setCameraDistance(); // 设置镜头距离
    }

    private void initData() {
        images = new ArrayList<>();
        images.clear();
        images.add(null);
        images.add(null);
        images.add(null);
        images.add(null);
        images.add(null);
        images.add(null);
    }

    // 改变视角距离, 贴近屏幕
    private void setCameraDistance() {
        int distance = 16000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mFlCardFront.setCameraDistance(scale);
        mFlCardBack.setCameraDistance(scale);
    }

    // 设置动画
    private void setAnimators() {
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.anim_out);
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.anim_in);

        // 设置点击事件
        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mFlContainer.setClickable(false);
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mFlContainer.setClickable(true);
            }
        });
    }
    /**
     *可以自行设置需要修改的数据属性，外放就行
     */

    // 设置反面背景图片
    public void setImage(Bitmap bitmap) {
        cardsImage.setImageBitmap(bitmap);
    }

    public void startChange(final int index) {
        if (images == null || images.size() == 0 || index > images.size()) {
            return;
        }

//        Drawable drawable = new BitmapDrawable(images.get(index));
        final ImageView imageView = null;
        imageView.setImageBitmap(images.get(index));

        // 声明渐变隐藏动画
        ObjectAnimator animHide = ObjectAnimator.ofFloat(imageView, "alpha", 1, 0);
        animHide.setDuration(200);
        animHide.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // 动画结束

                // 改变内容
                imageView.setImageBitmap(BitmapFactory.decodeResource(
                        getResources(), R.mipmap.xg
                ));
                // 渐变显示动画
                ObjectAnimator animShow = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1);
                animShow.setDuration(200);
                animShow.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        // 递归执行下一个view
                        startChange(index + 1);
                    }
                });
                animShow.start();
            }
        });
        animHide.start();
    }

//    //设置反面文字(金币)
//    public void setText(String context) {
//        tv.setText(context);
//    }

    //设置反面背景
    public void setCardBackground(int color) {
        mFlCardBack.setBackgroundColor(color);
    }

    //启动动画
    public void start() {
        mRightOutSet.setTarget(mFlCardFront);
        mLeftInSet.setTarget(mFlCardBack);
        mRightOutSet.start();
        mLeftInSet.start();
    }
}
