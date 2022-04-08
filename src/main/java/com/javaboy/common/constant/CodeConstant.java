package com.javaboy.common.constant;

import cn.hutool.core.util.IdUtil;

/**
 * @author v-baihaitao
 */
public class CodeConstant {
    /**
     * 操作
     */
    public static final int FAIL = 0;

    public static final String FAIL_DESC = "操作失败！";

    public static final int SUCCESS = 200;

    public static final String SUCCESS_DESC = "操作成功！";

    /**
     * 登录相关
     */
    public static final String COMMON_LOGIN_FLAG="COMMON_LOGIN_FLAG_";

    public static final String PARAM_ERROR = "参数错误或为空！";

    /**
     * 验证码错误
     */
    public static final int CODE_ERROR_CODE = 30009;

    public static final String CODE_ERROR_CODE_DESC = "图形验证码错误";

    public static final String USER_OR_PASSWORD_ERROR_DESC = "用户名或密码不正确";

    public static final String USER_DISABLE_DESC = "此用户已被禁用!";

    public static final String LOGIN_SUCCESS_DESC = "登录成功！";

    /**
     * 平台id
     */
    public static final String LOOPHOLE_ID="9f91c138ac8c4181abd07b14a1b96c18";

    public static final String ZhONG_CE_ID="c3a1a59ff2424509976de4127771aca7";

    public static final String QING_BAO_ID="f58c6c8044014c479e86dd28ff74e20f";


    /**
     * token
     */
    public static final String TOKEN = IdUtil.simpleUUID();


    /**
     * 用户未登录
     */
    public static final int USER_NOT_LOGIN_ERROR = 10005;

    public static final String USER_NOT_LOGIN_ERROR_DESC =  "您尚未登录，请先登录";

    public static final int USER_PASS_CHANGE_ERROR = 10006;

    public static final String USER_PASS_CHANGE_ERROR_DESC = "用户密码已被修改，请重新登录";
    public static final String CHANGE_PASS = "change_pass_";
    public static final String CHANGE_PASS_VALUE = "1";


    /**
     * token过期时间
     */
    public static final int TOKEN_OUT_TIME = 6;
    public static final String TOKEN_TIME_FLAG="flag";



    public static final String MSG ="msg";

}
