package hmap.core.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Package Name: hmap.core.util
 * Date: 2018/8/2
 * Create By: ajisun
 */
public class SerialNumberUtil {

    public static void main(String[] arg) {
        String sno = "Quo2018080002";
        String letter = "Quo";
        System.out.println(getYearAndMonthNumber(letter, sno));
    }

    /**
     * 获取年月4位流水号
     *
     * @Param title
     * @Param thisCode 上一次的流水号（数据库最新一条记录）
     */
    public static synchronized String getYearAndMonthNumber(String letter, String thisCode) {
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

        if (thisCode == null || "".equals(thisCode) || thisCode.length()<10) {
            id = letter + formatter.format(date) + "0001";
            return id;
        }

        int titleLen = letter.length();
        String thisData = thisCode.substring(titleLen, titleLen + 6);
        //这个判断就是判断你数据取出来的最后一个业务单号是不是当月的
        System.out.println(thisData);
        if (!formatter.format(date).equals(thisData)) {
            System.out.println("新的一月");
            thisData = formatter.format(date);
            //如果是新的一月的就直接变成0001
            id = letter + thisData + "0001";
        } else {
            System.out.println("当月");
            DecimalFormat df = new DecimalFormat("0000");
            //不是新的一月就累加
            id = letter + formatter.format(date) + df.format(1 + Integer.parseInt(thisCode.substring(thisCode.length() - 4)));
        }
        return id;
    }


}
