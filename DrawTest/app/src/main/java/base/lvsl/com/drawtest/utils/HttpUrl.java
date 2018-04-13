package base.lvsl.com.drawtest.utils;

/**
 * 后台接口
 *
 * @author JueYes
 * @Time 2018/1/19
 */

public class HttpUrl {

    // http://yuanbao.adyuansu.com
    // public static final String YUANBAO       = "http://118.178.228.52:81/index.php?s=/apiw/";
    // public static final String YUANBAOMOBILE = "http://118.178.228.52:81/index.php?s=/mobile/";
    public static final String YUANBAO       = "http://yuanbao.adyuansu.com/index.php?s=/apiw/";
    public static final String YUANBAOMOBILE = "http://yuanbao.adyuansu.com/index.php?s=/mobile/";

    /**
     * 用户接口
     **/
    public static final String YUANBAO_USER = YUANBAO + "user/";

    // 短信验证 http://118.178.228.52:81/index.php?s=/apiw/user/sendsms
    public static final String USER_SENDSMS = YUANBAO_USER + "sendsms";

    // 注册 http://118.178.228.52:81/index.php?s=/apiw/user/registermobile
    public static final String USER_REGISTERMOBILE = YUANBAO_USER + "registermobile";

    // 登录 http://118.178.228.52:81/index.php?s=/apiw/user/login
    public static final String USER_LOGIN = YUANBAO_USER + "login";

    // 判断用户是否绑定微信  http://118.178.228.52:81/index.php?s=/apiw/user/memberByid
    public static final String USER_ISWECHAT_LOGIN = YUANBAO_USER + "memberByid";

    // 修改密码 http://118.178.228.52:81/index.php?s=/apiw/user/modPasswdByMobile (mobile,newpassword)
    public static final String USER_MODPASSWDBYMOBILE = YUANBAO_USER + "modPasswdByMobile";

    // 修改用户信息(头像 昵称)  http://118.178.228.52:81/index.php?s=/apiw/user/modUserinfoByuid
    public static final String USER_MODUSERINFOBYUID = YUANBAO_USER + "modUserinfoByuid";

    /**
     * 微信接口
     **/
    public static final String YUANBAO_WECHAT = YUANBAO + "wechat/";

    // 微信登录 http://118.178.228.52:81/index.php?s=/apiw/wechat/loginAuthAndroid (token wechat_android_openid nickname)
    public static final String WECHAT_LOGIN = YUANBAO_WECHAT + "loginAuthAndroid";

    // 微信绑定手机号 http://118.178.228.52:81/index.php?s=/apiw/wechat/wxBindMobile
    public static final String WECHAT_BIND_SAFE = YUANBAO_WECHAT +"wxBindMobile";

    // http://118.178.228.52:81/index.php?s=/apiw/wechat/mobileBindWxandroid
    public static final String WECHAT_BIND = YUANBAO_WECHAT + "mobileBindWxandroid";

    // 判断用户是否关注公众号 http://118.178.228.52:81/index.php?s=/apiw/wechat/checkAndroidWX (uid token)
    public static final String WECHAT_CHECK = YUANBAO_WECHAT + "checkAndroidWX ";

    // 首页优惠券4张 http://118.178.228.52:81/index.php?s=/apiw/ticket/home
    public static final String HOME_TICKET = YUANBAO + "ticket/home";

    // 首页 最新动态 http://118.178.228.52:81/index.php?s=/apiw/membernotes/nlist
    public static final String HOME_NLIST = YUANBAO + "membernotes/nlist";

    /**
     * 微信接口(登录,绑定)
     **/
    public static final String WX_URL = "https://api.weixin.qq.com/sns/";

    // 微信access_token https://api.weixin.qq.com/sns/oauth2/access_token
    public static final String WX_ACCESS_TOKEN = WX_URL + "oauth2/access_token";

    // 微信union https://api.weixin.qq.com/sns/userinfo
    public static final String WX_UNION = WX_URL + "userinfo";

    /**
     * 链接
     **/
    public static final String YUANBAO_INDEX = YUANBAOMOBILE + "index/";

    // 收益Html5链接  http://118.178.228.52:81/index.php?s=/mobile/index/profit
    public static final String USER_INCOMEH5YUANBAO = YUANBAO_INDEX + "profit";

