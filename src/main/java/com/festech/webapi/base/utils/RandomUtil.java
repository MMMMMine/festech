package com.festech.webapi.base.utils;

import java.util.Random;

public class RandomUtil {

    /**
     * @Author Frank
     * @Date 2017/8/1 下午9:38
     * @Description 获取指定位数验证码
     */
    public static String getRandomCode(int length) {

        return String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, length - 1)));
    }

    /**
     * 生成临保任务编号方法
     *
     * @param str
     * @return
     */
    public static String getMissionNo(String str) {
        String hashStr = String.valueOf(Math.abs(str.hashCode()));
        String randomStr = String.valueOf(RandomUtil.getRandomCode(4));
        long unixTime = System.currentTimeMillis() / 1000;//10时间戳
        return hashStr + unixTime + randomStr;//临保任务编号
    }


    public static String getMissionToken(int length){
        String missionToken = "";
        Random rand = new Random();

        for(int i = 0; i < length ; i++){
            int num = rand.nextInt(3);
            switch(num){
                case 0:
                    char c1 = (char)(rand.nextInt(26)+'a');//生成随机小写字母
                    missionToken += c1;
                    break;
                case 1:
                    char c2 = (char)(rand.nextInt(26)+'A');//生成随机大写字母
                    missionToken += c2;
                    break;
                case 2:
                    missionToken += rand.nextInt(10);//生成随机数字
            }
        }

        return missionToken;
    }

}
