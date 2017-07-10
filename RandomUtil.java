package hmap.core.util;

import java.util.Random;
import java.util.UUID;

/**
 * Copyright (c) 2017
 * Date:2017/4/18
 * Create By:ajisun
 * 随机数工具类
 */

public class RandomUtil {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


	/**
	* 随机数字(最小值+最大值是高一位的最小数)
	* 例如：六位数（100000+900000）
	**/
    public static int getRandomNum(int min, int max){
        Random rand = new Random();
        int randNum = min + rand.nextInt(max-1);
        return randNum;
    }




    //八位随机密码
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }


    public static void main(String[] args){
     
        System.out.println("随机6位数为   " + getRandomNum(100000,900000));

        System.out.println("随机密码为   " + generateShortUuid());

    }

}
