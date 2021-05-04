package com.userService.cn.test;

import java.util.regex.Pattern;

public class TestPattern {
	public static void main(String[] args) {
		String regex="^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\\\\\\\d{8}$";
		regex="^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";
		
		//regex="^[1][3,4,5,7,8][0-9]{9}$";
		
		String input="13267125689";
		boolean falg=Pattern.matches(regex, input);
		if (falg) {
			System.out.println("手机号正确");
		}else {
			System.out.println("手机号错误");
			
		}
		
		
	}

}
