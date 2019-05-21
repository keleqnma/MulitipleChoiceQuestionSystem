/**
 * @Project: MCQs 
 * @File: StringUtil.java 
 * @Date: May 20, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: string tools </p>
 */
package pers.cyq.MCQs.util;

import java.util.Arrays;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 20, 2019
 */
public class StringUtil {
	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * convert string array -> string, to store in Mysql.
	 * @param str
	 * @return
	 */
	public static String AtoS(String[] strAry){
		String str = Arrays.toString(strAry);
		return str;
	}
	
	/**
	 * 
	 * string -> string array
	 * @param str
	 * @return
	 */
	public static String[] StoA(String str){
		String[] strAry = str.replace("[","").replace("]", "").split(",");
		return strAry;
	}
	
}