    // 关注公众号链接  http://yuanbao.adyuansu.com/index.php?s=/mobile/index/gzwx
    public static final String USER_GUANZHU = YUANBAO_INDEX + "gzwx";

    // 登录协议 http://yuanbao.adyuansu.com/index.php?s=/mobile/index/xieyi
    public static final String USER_LOGIN_PROTOCOL = YUANBAO_INDEX + "xieyi ";

    // 元宝交流群 http://118.178.228.52:81/index.php?s=/mobile/index/qqun
    public static final String USER_QQUNYUANBAO = YUANBAO_INDEX + "qqun";

    // 关于原宝 http://118.178.228.52:81/index.php?s=/mobile/index/about
    public static final String USER_YUANBAO_ABOUT = YUANBAO_INDEX + "about";

    // 咨讯H5链接 http://118.178.228.52:81/index.php?s=/mobile/index/news/id/
    public static final String CONSULT_URL = YUANBAO_INDEX + "news/id/";

    /**
     * 优惠券接口
     **/
    public static final String YUANBAO_COUPON = YUANBAO + "ticket/";

    // 优惠券列表 http://118.178.228.52:81/index.php?s=/apiw/ticket/tlist
    public static final String COUPON_LIST = YUANBAO_COUPON + "tlist";

    // 优惠券详情(图片 名称 卖点 种类 时间) http://118.178.228.52:81/index.php?s=/apiw/ticket/tinfo (token/id)
    public static final String COUPON_INFO = YUANBAO_COUPON + "tinfo";

    // 优惠券链接 http://118.178.228.52:81/index.php?s=/mobile/ticketinfo/index/id/ (+id)
    public static final String COUPON_URL = YUANBAOMOBILE + "ticketinfo/index/id/";

    // 我的优惠券 http://118.178.228.52:81/index.php?s=/apiw/ticket/myreceive
    public static final String COUPON_MINE = YUANBAO_COUPON + "myreceive";

    // 领取优惠券 http://118.178.228.52:81/index.php?s=/apiw/ticket/receive (uid couponid token)
    public static final String COUPON_DRAW = YUANBAO_COUPON + "receive";

    /**
     * 邀请接口
     **/
    public static final String YUANBAO_INVITE = YUANBAO + "invites/";

    // 邀请() http://118.178.228.52:81/index.php?s=/apiw/invites/info
    public static final String USER_INVITEYUANBAO = YUANBAO_INVITE + "info";

    // 激活邀请码 http://118.178.228.52:81/index.php?s=/apiw/invites/activeInvitecode
    public static final String USER_ACTIVATIONYUANBAO = YUANBAO_INVITE + "activeInvitecode";

    /**
     * 资讯接口
     **/
    public static final String YUANBAO_CONSULT = YUANBAO + "news/";

    // 资讯列表 http://118.178.228.52:81/index.php?s=/apiw/news/picturebyid(page size token)
    public static final String CONSULT_LIST = YUANBAO_CONSULT + "pictureall";

    // 资讯详情 http://118.178.228.52:81/index.php?s=/apiw/news/picturebyid (id token)
    public static final String CONSULT_DETAIL = YUANBAO_CONSULT + "picturebyid";

    // 咨询点赞 http://118.178.228.52:81/index.php?s=/apiw/news/addzan (id token)
    public static final String CONSULT_ADDZAN = YUANBAO_CONSULT + "addzan";

    // 资讯广告 http://118.178.228.52:81/index.php?s=/apiw/news/newsAdRandomOne (token)
    public static final String NEWS_NEWSAD = YUANBAO_CONSULT + "newsAdRandomOne";

    /**
     * 广告接口 http://118.178.228.52:81/index.php?s=/apiw/news/abcByaid
     * 首页banner: aid=1
     * 首页广告左 : aid=5
     * 首页广告右 : aid=6
     */
    public static final String CONSULT_ABCBYAID = YUANBAO_CONSULT + "abcByaid";

    /**
     * 收益接口
     **/
    public static final String YUANBAO_PROFIT = YUANBAO + "profit/";

    // 我的已有的元宝  http://118.178.228.52:81/index.php?s=/apiw/profit/myAccount
    public static final String USER_INCOME_ACCOUNT = YUANBAO_PROFIT + "myAccount";

    // 收入   http://118.178.228.52:81/index.php?s=/apiw/profit/myIncome
    public static final String USER_INCOME_INYUANBAO = YUANBAO_PROFIT + "myIncome";

