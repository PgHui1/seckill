package com.example.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;


@Component
public class MD5Util {
    private static final String  salt = "1a2b3c4d";
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    /*用户从网页端输入过来的密码*/
    public static String inputPassToFromPass(String inputPass){
        StringBuilder str = new StringBuilder(""+salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4));
        System.out.println(str);
        return md5(str.toString());
    }

    public static String formPassToDBPass(String formPass,String salt){
        String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        return formPassToDBPass(fromPass,salt);
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("aaa"));
            System.out.println(inputPassToDBPass("aaa","1a2b3c4d"));
    }
}
