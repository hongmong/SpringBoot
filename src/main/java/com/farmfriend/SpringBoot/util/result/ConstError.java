package com.farmfriend.SpringBoot.util.result;

/**
 * Created by xiemin on 2016/9/22.
 */
public class ConstError {
    public static final int LOG_IN_FAILD = 21;
    public static final String LOG_IN_FAILD_INFO = "login failed";

    public static final int INTER_ERROR = 13;
    public static final String INTER_ERROR_INFO = "inter error";

    public static final int PARAM_ERROR= 14;
    public static final String PARAM_ERROR_INFO = "param error";

    //idserver
    public static final int LANDINFO_FAILD = 100001;
    public static final int GETAUTOCODE_FAILED = 100002;
    public static final String SENDCODE_FAILED_INFO = "sms send failed";
    public static final String PHONE_INVAILD_INFO = "phone not exist";
    public static final int GETUSERLIST_MORE_THAN_MAXCOUNT = 100100;
    public static final String GETUSERLIST_MORE_THAN_MAXCOUNT_INFO = "count more than max";
    public static final int IDSERVER_RETURN_ERROR = 100200;
    //idserver end

    //flowcount
    public static final int EMPTY_MODULELIST_DATA = 200001;
    public static final String EMPTY_MODULELIST_DATA_INFO = "no modulelist data";
    public static final int NO_ACCEPT_ORDER = 200002;
    public static final String NO_ACCEPT_ORDER_INFO = "no accept order";
    public static final int ORDER_NOT_EXIST = 200003;
    public static final String ORDER_NOT_EXIST_INFO = "order not exist";
    public static final int EMPTY_MODULEID_DATE = 200004;
    public static final String EMPTY_MODULEID_DATE_INFO = "no moduleid date";
    public static final int ORDER_TIME_INVAILD= 200005;
    public static final String ORDER_TIME_INVAILD_INFO = "order time invaild";
    public static final int NO_VAILD_FLYTRACK_DATA= 200006;
    public static final String NO_VAILD_FLYTRACK_DATA_INFO = "no vaild flytrack data";
    //flowcount end

    //UserCenter start
    public static final int LOGIN_USER_NOT_FOUND = 400001;
    public static final String LOGIN_USER_NOT_FOUND_INFO = "用户不存在";
    public static final int LOGIN_PW_ERROR= 400002;
    public static final String LOGIN_PW_ERROR_INFO = "密码错误";
    public static final int LOGIN_TOKEN_OUTDATE= 400003;
    public static final String LOGIN_TOKEN_OUTDATE_INFO = "TOKEN过期";
    public static final int LOGIN_TOKEN_INVALID= 400004;
    public static final String LOGIN_TOKEN_INVALID_INFO = "TOKEN无效";
    public static final int LOGIN_USER_IS_FREEZE = 400005;
    public static final String LOGIN_USER_IS_FREEZE_INFO = "账号已被冻结";

    //UserCenter end

    //Weather start
    public static final int  NO_VALID_ORDERNUMBER = 500001;
    public static final String NO_VALID_ORDERNUMBER_INFO="no valid ordernumber";
    public static final int  NO_VALID_WORKSTARTDATE = 500002;
    public static final String NO_VALID_WORKSTARTDATE_INFO="no valid date";
    public static final int  WEATHER_NOT_EXIST = 500003;
    public static final String WEATHER_NOT_EXIST_INFO="暂无天气数据";
    public static final int  SAVE_FAILED = 500004;
    public static final String SAVE_FAILED_INFO="save failed";
    public static final int  WEATHER_RETURN_FAILED = 500005;
    public static final String WEATHER_RETURN_FAILED_INFO="weather return failed";
    public static final int WEATHER_NOT_RELATE_LAND=2;
    public static final String WEATHER_NOT_RELATE_LAND_INFO="订单尚未关联地块。暂无天气数据";
    //Weather end

    //configserver
    public static final int REGIONAL_RESULT_ERROR = 501001;
    public static final String REGIONAL_RESULT_ERROR_INFO = "获取行政区划信息失败";
    //configserver end

