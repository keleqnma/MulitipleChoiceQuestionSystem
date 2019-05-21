/**
 * @Project: MCQs 
 * @File: PropertiesUtils.java 
 * @Date: May 21, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
 */
package pers.cyq.MCQs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 21, 2019
 * <p>Description: [//todo] </p>
 */
public class PropertiesUtils {
	private static PropertiesUtils propUtil;
	private static Properties prop;
	
	public static PropertiesUtils getProperUtil(String propfile) {
		if (propUtil == null) {
			propUtil = new PropertiesUtils();
			prop=getPropertiesFromUserDir(propfile);
		}
		return propUtil;
	}
	
	private  static Properties  getPropertiesFromUserDir(String propfile){
	        Properties properties = new Properties();
	        String rootPath = System.getProperty("user.dir");
	        FileInputStream in = null;
	        try {
	            in = new FileInputStream(rootPath + File.separator + propfile);
	            //get config files
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            properties.load(in);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return properties;
	    }

	 /**
	 * @return the driverName
	 */
	public String getDriverName() {
		return prop.getProperty("DRIVER");
	}
	
	 /**
		 * @return the database url
		*/
		public String getDbUrl() {
			return prop.getProperty("URL");
		}
		
		 /**
		 * @return the driverName
		 */
		public String getDbUsr() {
			return prop.getProperty("USER");
		}
		
		 /**
		 * @return the driverName
		 */
		public String getDbPassWord() {
			return prop.getProperty("PASS");
		}

	/*
	public static void main(String[] args) {
	        System.out.println(getPropertiesFromUserDir("MCQcfg.properties").getProperty("URL"));
	}
	*/
}
