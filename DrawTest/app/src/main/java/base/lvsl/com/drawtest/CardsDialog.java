package base.lvsl.com.drawtest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CardsDialog extends FrameLayout {
    private static final String TAG = "lvsl";

    Context mContext;
    AnimatorSet mRightOutSet; // 右出动画
    AnimatorSet mLeftInSet; // 左入动画

    LinearLayout mFlCardBack;
    LinearLayout mFlCardFront;
    FrameLayout mFlContainer;

    ImageView cardsImage;


    public CardsDialog(Context context, AttributeSet attrs) {
//        super(context, R.style.MyDialog);
        super(context, attrs);

        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dialog_drawview_animation, this);
        initView();
    }

//    @Override
//    protected void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(R.layout.dialog_drawview_animation);
//        setCanceledOnTouchOutside(false);
//
//        initView();
//    }

    private void initView() {
        mFlContainer = (FrameLayout) findViewById(R.id.dialog_container);
        mFlCardBack = (LinearLayout) findViewById(R.id.dialog_card_back);
        mFlCardFront = (LinearLayout) findViewById(R.id.dialog_card_front);

        cardsImage = findViewById(R.id.imageView_Dialog_Cards);
        setAnimators();
        setCameraDistance();
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

    // 改变视角距离, 贴近屏幕
    private void setCameraDistance() {
        int distance = 16000;
//        float scale = getResources().getDisplayMetrics().density * distance;
        float scale = getContext().getResources().getDisplayMetrics().density * distance;
        mFlCardFront.setCameraDistance(scale);
        mFlCardBack.setCameraDistance(scale);
    }

    /************************设置效果**************************/
    // 开启翻页动画效果
    public void animationStart() {
        mRightOutSet.setTarget(mFlCardFront);
        mLeftInSet.setTarget(mFlCardBack);
        mRightOutSet.start();
        mLeftInSet.start();
    }

    // 设置反面背景图片
    public void setImage(Bitmap bitmap) {
        cardsImage.setImageBitmap(bitmap);
    }

}
