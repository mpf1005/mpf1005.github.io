package com.offenhealth.hdmp.eshop.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by earl on 2017/4/18.
 */
public class FontUtils {

    private FontUtils() {  }


    /**
     * 随机生成汉字
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getRandomChinaFont(int length)  {
        StringBuffer str = new StringBuffer("");
        for(int i = 0; i < length; i++) {
            int hightPos; //
            int lowPos;
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39)));
            lowPos = (161 + Math.abs(random.nextInt(93)));

            byte[] b = new byte[2];
            b[0] = (Integer.valueOf(hightPos)).byteValue();
            b[1] = (Integer.valueOf(lowPos)).byteValue();
            try {
                str.append(new String(b, "GBK"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("错误");
            }
        }
        return str.toString();
    }

    //生成随机数字和字母,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
