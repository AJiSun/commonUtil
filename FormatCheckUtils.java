package hmap.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (c) 2017. 
 * Date:2017/4/13
 * Create By:ajisun
 * 格式验证工具类
 */

public class FormatCheckUtils {

    private static final String REGEX_MOBILE  = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static final String REGEX_SHORTNAME = "^(([a-zA-Z0-9]+[-(_|.)|-]?)*[a-zA-Z0-9]+)$";


	//  手机号码格式验证
    public static boolean checkPhoneNumber(String phoneNumber){

        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();

    }

	// 邮箱格式验证
    public static boolean checkEmail(String email){

        Pattern regex = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }


	// 由 字母 数字 "_" "." "-"  组成长度 >1 <20 但三个特殊字符又不能同时出现
    public static boolean checkShortName(String shortName){

        Pattern p = Pattern.compile(REGEX_SHORTNAME);
        Matcher m = p.matcher(shortName);
        if (shortName.length()<20 && shortName.length()>=1 &&m.matches()){
            return true;
        }
        return false;
    }



    public  static void main(String[] args){
        System.out.println(checkShortName("ksquZHF1"));

    }


}
