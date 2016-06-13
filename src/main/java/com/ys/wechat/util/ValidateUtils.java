package com.ys.wechat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:手机验证
 *
 * @author 吕志博
 * @date 2016-5-19 下午1:57:41
 * @version V1.0
 */
public class ValidateUtils {
	public static boolean isMobilePhone(String phone) {

		Pattern pattern = Pattern
				.compile("^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$");
		Matcher matcher = pattern.matcher(phone);

		if (matcher.matches()) {
			return true;
		}
		return false;

	}
	
	// 验证11位1开头的手机
	public static boolean isMobilePhone1(String phone) {
		Pattern pattern = Pattern.compile("^1[0-9][0-9]{9}$");// 只验证11位1开头的手机
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	// 验证11以内位数字
	public static boolean isPhone(String phone) {
		Pattern pattern = Pattern.compile("^[0-9]{4,11}$");// 只验证11位1开头的手机
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