    // activity start
    public static final int IS_INNER_USER = 600001;      // 内部飞手
    public static final String IS_INNER_USER_INFO = "is innerUser";
    public static final int IS_NOT_REDENVELOPE_ORDER = 600002;       // 非红包订单
    public static final String IS_NOT_REDENVELOPE_ORDER_INFO = "is not redEnvelope order";
    public static final int CHECK_LOGIN_ERROR = 600003;     // 验证登录失败
    public static final String CHECK_LOGIN_ERROR_INFO = "fail get userid or token";
    public static final int ORDER_STATE_NOT_IN_ACTIVITY = 600004;       // 订单状态不在红包活动中
    public static final String ORDER_STATE_NOT_IN_ACTIVITY_INFO = "ordeState is not in activity";
    public static final int ORDER_MESSAGE_ERROR = 600005;        // 获取订单信息失败
    public static final String ORDER_MESSAGE_ERROR_INFO = "fail get order message";
    public static final int REDENVELOPE_OVER = 600006;      // 红包已发完
    public static final String REDENVELOPE_OVER_INFO = "redEnvelope is send over";
    public static final int ORDER_OPEN_REDENVELOPE_ERROR = 600007;      // 订单开启红包失败
    public static final String ORDER_OPEN_REDENVELOPE_ERROR_INFO = "fail open redEnvelope";
    public static final int REPEAT_OPEND_REDENVELOPE = 600008;      // 重复开启红包
    public static final String REPEAT_OPEND_REDENVELOPE_INFO = "repeat open redEnvelope";
    public static final int ALREADY_RECEIVE_REDENVELOPE = 600009;       // 已接收红包
    public static final String ALREADY_RECEIVE_REDENVELOPE_INFO = "already receive the redEnvelope";
    public static final int GET_ORDER_MARK_ERROR = 600010;      // 订单评分失败
    public static final String GET_ORDER_MARK_ERROR_INFO = "fail get order mark";
    public static final int IS_NOT_ACTIVITY_DAY = 600011;       // 不在红包活动日
    public static final String IS_NOT_ACTIVITY_DAY_INFO = "is not in activity day";
    public static final int ORDER_OUTPACE_RECEIVETIME = 600012;       // 订单超出领取期间
    public static final String ORDER_OUTPACE_RECEIVETIME_INFO = "order outpace receive time";
    public static final int FLYUSER_INFO_ERROR = 600013;       // 订单超出领取期间
    public static final String FLYUSER_INFO_ERROR_INFO = "flyUser info error";
    public static final int GET_FLYUSER_AGREED_ERROR = 600014;       // 订单超出领取期间
    public static final String GET_FLYUSER_AGREED_ERROR_INFO = "get flyUser agreed error";
    // activity end

    //msgcenter
    public static final int MSGCENTER_UPDATE_USERMSGBLACKLIST_STATE_FAIL = 701000;
    public static final String MSGCENTER_UPDATE_USERMSGBLACKLIST_STATE_FAIL_INFO = "msgcenter update usermsgblacklist failed";
    public static final int GET_MSGINFOLIST_IS_NULL = 701001;
    public static final String GET_MSGINFOLIST_IS_NULL_INFO = "get msginfolist is null";
    //msgcenter end

    //cronserver
    public static final int CRONSERVER_GROUP_NAME_EXIST = 202000;
    public static final String CRONSERVER_GROUP_NAME_EXIST_INFO = "job exist";
    public static final int CRONSERVER_CRONEXPREESS_INVAILD = 202001;
    public static final String CRONSERVER_CRONEXPREESS_INVAILD_INFO = "cronexpress invaild";
    public static final int CRONSERVER_DEL_JOB_FAILED = 202002;
    public static final String CRONSERVER_DEL_JOB_FAILED_INFO = "del fail";
    public static final int CRONSERVER_GROUP_NAME_NOT_EXIST = 202003;
    public static final String CRONSERVER_GROUP_NAME_NOT_EXIST_INFO = "job not exist";

    // university start
    public static final int UNIVERSITY_ARTICLE_IS_DOWNLINE = 800001;
    public static final String UNIVERSITY_ARTICLE_IS_DOWNLINE_INFO = "帖子已下线，无法查看详情！";
    // university end

}
