package base.lvsl.com.drawtest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.yayandroid.rotatable.Rotatable;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import base.lvsl.com.drawtest.javaBean.CardsJavaBean;
import base.lvsl.com.drawtest.javaBean.NumJavaBean;
import base.lvsl.com.drawtest.javaBean.PrizeDetailJavaBean;
import base.lvsl.com.drawtest.javaBean.PrizeDrawJavaBean;
import base.lvsl.com.drawtest.utils.HttpUrl;
import base.lvsl.com.drawtest.utils.ImageUtils;
import base.lvsl.com.drawtest.utils.TokenUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lvsl";

    @ViewInject(R.id.imageView_DrawTitle_Return)
    ImageView imageView_DrawTitle_Return;
    @ViewInject(R.id.textView_DrawTitle_Title)
    TextView textView_DrawTitle_Title;// 标题
    @ViewInject(R.id.imageView_DrawTitle)
    ImageView imageView_DrawTitle;
    @ViewInject(R.id.relativeLayout_Title_Draw)
    RelativeLayout relativeLayout_Title_Draw;// 标题栏
    @ViewInject(R.id.imageView_Draw_Background)
    ImageView imageView_Draw_Background;// 背景图
    @ViewInject(R.id.imageView_Draw_Rule)
    ImageView imageView_Draw_Rule;// 抽奖规则
    @ViewInject(R.id.imageView_Draw_MinePrize)
    ImageView imageView_Draw_MinePrize;// 我的奖品
    @ViewInject(R.id.textView_Draw_Nums)
    TextView textView_Draw_Nums;// 剩余抽奖次数
    @ViewInject(R.id.drawview_Draw_Detail)
    GridView drawview_Draw_Detail;// 翻牌
    @ViewInject(R.id.linearLayout_Prize_Draw)
    LinearLayout linearLayout_Prize_Draw;// 底部五图
    @ViewInject(R.id.imageView_Cards_Animation)
    ImageView imageView_Cards_Animation;// 中间大图

    private GridViewAdapter gridViewAdapter;
    List<String> cardsItem = new ArrayList<>();

    private PrizeDetailJavaBean prizeDetailJavaBean;// 转盘数据
    private PrizeDrawJavaBean prizeDrawJavaBean;// 中奖数据

    private boolean mFlag = true;
    private int clickPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.Ext.init(getApplication());  // 初始化xUtils
        x.Ext.setDebug(false);  //输出debug日志，开启会影响性能
        x.view().inject(this);

        initData();
    }

    private void initData() {
        // 卡牌
        gridViewAdapter = new GridViewAdapter();
        cardsItem.clear();
        cardsItem.add("0");cardsItem.add("1");cardsItem.add("2");
        cardsItem.add("3");cardsItem.add("4");cardsItem.add("5");
        gridViewAdapter.refreshGridData(cardsItem);

        drawview_Draw_Detail.setAdapter(gridViewAdapter);

        numData();
        getDetailData();
    }

    // 剩余抽奖次数
    private void numData() {
        final RequestParams params = new RequestParams("http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/remark");
        params.addBodyParameter("token", TokenUtils.getToken());
        params.addBodyParameter("uid", "37");
        params.addBodyParameter("luckid", "4");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                NumJavaBean javaBean = JSON.parseObject(result, NumJavaBean.class);

                textView_Draw_Nums.setText(javaBean.getResult());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void getDetailData() {
        RequestParams params = new RequestParams(HttpUrl.PRIZE_DETAIL);
        params.addBodyParameter("token", TokenUtils.getToken());
        params.addBodyParameter("luckid", "4");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                prizeDetailJavaBean = JSON.parseObject(result, PrizeDetailJavaBean.class);

                ImageUtils.loadImage(getApplicationContext(), imageView_Draw_Background,
                        prizeDetailJavaBean.getResult().getHeadpic1x1());// 加载背景图
                textView_DrawTitle_Title.setText(prizeDetailJavaBean.getResult().getTitle());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void getIsPrize() {
        RequestParams params = new RequestParams(HttpUrl.PRIZE_DRAW);
        params.addBodyParameter("token", TokenUtils.getToken());
        params.addBodyParameter("uid", "37");
        params.addBodyParameter("lickid", "4");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                prizeDrawJavaBean = JSON.parseObject(result, PrizeDrawJavaBean.class);
                if (prizeDrawJavaBean.getStatus() != 1 || prizeDetailJavaBean == null) {
                    Toast.makeText(MainActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
//                    PrizeNullDialog nullDialog = new PrizeNullDialog(PrizeDetailActivity.this, null);
//                    nullDialog.show();
                    return;
                }

                PrizeDrawJavaBean.Result result1 = prizeDrawJavaBean.getResult();
                int theType = result1.getType();

                if (theType == 1) {

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public class GridViewAdapter extends BaseAdapter {
        List<String> cardsList = new ArrayList<>();

        public boolean refreshGridData(List<String> list) {
            if (list != null && list.size() > 0) {
                cardsList.clear();
                cardsList.addAll(list);
                notifyDataSetChanged();
                return true;
            }
            return false;
        }

        @Override
        public int getCount() {
            return cardsList == null ? 0 : cardsList.size();
        }

        @Override
        public Object getItem(int position) {
            return cardsList == null ? null : cardsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        GridViewAdapter.ViewHolder holder = null;
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 1、如果没有可利用item时，找出所有控件
            if (convertView == null) {
                holder = new GridViewAdapter.ViewHolder();
                convertView = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.doubledealer_gv_item, parent, false);
//                holder.textView = (TextView) convertView.findViewById(R.id.tv);
                holder.imageView = convertView.findViewById(R.id.imageView_Cards);

                holder.myLayout = convertView
                        .findViewById(R.id.myLayout);
                holder.drawView = convertView.findViewById(R.id.drawView);

                convertView.setTag(holder);
            } else {
                // 3、有可利用的item时就获取赋值使用
                holder = (GridViewAdapter.ViewHolder) convertView.getTag();
            }

            if (mFlag) {
                // 监听点击事件
                holder.myLayout.setClickable(true);
                holder.myLayout.setOnClickListener(new
                        MyClickListener(holder, cardsList, position));
            } else {
                // 监听点击事件
                holder.myLayout.setClickable(false);
                if (clickPosition != position) {
                    holder.drawView.start();
//                    holder.drawView.setCardBackground(Color.parseColor("#B0E2FF"));
//                    holder.drawView.setText(cardsList.get(position) + "");
//                    holder.imageView.setVisibility(View.VISIBLE);
//                    holder.drawView.setImage(BitmapFactory.decodeResource(
//                            getResources(), R.mipmap.cup
//                    ));
//                    imageView_Cards_Animation.setVisibility(View.VISIBLE);
                    setOvershotAnim();
                }
            }

            return convertView;
        }

        private class ViewHolder {
            ImageView imageView;
            LinearLayout myLayout;
            DrawView drawView;
        }
    }

    class MyClickListener implements View.OnClickListener {
        GridViewAdapter.ViewHolder holder;
        int position;
        List<String> cardsList;

        private MyClickListener(GridViewAdapter.ViewHolder holder,
                                List<String> cardsList, int position) {
            this.holder = holder;
            this.cardsList = cardsList;
            this.position = position;
        }

        // 纸牌点击
        @Override
        public void onClick(View v) {

            if (mFlag) {
                clickPosition = position;
                holder.drawView.start();
//                holder.drawView.setCardBackground(Color.parseColor("#C1C1C1"));
//                holder.drawView.setText(cardsList.get(position) + "");
//                holder.drawView.setImage(BitmapFactory.decodeResource(
//                        getResources(), R.mipmap.cup
//                ));
                setOvershotAnim();

                mFlag = false;
            }

        }
    }

    /********************动画效果**************************/

    // 插值器设置    OvershootInterpolator
    private Animation overshotAnim;
    @SuppressLint("ResourceType")
    private void setOvershotAnim() {
        overshotAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_overshot);
        imageView_Cards_Animation.startAnimation(overshotAnim);
        largeAnimStart();
    }

    @SuppressLint("ResourceType")
    private void largeAnimStart() {
        imageView_Cards_Animation.setVisibility(View.VISIBLE);
        // 放大
        Animation largeAnim;
        largeAnim = AnimationUtils.loadAnimation(this, R.animator.enlarge);
        imageView_Cards_Animation.startAnimation(largeAnim);
        imageAnimationStart();
    }

    // 旋转
    private Handler handler;
    private final int ANIM_DURATION = 3000;
    private void imageAnimationStart() {
        handler = new Handler();
        runAnimation(R.id.imageView_Cards_Animation, Rotatable.ROTATE_Y,
                360, 100);
    }

    /**
     *  动画进程
     *
     * @param resID         位置
     * @param direction     方向
     * @param degree        度数
     * @param delay         延时
     */
    private  void runAnimation(final int resID, final int direction,
                               final int degree, int delay) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Rotatable rotatable = new Rotatable.Builder(findViewById(resID))
                        .direction(Rotatable.ROTATE_BOTH)
                        .build();
                rotatable.rotate(direction, degree, ANIM_DURATION);
            }
        }, delay);

        // 开启弹窗
