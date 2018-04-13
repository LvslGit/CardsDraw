package base.lvsl.com.drawtest.utils;

import com.bigkoo.convenientbanner.ConvenientBanner;

import base.lvsl.com.drawtest.R;

/**
 * ConvenientBanner 工具类
 *
 * @author JueYes
 * @Time 2018/1/25
 */

public class BannerUtils {

    /**
     * 对ConvenientBanner进行设置的方法
     *
     * @param convenientBanner ConvenientBanner
     */
    public static void installBanner(ConvenientBanner convenientBanner) {
        //设置指示器是否可见
        convenientBanner.setPointViewVisible(true)
                //设置自动切换（同时设置了切换时间间隔）
                .startTurning(5000)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher})
                //设置指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //设置手动影响（设置了该项无法手动切换）
                .setManualPageable(true);
    }
}
