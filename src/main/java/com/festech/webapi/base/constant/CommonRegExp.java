package com.festech.webapi.base.constant;

public class CommonRegExp {

    /**
     * 正则表达式：验证用户名(2到8个字的汉字,或者2到16个字的英文)
     */
    public static final String REGEX_USERNAME = "^(([\\u4e00-\\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{2,24}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_PHONE = "^((00[0-9])|1)\\d{10}$";
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
    /**
     * 正则表达式：验证数字
     */
    public static final String REGEX_NUM = "^[0-9]*$";

    /**
     * 正则表达式：验证社保账户
     */
    public static final String REGEX_SOCIALSECURITY_ACCOUNT = "^.{2,}$";
    /**
     * 正则表达式：验证金额
     */
    public static final String REGEX_AMOUNT = "^[0-9]{1,10}$";
    /**
     * 正则表达式：验证公积金账户
     */
    public static final String REGEX_FUND_ACCOUNT = "^.{2,}$";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 正则表达式：正整数
     */
    public static final String REGEX_POSTIVE_INTEGER = "^[1-9]\\d*$";


    /**
     * 正则表达式：验证图片格式
     */
    public static final String REGEX_PICTURE_SUFFIX = ".*(.jpg|.jpeg|.png|.gif|.bmp)$";

}
