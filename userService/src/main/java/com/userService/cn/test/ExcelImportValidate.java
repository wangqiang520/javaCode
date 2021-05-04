package com.userService.cn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Excel导入检验工具类 Created by fengjie.luo on 2016/4/14 0014.
 */
public class ExcelImportValidate {

	public static final int NO_VALIDATE = 0;//不校验
	public static final int IS_NUMERIC = 1;// 是否为纯数字
	public static final int IS_CONTAINT_CHINESE = 2;// 是否包含中文
	public static final int IS_CONTAINT_SPECIAL_CHARATER = 3;// 是否包含特殊字符
	public static final int IS_CONTAINT_DIGIT = 4;// 是否包含数字
	public static final int IS_VALID_DATE = 5;// 是否合法日期格式
	public static final int IS_CONTAINT_CHINESE_AND_SPECIAL_CHARATER = 6;// 是否包含中文和特殊字符
	public static final int IS_CONTAINT_DIGIT_AND_SPECIAL_CHARATER = 7;// 是否包含数字和特殊字符
	public static final int IS_VALID_SEX = 8;// 是否正确的性别类型（只能填男或者女）
    public static final int IS_VALID_CARDTYPE = 9;// 是否正确的证件类型（只能填身份证、港澳通行证、护照中的一种）
	public static final int IS_VALID_CARDNO = 10;// 是否正确的证件号码（只能校验身份证号）
	public static final int IS_VALID_PHONE = 11;// 是否正确的电话号码（包括固话和手机号码）
	public static final int IS_VALID_DATE_SELF_ADAPTION = 12;// 是否合法日期格式，允许自适应适配
	// 检验是否为数字
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		}
		return false;
	}

	// 校验是否包含中文字符
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	// 校验是否包含特殊字符
	public static boolean isContainSpecialCharacter(String str) {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	// 校验是否包含数字
	public static boolean isContainDigit(String content) {
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(content);
		if (m.matches()) {
			return true;
		}
		return false;
	}

	// 校验是否为合法日期格式
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			convertSuccess = false;
		}
		return convertSuccess;
	}

	public static boolean isValidDateSelfAdaption(String date){
		return DataValidator.isDate(date);
	}

	// 校验是否为正确的性别类型
	public static boolean isValidSex(String sex) {
		if (sex.equals("男") || sex.equals("女")) {
			return true;
		}
		return false;
	}

	// 校验是否为正确的证件类型
	public static boolean isValidCardType(String cardType) {
		//被保人证件类型 1:身份证,2:护照,3:出生证,4:驾照,5:军官证,6:其他
		if (cardType.equals("身份证") || cardType.equals("护照") || cardType.equals("出生证") || cardType.equals("驾照") || cardType.equals("军官证") || cardType.equals("其他")) {
			return true;
		}
		return false;
	}

	// 校验是否为正确的证件号码
	public static boolean isValidCardNo(String cardType,String cardNo) {
		if (cardType.equals("身份证")) {
			if (IDCardUtil.isIDCard(cardNo)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * 手机号验证
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	/**
	 * 电话号码验证
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null,p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
		if(str.length() >9)
		{   m = p1.matcher(str);
			b = m.matches();
		}else{
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}
}
