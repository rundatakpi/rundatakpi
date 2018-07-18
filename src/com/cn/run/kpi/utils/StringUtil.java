package com.cn.run.kpi.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
/**
 * 字符串工具类
 * @author user
 *
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

	private static final Logger LOGGER = Logger.getLogger(StringUtil.class);

	// 相当于加了synchronized的Long
	@SuppressWarnings("unused")
	private static AtomicLong next = new AtomicLong(1);

	// 转换格式
	private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
	
    private static final char SEPARATOR = '_';

	// 所有字母
	private final static char[] CHR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };

	// 小写字母
	private final static char[] LOWERCHAR = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	// 大写字母
	private final static char[] UPPERCHAR = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	// -------------------------------String类API----------------------------------

	/**
	 * 获取字符串指定索引的字符
	 * 
	 * @param str
	 *            字符串
	 * @param index
	 *            索引
	 * @return 返回字符
	 */
	public static char charAt(String str, int index) {
		return str.charAt(index);
	}

	/**
	 * 获取字符串指定索引位置的字符的Unicode编码值
	 * 
	 * @param str
	 *            字符串
	 * @param index
	 *            索引
	 * @return 索引位置的字符的Unicode编码值
	 */
	public static int codePointAt(String str, int index) {
		return str.codePointAt(index);
	}

	/**
	 * 按字典顺序比较两个字符串
	 * 
	 * @param str
	 *            字符串
	 * @param anotherString
	 *            字符串
	 * @return str大就返回1，反之返回-1，相等返回0
	 */
	public static int compareTo(String str, String anotherString) {
		return str.compareTo(anotherString);
	}

	/**
	 * 按字典顺序比较两个字符串,忽略大小写
	 * 
	 * @param str
	 *            字符串
	 * @param anotherString
	 *            字符串
	 * @return str大就返回1，反之返回-1，相等返回0
	 */
	public static int compareToIgnoreCase(String str, String anotherString) {
		return str.compareToIgnoreCase(anotherString);
	}

	/**
	 * 将anotherString拼接到str结尾
	 * 
	 * @param str
	 *            字符串
	 * @param anotherString
	 *            字符串
	 * @return 拼接后的字符串
	 */
	public static String concat(String str, String anotherString) {
		return str.concat(anotherString);
	}

	/**
	 * 判断str字符串是否包含anotherString字符串
	 * 
	 * @param str
	 *            字符串
	 * @param anotherString
	 *            字符串
	 * @return str包含anotherString时返回true，反之返回false
	 */
	public static boolean contains(String str, String anotherString) {
		return str.contains(anotherString);
	}

	/**
	 * 将字符数组转为字符串
	 * 
	 * @param data
	 *            字符数组
	 * @return 字符串
	 */
	public static String copyValueOf(char[] data) {
		return String.copyValueOf(data);
	}

	/**
	 * 将字符数组的部分转为字符串
	 * 
	 * @param data
	 *            字符数组
	 * @param offset
	 *            指定索引开始，包含该索引
	 * @param count
	 *            转换的字符个数
	 * @return 字符串
	 */
	public static String copyValueOf(char[] data, int offset, int count) {
		return String.copyValueOf(data, offset, count);
	}

	/**
	 * 判断str字符串是否以suffix字符串后缀结束
	 * 
	 * @param str
	 *            字符串
	 * @param suffix
	 *            后缀字符串
	 * @return 是就返回true，反之返回false
	 */
	public static boolean endsWith(String str, String suffix) {
		return str.endsWith(suffix);
	}

	/**
	 * 判断量字符串是否相同
	 * 
	 * @param str
	 *            字符串
	 * @param anotherString
	 *            字符串
	 * @return 相同返回true，反之返回false
	 */
	public static boolean equals(String str, String anotherString) {
		return str.equals(anotherString);
	}

	/**
	 * 判断量字符串是否相同,忽略大小写
	 * 
	 * @param str
	 *            字符串
	 * @param anotherString
	 *            字符串
	 * @return 相同返回true，反之返回false
	 */
	public static boolean equalsIgnoreCase(String str, String anotherString) {
		return str.equalsIgnoreCase(anotherString);
	}

	/**
	 * 将字符串转为字节数组
	 * 
	 * @param str
	 *            字符串
	 * @return 字节数组
	 */
	public static byte[] getBytes(String str) {
		return str.getBytes();
	}

	/**
	 * 将字符串以指定字符集编码转为字节数组
	 * 
	 * @param str
	 *            字符串
	 * @param charsetName
	 *            编码
	 * @return 字节数组
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] getBytes(String str, String charsetName) throws UnsupportedEncodingException {
		return str.getBytes(charsetName);
	}

	/**
	 * 返回字符串的哈希码值
	 * 
	 * @param str
	 *            字符串
	 * @return 哈希码值
	 */
	public static int hashCode(String str) {
		return str.hashCode();
	}

	/**
	 * 返回ch字符在str字符串第一次出现的索引
	 * 
	 * @param str
	 *            字符串
	 * @param ch
	 *            字符
	 * @return 索引
	 */
	public static int indexOf(String str, char ch) {
		return str.indexOf(ch);
	}

	/**
	 * 返回ch字符在str字符串第一次出现的索引，从指定索引开始
	 * 
	 * @param str
	 *            字符串
	 * @param ch
	 *            字符
	 * @param fromIndex
	 *            指定索引
	 * @return 索引值
	 */
	public static int indexOf(String str, char ch, int fromIndex) {
		return str.indexOf(ch, fromIndex);
	}

	/**
	 * 返回指定字符串在此字符串中第一次出现出的索引
	 * 
	 * @param str
	 *            此字符串
	 * @param auotherString
	 *            指定字符串
	 * @return 索引值
	 */
	public static int indexOf(String str, String anotherString) {
		return str.indexOf(anotherString);
	}

	/**
	 * 返回指定字符串在此字符串中第一次出现出的索引,从指定索引位置开始找
	 * 
	 * @param str
	 *            此字符串
	 * @param auotherString
	 *            指定字符串
	 * @return 索引值
	 */
	public static int indexOf(String str, String anotherString, int fromIndex) {
		return str.indexOf(anotherString, fromIndex);
	}

	/**
	 * 判断字符串是否为空，即长度是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return 为空则返回true，反之返回false
	 */
	public static boolean isEmpty(String str) {
		return str.isEmpty();
	}

	/**
	 * 返回指定字符在此字符串中最后一次出现处的索引
	 * 
	 * @param str
	 *            此字符串
	 * @param ch
	 *            指定字符
	 * @return 索引
	 */
	public static int lastIndexOf(String str, char ch) {
		return str.lastIndexOf(ch);
	}

	/**
	 * 返回指定字符在此字符串中最后一次出现的索引，从指定的索引处开始进行反向
	 * 
	 * @param str
	 *            此字符串
	 * @param ch
	 *            指定字符
	 * @param fromIndex
	 *            指定索引
	 * @return 索引值
	 */
	public static int lastIndexOf(String str, char ch, int fromIndex) {
		return str.lastIndexOf(ch, fromIndex);
	}

	/**
	 * 返回指定字符在此字符串中最后一次出现处的索引
	 * 
	 * @param str
	 *            此字符串
	 * @param ch
	 *            指定字符
	 * @return 索引
	 */
	public static int lastIndexOf(String str, String anotherString) {
		return str.lastIndexOf(anotherString);
	}

	/**
	 * 返回指定字符串在此字符串中最后一次出现的索引，从指定的索引处开始进行反向
	 * 
	 * @param str
	 *            此字符串
	 * @param ch
	 *            指定字符串
	 * @param fromIndex
	 *            指定索引
	 * @return 索引值
	 */
	public static int lastIndexOf(String str, String anotherString, int fromIndex) {
		return str.lastIndexOf(anotherString, fromIndex);
	}

	/**
	 * 返回此字符串长度
	 * 
	 * @param str
	 *            此字符串
	 * @return 长度
	 */
	public static int length(String str) {
		return str.length();
	}

	/**
	 * 告知此字符串是否匹配该正则
	 * 
	 * @param str
	 *            此字符串
	 * @param regex
	 *            该正则
	 * @return 匹配就返回true，反之返回false
	 */
	public static boolean matches(String str, String regex) {
		return str.matches(regex);
	}

	/**
	 * 用newChar替换此字符串中的oldChar字符，
	 * 
	 * @param str
	 *            此字符串
	 * @param oldChar
	 *            字符串中的字符
	 * @param newChar
	 *            新字符
	 * @return 替换后的新字符串
	 */
	public static String replace(String str, char oldChar, char newChar) {
		return str.replace(oldChar, newChar);
	}

	/**
	 * 使用指定的replacement字符串替换此字符串所有匹配给定的正则regex的字符串
	 * 
	 * @param str
	 *            此字符串
	 * @param regex
	 *            正则
	 * @param replacement
	 *            替换的字符串
	 * @return 新的字符串
	 */
	public static String replaceAll(String str, String regex, String replacement) {
		return str.replaceAll(regex, replacement);
	}

	/**
	 * 根据给定的正则表达式regex来拆分此字符串
	 * 
	 * @param str
	 *            此字符串
	 * @param regex
	 *            正则表达式
	 * @return 字符串数组
	 */
	public static String[] split(String str, String regex) {
		return str.split(regex);
	}

	/**
	 * 测试此字符串是否以指定的前缀开始
	 * 
	 * @param str
	 *            此字符串
	 * @param prefix
	 *            前缀字符串
	 * @return 是以此前缀开始就返回true，反之返回false
	 */
	public static boolean startsWith(String str, String prefix) {
		return str.startsWith(prefix);
	}

	/**
	 * 测试此字符串是否以指定的前缀开始，从指定索引处开始
	 * 
	 * @param str
	 *            此字符串
	 * @param prefix
	 *            前缀字符串
	 * @param toffset
	 *            指定索引
	 * @return
	 */
	public static boolean startsWith(String str, String prefix, int toffset) {
		return str.startsWith(prefix, toffset);
	}

	/**
	 * 从指定索引处截取此字符串到串尾
	 * 
	 * @param str
	 *            此字符串
	 * @param beginIndex
	 *            开始索引
	 * @return 截取后的字符串
	 */
	public static String substring(String str, int beginIndex) {
		return str.substring(beginIndex);
	}

	/**
	 * 截取字符串，从指定开始位置到结束位置，（包含起始索引，不包含结尾索引）
	 * 
	 * @param str
	 *            此字符串
	 * @param beginIndex
	 *            开始索引
	 * @param endIndex
	 *            结束索引
	 * @return 新字符串
	 */
	public static String substring(String str, int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}

	/**
	 * 将此字符串转换为字符数组
	 * 
	 * @param str
	 *            此字符串
	 * @return 字符数组
	 */
	public static char[] toCharArray(String str) {
		return str.toCharArray();
	}

	/**
	 * 将此字符串字符全部转小写并返回
	 * 
	 * @param str
	 *            此字符串
	 * @return 转换后的字符串
	 */
	public static String toLowerCase(String str) {
		return str.toLowerCase();
	}

	/**
	 * 将此字符串字符全部转为大写
	 * 
	 * @param str
	 *            此字符串
	 * @return 转换后的字符串
	 */
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}

	/**
	 * 去除此字符串收尾空格字符
	 * 
	 * @param str
	 *            此字符串
	 * @return 去除空格后的字符串
	 */
	public static String trim(String str) {
		return str.trim();
	}

	/**
	 * 将字符数组转换为字符串
	 * 
	 * @param data
	 *            字符数组
	 * @return 字符串
	 */
	public static String valueOf(char[] data) {
		return String.valueOf(data);
	}

	// -------------------------------String类API----------------------------------

	/**
	 * 如果字符串为null,则把null转成空字符串
	 * 
	 * @param strSrc
	 *            传入字符串
	 * @return
	 */
	public static String filterNull(String strSrc) {
		return strSrc == null ? "" : ((String) strSrc).trim();
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            传入字符串
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 去掉字符串空白字符
	 * 
	 * @param str
	 *            传入字符串
	 * @return 去掉空白字符后的字符串
	 */
	public static String trim2(String str) {
		// 去掉所有空白字符
		return str.replaceAll("\\s*", "");
	}

	/**
	 * 获得0-9的随机数
	 * 
	 * @param length
	 *            随机数长度
	 * @return String 返回字符串
	 */
	public static String getRandomNumber(int length) {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < length; i++) {
			buffer.append(random.nextInt(10));
		}
		return buffer.toString();
	}

	/**
	 * 获得0-9,a-z,A-Z范围的随机数
	 * 
	 * @param length
	 *            随机数长度
	 * @return String 返回字符串
	 */
	public static String getRandomChar(int length) {

		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append(CHR[random.nextInt(62)]);
		}
		return buffer.toString();
	}

	/**
	 * 获得a-z范围的随机数
	 * 
	 * @param length
	 *            随机数长度
	 * @return String 返回字符串
	 */
	public static String getRandomLowerChar(int length) {

		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append(LOWERCHAR[random.nextInt(LOWERCHAR.length)]);
		}
		return buffer.toString();
	}

	/**
	 * 获得A-Z范围的随机数
	 * 
	 * @param length
	 *            随机数长度
	 * @return String 返回字符串
	 */
	public static String getRandomUpperChar(int length) {

		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append(UPPERCHAR[random.nextInt(UPPERCHAR.length)]);
		}
		return buffer.toString();
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 *            某字符串
	 * @return 为空则返回true，否则返回false
	 */
	public static boolean isEmpty(Object obj) {
		return obj == null || obj.toString().length() == 0;
	}

	/**
	 * 判断集合是否为空
	 * 
	 * @param lst
	 *            集合对象
	 * @return 为空则返回true，否则返回false
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List lst) {
		return lst == null || lst.isEmpty() || lst.size() == 0;
	}

	/**
	 * 将对象转换成字符串输出
	 * 
	 * @param obj
	 *            对象
	 * @return 返回字符串
	 */
	public static String objToStr(Object obj) {
		if (isEmpty(obj)) {
			return "";
		} else {
			return obj.toString().trim();
		}
	}

	/**
	 * 将对象转换成字符串输出(如果为空则用指定值替换)
	 * 
	 * @param obj
	 *            某对象
	 * @param paddingV
	 *            替换字符串
	 * @return 返回指定字符串
	 */
	public static String objToStr(Object obj, String paddingV) {
		if (isEmpty(obj)) {
			return paddingV;
		} else {
			return obj.toString().trim();
		}
	}

	/**
	 * 字符串首字母大写
	 * 
	 * @param str
	 *            字符串
	 * @return String 返回首字母大写的字符串
	 */
	public static String upperFirstChar(String str) {
		if (str != null && str.length() > 0) {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		} else {
			return str;
		}
	}

	/**
	 * 字符串首字母小写
	 * 
	 * @param str
	 *            字符串
	 * @return String 返回首字母大写的字符串
	 */
	public static String lowerFirstChar(String str) {
		if (str != null && str.length() > 0) {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		} else {
			return str;
		}
	}

	/**
	 * 判断字符串数组中是否包含字符串
	 * 
	 * @param strArray
	 *            字符串数组
	 * @param str
	 *            字符串
	 * @return 包含就返回true，否则返回false
	 */
	public static boolean isIn(String[] strArray, String str) {
		if (strArray == null || strArray.length == 0) {
			return false;
		}
		for (String s : strArray) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 将字符串反转
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 反转后的字符串
	 */
	public static String inverse(String str) {
		char[] chars = str.toCharArray(); // 得到字符数组
		for (int i = 0; i < chars.length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = temp;
		}
		return String.copyValueOf(chars);
	}

	/**
	 * 判断字符串是否为对称字符串
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 对称则返回true，否则返回false
	 */
	public static boolean isSymmetry(String str) {
		char[] ch = str.toCharArray();
		for (int x = 0; x < ch.length; x++) {
			if (ch[x] != ch[ch.length - x - 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取字符串中最长的对称串
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 最长的对称串
	 */
	public static String findSymmetry(String str) {
		String symmetryStr;
		for (int i = str.length() - 1; i > 0; i--) { // 找是否有长度为i的对称串，i从最大开始
			for (int j = 0; j < str.length() && j + i < str.length(); j++) {
				symmetryStr = str.substring(j, j + i + 1);
				char[] chars = symmetryStr.toCharArray();
				int k;
				// 判断是否为对称串
				for (k = 0; k < chars.length / 2; k++) {
					if (chars[k] != chars[chars.length - k - 1]) {
						break;
					}
				}
				// 如果对称则返回
				if (k == chars.length / 2) {
					return symmetryStr;
				}
			}

		}
		return "";
	}

	/**
	 * 求字符串中对称串的个数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 返回对称串的个数
	 */
	public static int findSymmetryCount(String str) {
		int count = 0;
		String symmetryStr;
		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j < str.length() && j + i < str.length(); j++) {
				symmetryStr = str.substring(j, j + i + 1);
				char[] chars = symmetryStr.toCharArray();
				int k;
				// 判断是否为对称串
				for (k = 0; k < chars.length / 2; k++) {
					if (chars[k] != chars[chars.length - k - 1]) {
						break;
					}
				}
				// 如果对称，则count+1
				if (k == chars.length / 2) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * 求字符串中出现频率最高的字符
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 返回出现频率最高的字符
	 */
	public static char findHightRateChar(String str) {
		int max = 0;
		char c = ' ';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				map.put(chars[i], map.get(chars[i]) + 1);
				if (map.get(chars[i]) > max) {
					max = map.get(chars[i]);
					c = chars[i];
				}
			} else {
				map.put(chars[i], 1);
			}
		}
		return c;
	}

	private static final String PATTERN_LINE_START = "^";

	private static final String PATTERN_LINE_END = "$";

	private static final char[] META_CHARACTERS = { '$', '^', '(', ')', '|', '+', '.', '\\' };

	/**
	 * 判断是否匹配正则表达式
	 * 
	 * @param regex		正则表达式
	 * @param str		字符串
	 * @return			匹配返回true，反之返回false
	 */
	public static boolean regex(String regex, String str) {
		return str.matches(regex);
	}
	
	/**
	 * 判断是否匹配正则表达式
	 * 
	 * @param pattern
	 *            正则字符串,会拼接成正则表达式
	 * @param str
	 *            需要匹配的字符串
	 * @return 匹配则返回true，否则返回false
	 */
	public static boolean regexMatch(String pattern, String str) {
		String result = PATTERN_LINE_START;
		char[] chars = pattern.toCharArray();
		for (char ch : chars) {
			if (Arrays.binarySearch(META_CHARACTERS, ch) >= 0) {
				result += "\\" + ch;
				continue;
			}
			switch (ch) {
			case '*':
				result += ".*";
				break;
			case '?':
				result += ".{0,1}";
				break;
			default:
				result += ch;
			}
		}
		result += PATTERN_LINE_END;
		if (LOGGER.isInfoEnabled()) {
			
			LOGGER.info(result);
		}
		return Pattern.matches(result, str);
	}

	/**
	 * 判断是否为正确的ip格式字符串
	 * 
	 * @param ip
	 *            ip字符串
	 * @return 符合就返回true，否则返回false
	 */
	public static boolean isIP(String ip) {
		Pattern pattern = Pattern.compile(
				"\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();
	}

	/**
	 * 判断是否为正确的电话字符串
	 * 
	 * @param phone
	 *            电话号码
	 * @return 符合就返回true，否则返回false
	 */
	public static boolean isPhone(String phone) {
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	
	/**
	 * 判断是否为正确的邮箱地址
	 * 
	 * @param email
	 *            邮箱地址
	 * @return 符合就返回true，否则就返回false
	 */
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern
				.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z0-9A-Z]{2,}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * 查找字符串个数
	 * 
	 * @param str
	 *            字符串
	 * @param sub
	 *            子串
	 * @return int 匹配的个数
	 */
	public static int findCharCount(String str, String sub) {
		if (str == null || sub == null || str.length() == 0 || sub.length() == 0) {
			return 0;
		}
		int count = 0, pos = 0, idx = 0;
		while ((idx = str.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}
		return count;
	}
	
	/**
	 * 判断字符串中是否有汉字
	 * 
	 * @param str		字符串
	 * @return			返回去掉汉字后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String gbk(String str) throws UnsupportedEncodingException {
		char[] chars = str.toCharArray();
		String sum = "";
		for (int i = 0; i < chars.length; i++) {
			byte[] bytes = ("" + chars[i]).getBytes("GBK");
			if (bytes.length == 2) {
				int[] ints = new int[2];
				ints[0] = bytes[0] & 0xff;
				ints[1] = bytes[1] & 0xff;
				if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40
						&& ints[1] <= 0xFE) {
					continue;
				}
			} else {
				sum += chars[i];
			}
		}
		return sum;
	}

	/**
	 * 查找字符串中有多少汉字
	 * 
	 * @param s
	 *            传入的字符串
	 * @return 汉字的个数
	 */
	public static int countHanZi(String str) {
		String regex = "[\u4e00-\u9fff]";
		int count = (" " + str + " ").split(regex).length - 1;
		return count;
	}

	/**
	 * String转ASCII码
	 * 
	 * @param str
	 *            传入的字符串
	 * @return ASCII码
	 */
	public static String stringToAscii(String str) {
		StringBuffer sbu = new StringBuffer();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i <= chars.length - 1) {
				int ii = chars[i];
				sbu.append(Integer.toHexString(ii));
			} else {
				sbu.append((int) chars[i]);
			}
		}
		return sbu.toString();
	}

	/**
	 * ASCII转String
	 * 
	 * @param value
	 *            传入的ASCII
	 * @return 返回字符串
	 */
	public static String asciiToString(String value) {
		if ("".equals(value) || value == null) {
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i = i + 2) {
			if (i < chars.length - 1) {
				int ii = Integer.valueOf(Character.toString(chars[i]) + Character.toString(chars[i + 1]), 16);
				stringBuffer.append((char) (ii));
			}
		}
		return stringBuffer.toString();
	}

	/**
	 * 输入流转字符串
	 * 
	 * @param in
	 *            传入的输入流
	 * @return 转成的字符串
	 * @throws IOException
	 */
	public static String inputStreamToString(InputStream in) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int count = -1;
		while ((count = in.read(data, 0, 2048)) != -1)
			outStream.write(data, 0, count);

		data = null;
		return new String(outStream.toByteArray());
	}

	/**
	 * 转换HTML中的特殊字符
	 * 
	 * @param input
	 *            传入的字符串
	 * @return String 转换后的字符串
	 */
	public static String convertHTML(String input) {
		if (input == null)
			return null;
		else {
			StringBuffer filtered = new StringBuffer();
			char c;
			for (int i = 0; i <= input.length() - 1; i++) {
				c = input.charAt(i);
				switch (c) {
				case '&':
					filtered.append("&amp;");
					break;
				case '<':
					filtered.append("&lt;");
					break;
				case '>':
					filtered.append("&gt;");
					break;
				case '"':
					filtered.append("&#034;");
					break;
				case '\'':
					filtered.append("&#039;");
					break;
				default:
					filtered.append(c);
				}
			}
			return (filtered.toString().replace("\n", ""));
		}
	}

	/**
	 * 四舍五入
	 * 
	 * @param double
	 *            传入的数字
	 * @param scale
	 *            保留位数
	 * @return 返回四舍五入后的数字
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 获得主键
	 * 
	 * @return String
	 */
	public static String getPrimaryKey() {
		UUID uuid = UUID.randomUUID();
		return dateformat.format(new Date())
				+ uuid.toString().replaceAll("-", "").substring(0, 16);
	}
	
	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)){
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}
	
	/**
	 * 替换为手机识别的HTML，去掉样式及属性，保留回车。
	 * @param html
	 * @return
	 */
	public static String replaceMobileHtml(String html){
		if (html == null){
			return "";
		}
		return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
	}
	
	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr2(String param, int length) {
		if (param == null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		int n = 0;
		char temp;
		boolean isCode = false; // 是不是HTML代码
		boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
		for (int i = 0; i < param.length(); i++) {
			temp = param.charAt(i);
			if (temp == '<') {
				isCode = true;
			} else if (temp == '&') {
				isHTML = true;
			} else if (temp == '>' && isCode) {
				n = n - 1;
				isCode = false;
			} else if (temp == ';' && isHTML) {
				isHTML = false;
			}
			try {
				if (!isCode && !isHTML) {
					n += String.valueOf(temp).getBytes("GBK").length;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (n <= length - 3) {
				result.append(temp);
			} else {
				result.append("...");
				break;
			}
		}
		// 取出截取字符串中的HTML标记
		String tempResult = result.toString().replaceAll("(>)[^<>]*(<?)",
				"$1$2");
		// 去掉不需要结素标记的HTML标记
		tempResult = tempResult
				.replaceAll(
						"</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
						"");
		// 去掉成对的HTML标记
		tempResult = tempResult.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>",
				"$2");
		// 用正则表达式取出标记
		Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
		Matcher m = p.matcher(tempResult);
		List<String> endHTML = Lists.newArrayList();
		while (m.find()) {
			endHTML.add(m.group(1));
		}
		// 补全不成对的HTML标记
		for (int i = endHTML.size() - 1; i >= 0; i--) {
			result.append("</");
			result.append(endHTML.get(i));
			result.append(">");
		}
		return result.toString();
	}
	
	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}
	
	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toCamelCase(String s) {
    	String str = s;
        if (s == null) {
            return null;
        }

        str = s.toLowerCase();

        StringBuilder sb = new StringBuilder(str.length());
        boolean upperCase = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toCapitalizeCamelCase(String s) {
    	String str = s;
        if (s == null) {
            return null;
        }
        str = toCamelCase(s);
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    /**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
 
    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     * @param objectString 对象串
     *   例如：row.user.id
     *   返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString){
    	StringBuilder result = new StringBuilder();
    	StringBuilder val = new StringBuilder();
    	String[] vals = split(objectString, ".");
    	for (int i=0; i<vals.length; i++){
    		val.append("." + vals[i]);
    		result.append("!"+(val.substring(1))+"?'':");
    	}
    	result.append(val.substring(1));
    	return result.toString();
    }
	
	/**  
     * 18位身份证  
     * 获取 年龄  
     * @param idCard  
     * @return  
     */  
    public static String getAgeByIdCard18(String idCard){  
  
        //身份证上的年月日  
        String idyear = idCard.substring(6).substring(0, 4);// 得到年份  
        String idyue = idCard.substring(10).substring(0, 2);// 得到月份  
        String idday = idCard.substring(12).substring(0, 2);//得到日  
        String idyr = idyue + idday + "";  
  
        //当前年月日  
        String year = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0, 4);// 当前年份  
        String yue = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(5, 7);// 月份  
        String day = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(8, 10);  
        String yr = yue + day + "";  
  
        int age = 0;  
        if (Integer.parseInt(idyr) <= Integer.parseInt(yr)) { // 表示生日已过  
            age = Integer.parseInt(year) - Integer.parseInt(idyear) + 1;  
        } else {// 生日未过  
            age = Integer.parseInt(year) - Integer.parseInt(idyear);  
        }  
        return age + "";  
    }
	
	 /**  
     * 15位身份证  
     * 获取 年龄  
     * @param idCard  
     * @return  
     */  
    public static String getAgeByIdCard15(String idCard){
  
        //身份证上的年月日  
        String idyear = "19" + idCard.substring(6, 8);  
        String idyue = idCard.substring(8, 10);  
        String idday = idCard.substring(10, 12);  
        String idyr = idyue + idday + "";  
  
        //当前年月日  
        String year = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0, 4);// 当前年份  
        String yue = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(5, 7);// 月份  
        String day = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(8, 10);  
        String yr = yue + day + "";  
  
        int age = 0;  
        if (Integer.parseInt(idyr) <= Integer.parseInt(yr)) { // 表示生日已过  
            age = Integer.parseInt(year) - Integer.parseInt(idyear) + 1;  
        } else {// 生日未过  
            age = Integer.parseInt(year) - Integer.parseInt(idyear);  
        }  
        return age + "";  
    } 

}