    // 支出   http://118.178.228.52:81/index.php?s=/apiw/profit/myCost
    public static final String USER_INCOME_OUTYUANBAO = YUANBAO_PROFIT + "myCost";

    // 提现   http://118.178.228.52:81/index.php?s=/apiw/withdraws/apply
    public static final String USER_INCOME_WITHDRAW = YUANBAO + "withdraws/apply";

    /**
     * 签到接口
     **/
    public static final String YUANBAO_SIGNIN = YUANBAO + "signin/";

    // 签到打卡接口   118.178.228.52:81/index.php?s=/apiw/signin/addRecord
    public static final String USER_ADDRECORD = YUANBAO_SIGNIN + "addRecord";

    // 日期列表     118.178.228.52:81/index.php?s=/apiw/signin/RecordDatalistByuid
    public static final String USER_RECORDDETAIL = YUANBAO_SIGNIN + "RecordDatalistByuid";

    /**
     * 淘宝相关
     **/
    public static final String YUANBAO_TAOBAO = YUANBAO + "taobaoaccount/";

    // 淘宝列表账号   http://118.178.228.52:81/index.php?s=/apiw/taobaoaccount/accountlist
    public static final String USER_TAOBAOLIST_YUANBAO = YUANBAO_TAOBAO + "accountlist";

    // 增加淘宝账号   http://118.178.228.52:81/index.php?s=/apiw/taobaoaccount/addtbAccount
    public static final String USER_TAOBAOADD_YUANBAO = YUANBAO_TAOBAO + "addtbAccount";

    // 删除淘宝账号   http://118.178.228.52:81/index.php?s=/apiw/taobaoaccount/deltbAccount
    public static final String USER_TAOBAO_DELETE = YUANBAO_TAOBAO + "deltbAccount";

    /**
     * 兑换商城
     **/
    public static final String YUANBAO_EXCHANGE = YUANBAO + "exchanges/";

    // 兑换列表 http://118.178.228.52:81/index.php?s=/apiw/exchanges/exlist (token, type=1,2,3,4)
    public static final String EXCHANGE_EXLIST = YUANBAO_EXCHANGE + "exlist";

    // 热门兑换 http://118.178.228.52:81/index.php?s=/apiw/exchanges/home (token)
    public static final String EXCHANGE_HOME = YUANBAO_EXCHANGE + "home";

    // 兑换记录 http://118.178.228.52:81/index.php?s=/apiw/exchanges/myTake (uid=25, token)
    public static final String EXCHANGE_RECORD = YUANBAO_EXCHANGE + "myTake";

    // 兑换详情 http://118.178.228.52:81/index.php?s=/apiw/exchanges/exinfo (id, token)
    public static final String EXCHANGE_DETAIL = YUANBAO_EXCHANGE + "exinfo";

    // 兑换处理 http://118.178.228.52:81/index.php?s=/apiw/exchanges/trade (uid, exid, token)
    public static final String EXCHANGE_TRADE = YUANBAO_EXCHANGE + "trade";

    // 兑换链接 http://118.178.228.52:81/index.php?s=/mobile/exchangeinfo/index
    public static final String EXCHANGE_URL = YUANBAOMOBILE + "exchangeinfo/index/id/";

    // 添加收货地址 http://118.178.228.52:81/index.php?s=/apiw/exchanges/exchange_record_addAdress (exch_record_id  addrid)
    public static final String EXCHANGE_ADDADRESS = YUANBAO_EXCHANGE + "exchange_record_addAdress";

    // 修改收货地址 http://118.178.228.52:81/index.php?s=/apiw/exchanges/exchange_record_editAdress (id  addrid)
    public static final String EXCHANGE_EDITADRESS = YUANBAO_EXCHANGE + "exchange_record_editAdress";

    /**
     * 收货地址
     **/
    public static final String YUANBAO_ADDRESS = YUANBAO + "addr/";

    // 地址列表 http://118.178.228.52:81/index.php?s=/apiw/addr/addrlist (uid)
    public static final String ADDRESS_LIST = YUANBAO_ADDRESS + "addrlist";

    // 添加地址 http://118.178.228.52:81/index.php?s=/apiw/addr/addaddr (province area address uid  contacts tel)
    public static final String ADDRESS_ADD = YUANBAO_ADDRESS + "addaddr";

