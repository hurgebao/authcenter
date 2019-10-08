package com.none.authcenter.utils;

import java.text.MessageFormat;

public class StringUtils {
	public static String trim(String str) {
		if (str == null) {
			return null;
		}
		return str.trim().equals("") ? null : str.trim();
	}

	/**
	 * 格式化字体符串（例）format("这个是字符:[{1}],{2,number,#},{1}-{3,date,yyyymmdd}","AAA",
	 * "BBBB",123456.123456,new Date())
	 * 
	 * @param base
	 * @param params
	 * @return
	 */
	public static String format(String base, Object... params) {
		try {
			return MessageFormat.format(base, params);
		} catch (Exception e) {
			return base;
		}
	}

	public static String concat(Object... obj) {
		if (obj == null || obj.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (Object o : obj) {
			if (o != null) {
				sb.append(o);
			}
		}
		return sb.toString();
	}
}