//        startDialog();
    }

    // 中奖弹窗
    private void startDialog() {

        // 类型划分
        int prizeType = 1;
        if (prizeType == 1) {// 普通广告

        } else if (prizeType == 2) {// 卡密广告

        } else if (prizeType == 3) {// 货币商品

        } else if (prizeType == 4) {// 邮寄商品

        } else if (prizeType == 5) {// 卡密商品

        } else {// 未中奖

        }

    }

//    // 中奖数据
//    private void getCardsData() {
//        final RequestParams params = new RequestParams("http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/pinfo");
//
//        params.addBodyParameter("token", TokenUtils.getToken());
//        params.addBodyParameter("luckid", "4");
//
//        x.http().post(params, new Callback.CommonCallback<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                javaBean = JSON.parseObject(result, CardsJavaBean.class);
//
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//    }

    @Event(value = {R.id.imageView_DrawTitle_Return, R.id.imageView_DrawTitle,
            R.id.imageView_Draw_Rule, R.id.imageView_Draw_MinePrize})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_DrawTitle_Return:// 返回上一个界面
                finish();
                break;
            case R.id.imageView_DrawTitle:
                // 红包

                break;
            case R.id.imageView_Draw_Rule:
                // 规则
                break;
            case R.id.imageView_Draw_MinePrize:
                // 我的奖品
                break;
        }
    }

}