    // 编辑地址 http://118.178.228.52:81/index.php?s=/apiw/addr/editAddr (uid id token)
    public static final String ADDRESS_EDIT = YUANBAO_ADDRESS + "editAddr";

    // 删除地址 http://118.178.228.52:81/index.php?s=/apiw/addr/delAddr (uid id token)
    public static final String ADDRESS_DEL = YUANBAO_ADDRESS + "delAddr";

    /**
     * 抽奖接口
     **/
    public static final String YUANBAO_PRIZE = YUANBAO + "Luckdraws/";

    // 抽奖列表 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/plist (token)
    public static final String PRIZE_LIST = YUANBAO_PRIZE + "plist";

    // 抽奖详情 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/pinfo (token luckid)
    public static final String PRIZE_DETAIL = YUANBAO_PRIZE + "pinfo";

    // 抽奖操作 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/choujiang(token luckid uid)
    public static final String PRIZE_DRAW = YUANBAO_PRIZE + "choujiang";

    // 抽奖说明 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/remark(token luckid uid)
    public static final String PRIZE_REMARK = YUANBAO_PRIZE + "remark";

    // 我的抽奖 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/myLuckdrawWin(token uid)
    public static final String PRIZE_MINE = YUANBAO_PRIZE + "myLuckdrawWin";

    // 抽奖首页 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/home (token)
    public static final String PRIZE_HOME = YUANBAO_PRIZE + "home";

    // 添加收货地址 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/luckdraw_Win_addAdress (exch_record_id  addrid)
    public static final String PRIZE_ADDADRESS = YUANBAO_PRIZE + "luckdraw_Win_addAdress";

    // 修改收货地址 http://118.178.228.52:81/index.php?s=/apiw/Luckdraws/luckdraw_Win_editAdress (id  addrid)
    public static final String PRIZE_EDITADRESS = YUANBAO_PRIZE + "luckdraw_Win_editAdress";

    // 抽奖规则 http://118.178.228.52:81/index.php?s=/mobile/choujiang/rule (H5链接)
    public static final String PRIZE_RULE = YUANBAOMOBILE + "choujiang/rule";

    /**
     * 试用接口
     **/
    public static final String YUANBAO_TRYOUT  = YUANBAO + "trymalls/";
    public static final String YUANBAO_TRYOUT2 = YUANBAO + "trymall2s/";

    // 首页试用 http://118.178.228.52:81/index.php?s=/apiw/trymalls/home (token)
    public static final String TRYOUT_HOME = YUANBAO_TRYOUT + "home";

    // 试用列表 http://118.178.228.52:81/index.php?s=/apiw/trymalls/tlist (token sort)
    public static final String TRYOUT_LIST = YUANBAO_TRYOUT + "tlist";

    // 试用详情 http://118.178.228.52:81/index.php?s=/apiw/trymalls/tinfo (token id/2)
    public static final String TRYOUT_DETAIL = YUANBAO_TRYOUT + "tinfo";

    // 试用链接 http://118.178.228.52:81/index.php?s=/mobile/try/minfo&id=
    public static final String TRYOUT_MINFO = YUANBAOMOBILE + "try/minfo&id=";

    // 绑定淘宝 http://yuanbao.adyuansu.com/index.php?s=/apiw/trymalls/addApply (token uid taobaoid tryid)
    public static final String TRYOUT_ADDAPPLY = YUANBAO_TRYOUT + "addApply";

    // 我的试用 列表 待中奖 http://118.178.228.52:81/index.php?s=/apiw/trymalls/waitBeiginPrize (token uid)
    public static final String TRYOUT_WAIT = YUANBAO_TRYOUT + "waitBeiginPrize";

    // 我的试用 列表 已中奖 http://118.178.228.52:81/index.php?s=/apiw/trymalls/havePrize (token uid)
    public static final String TRYOUT_LREADY = YUANBAO_TRYOUT + "havePrize";

    // 我的试用 列表 未中奖 http://118.178.228.52:81/index.php?s=/apiw/trymalls/noPrize (token uid)
    public static final String TRYOUT_NO = YUANBAO_TRYOUT + "noPrize";

    // 我的试用 列表 待奖励 http://118.178.228.52:81/index.php?s=/apiw/trymalls/havePrizeNoReward (token uid)
    public static final String TRYOUT_AWARD = YUANBAO_TRYOUT + "havePrizeNoReward";

