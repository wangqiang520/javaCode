package com.userService.cn.test;

import org.apache.commons.lang.RandomStringUtils;

import com.userService.cn.util.SHA256Util;

import cn.gjing.tools.common.util.BeanUtils;
import cn.gjing.tools.common.util.EncryptionUtils;
import cn.gjing.tools.common.util.RandomUtils;

public class TestEncryptionUtils {
	public static void main(String[] args) {
		EncryptionUtils encryptionUtils=new EncryptionUtils();
		System.out.println(encryptionUtils.encodeMd5("wang"));
		System.out.println(encryptionUtils.encodeSha256Hmac("wang", "wq"));
		System.out.println(SHA256Util.getSha256("wang"));
		RandomUtils rn=new RandomUtils();
	}
	


}
