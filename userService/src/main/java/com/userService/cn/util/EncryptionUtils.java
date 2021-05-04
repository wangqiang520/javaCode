package com.userService.cn.util;

import cn.gjing.tools.common.exception.ParamException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 
 * 加密类
 * @author 王强
 *
 */
public class EncryptionUtils {

    /**
     * MD5加密
     * @param body 要加密的内容
     * @return 密文
     */
    public static String encodeMd5(String body) {
        StringBuilder buf = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(body.getBytes());
            byte[] b = md.digest();
            int i;
            for (byte b1 : b) {
                i = b1;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return buf.toString();
    }

    /**
     * Base64加密
     * @param content 要加密的内容
     * @return 密文
     */
    public static String encodeBase64(String content) {
        return Base64.encodeBase64String(content.getBytes());
    }

    /**
     * BASE64解密
     * @param content 要解密的内容
     * @return 明文
     */
    public static String decodeBase64(String content) {
        return new String(Base64.decodeBase64(content));
    }

    /**
     * sha256加密
     * @param str 要加密的内容
     * @return 密文
     */
    public static String encodeSha256(String str) {
		MessageDigest messageDigest;
		String encodeStr="";
		try {
			messageDigest=MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr=byteArrayToHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

    /**
     * sha566 hmac加密
     * @param str    要加密的内容
     * @param secret 密钥
     * @return  密文
     */
    public static String encodeSha256Hmac(String str, String secret) {
        String hash;
        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256Hmac.init(secretKey);
            byte[] bytes = sha256Hmac.doFinal(str.getBytes(StandardCharsets.UTF_8));
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            throw new ParamException("Encryption abnormal");
        }
        return hash;
    }
    /**
     * sha1Hmac加密
     * @param str    要加密的内容
     * @param secret 密钥
     * @return 密文
     */
    public static String sha1Hmac(String str, String secret) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(str.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(rawHmac);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AES加密
     * @param content  要加密的内容
     * @param password 加密需要的密码
     * @return 密文
     */
    public static String encodeAes(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");

            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.encodeBase64String(cipher.doFinal(byteContent));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param content  要解密的内容
     * @param password 解密需要的密码
     * @return 明文
     */
    public static String decodeAes(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.decodeBase64(content)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字节转成字符串
     * @param b 字节
     * @return String
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

}