    // 我的试用 列表 已完成 http://118.178.228.52:81/index.php?s=/apiw/trymalls/havePrizeComplete (token uid)
    public static final String TRYOUT_FULFIL = YUANBAO_TRYOUT + "havePrizeComplete";

    // 我的试用 详情 http://118.178.228.52:81/index.php?s=/apiw/trymalls/orderInfoByid (token id)
    public static final String TRYOUT_ORDERINFO = YUANBAO_TRYOUT + "orderInfoByid";

    // 我的试用 详情 http://118.178.228.52:81/index.php?s=/apiw/trymall2s/isApply (token uid id )
    public static final String TRYOUT_ISAPPLY = YUANBAO_TRYOUT2 + "isApply";

    // 传图片接口  传关注和关注店铺 http://118.178.228.52:81/index.php?s=/apiw/trymalls/uploadimg (token file)
    public static final String TRYOUT_UPLOADIMG = YUANBAO_TRYOUT + "uploadimg";

    // 试用 去下单 http://118.178.228.52:81/index.php?s=/apiw/trymalls/doPlaceOrder (token id pic1s pic2s taoword1s taoword2s taoword3s taoword4s taoword5s taoword6s)
    public static final String TRYOUT_DOPLACEORDER = YUANBAO_TRYOUT + "doPlaceOrder";

    // 试用 修改订单号 http://118.178.228.52:81/index.php?s=/apiw/trymalls/editOrderNumber(token id)
    public static final String TRYOUT_EDITORDER = YUANBAO_TRYOUT + "editOrderNumber";

    // 试用 提交订单号 http://118.178.228.52:81/index.php?s=/apiw/trymalls/submitOrderNumber(token id)
    public static final String TRYOUT_SUBMORDER = YUANBAO_TRYOUT + "submitOrderNumber";

    // 试用报告详情 http://yuanbao.adyuansu.com/index.php?s=/mobile/try/reportByid   /id/1
    public static final String REPORT_DETAIL = YUANBAOMOBILE + "/try/reportByid/";

    // 试用 提交报告 http://118.178.228.52:81/index.php?s=/apiw/trymalls/reportSubmit (token id title pic1 pic2 pic3 pic4 pic5 pic6)
    public static final String TRYOUT_REPORT_SUBMIT = YUANBAO_TRYOUT + "reportSubmit";

    // 试用 修改报告 http://118.178.228.52:81/index.php?s=/apiw/trymalls/reportEdit (token id title pic1 pic2 pic3 pic4 pic5 pic6)
    public static final String TRYOUT_REPORT_EDIT = YUANBAO_TRYOUT + "reportEdit";

    // 试用 获取报告 http://118.178.228.52:81/index.php?s=/apiw/trymalls/findReportByOrderid  (token id)
    public static final String TRYOUT_REPORT_FIND = YUANBAO_TRYOUT + "findReportByOrderid";

    // 试用 删除试用 http://118.178.228.52:81/index.php?s=/apiw/trymall2s/delMyApply (token id)
    public static final String TRYOUT_DEL_APPLY = YUANBAO_TRYOUT2 + "delMyApply";

    // 发现 试用报告列表 http://118.178.228.52:81/index.php?s=/apiw/trymall2s/reportList (token)
    public static final String TRYOUT_REPORT_LIST = YUANBAO_TRYOUT2 + "reportList";

    // 发现 试用报告点赞 http://118.178.228.52:81/index.php?s=/apiw/trymall2s/reportZan (token)
    public static final String TRYOUT_REPORT_ZAN = YUANBAO_TRYOUT2 + "reportZan";

    // 试用 申请用户列表    http://118.178.228.52:81/index.php?s=/apiw/trymalls/applyList
    public static final String TRYOUT_PROPOSER = YUANBAO_TRYOUT + "applyList";

    // 试用 修改去下单信息 http://118.178.228.52:81/index.php?s=/apiw/trymalls/editPlaceOrder(token id pic1s pic2s taoword1s taoword2s taoword3s taoword4s taoword5s taoword6s )(说明:收藏宝贝和店铺,货比多家,访问店铺宝贝)
    public static final String TRYOUT_EDIT_PLACEORDER = YUANBAO_TRYOUT + "editPlaceOrder";
}
