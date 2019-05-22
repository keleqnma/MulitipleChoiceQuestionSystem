/**
 * @Project: MCQs 
 * @File: StringUtil.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: the string utilizers </p>
 */
package pers.cyq.MCQs.util;

import java.util.Arrays;

/**
 * The Class StringUtil.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 20, 2019
 */
public class StringUtil {
	
	/**
	 * Checks if string is empty.
	 *
	 * @param str the strring
	 * @return true, if is empty
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if is not empty.
	 *
	 * @param str the string
	 * @return true, if is not empty
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * convert string array -> string, to store it in Mysql.
	 *
	 * @param strAry the string array
	 * @return the string
	 */
	public static String AtoS(String[] strAry){
		String str = Arrays.toString(strAry);
		return str;
	}
	
	/**
	 * string -> string array.
	 *
	 * @param str the string
	 * @return the string[]
	 */
	public static String[] StoA(String str){
		String[] strAry = str.replace("[","").replace("]", "").split(",");
		return strAry;
	}
	
}
