package net.ant.core.util;

import java.util.Date;
import java.util.UUID;

/**
 * 主键生成器
 * 
 */
public class IdGenerator {
	
	static long current = System.currentTimeMillis();

	/**
	 * 使用UUID获取唯一的字符串
	 * 
	 * @return uniqueID
	 */
	public static synchronized String generateUUID() {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		return id;
	}

	/**
	 * 使用系统时间获取唯一的字符串
	 * 
	 * @return uniqueID
	 */
	public static synchronized String generateId() {
		return DateUtil.convertToString(new Date(current++), "yyyyMMddHHmmssSSS");
	}

}
