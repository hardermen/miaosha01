package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5Util {
    public static String md5(String src){ return org.apache.commons.codec.digest.DigestUtils.md5Hex(src);}
    private static final String salt = "1a2b3c4d";
    public static String inputPassToFormPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass +salt.charAt(5)+salt.charAt(4);
        System.out.println(str);
        return md5(str);
    }
    public static String formPassToDBPass(String formPass,String salt){
            String str = ""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5);
            return md5(str);
        }
        public static String inputPassToDBpass(String inputPass, String saltDB){
            String formPass = inputPassToFormPass(inputPass);
            String dbPass = formPassToDBPass(formPass, saltDB);
            return dbPass;
        }

        public static void main(String[] args) {
            String fp = inputPassToFormPass("123456");
            System.out.println(fp);
            String dp = formPassToDBPass(fp,salt);
            System.out.println(dp);
    }
}
