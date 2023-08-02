package com.example.springbootwebsocketdemo.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.symmetric.AES;
import lombok.extern.log4j.Log4j2;

import java.nio.charset.StandardCharsets;

/**
 * @Description 对接前端密码加密，当前提供AES/CBC加密，根据前端加密进行扩展使用
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Log4j2
public class CryptoUtil {

    /**
    * 密钥, AEC加密要求要128个bit，所以必须使用16位16进制数
    */
    private final static String KEY = "FF0000FFFF000100";

    /**
    * 加盐,必须使用16位16进制数
    */
    private final static String IV = "000100FFFFFF8080";

    private static AES aes;

    static {
        // 初始化：包含采用算法类型设置
        aes = new AES("CBC", "PKCS5Padding",
                KEY.getBytes(StandardCharsets.UTF_8),
                IV.getBytes(StandardCharsets.UTF_8));
    }
    /**
     * aes加密
     * @return String
     */
    public static String aesEncode(String content){
        byte[] encrypt = aes.encrypt(content);
        // base64加密
        return Base64.encode(encrypt);
    }

    /**
     * 解密，前端加密后密码经过了base64加密，先需要base64解密
     * @param content 内容
     * @return String
     */
    public static String aesDecode(String content){
        byte[] base64Decode = Base64.decode(content);
        byte[] bytes = aes.decrypt(base64Decode);
        return new String(bytes);
    }

    /**
     * 提供密码统一的加密方式,两次加密+base64加密
     * @param password 密码
     * @return String
     */
    public static String encodePassword(String password){
        String encode1 = aesEncode(password);
        String encode2 = aesEncode(encode1);
        return Base64.encode(encode2.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 提供统一密码解密
     * @param password 密码
     * @return String
     */
    public static String decodePassword(String password){
        String base64Decode = Base64.decodeStr(password,StandardCharsets.UTF_8);
        try {
            String edCode1 = aesDecode(base64Decode);
            return aesDecode(edCode1);
        } catch (Exception e) {
            log.error("密码解密发生错误，返回原密码：{}", e.getMessage());
            return password;
        }
    }
}
