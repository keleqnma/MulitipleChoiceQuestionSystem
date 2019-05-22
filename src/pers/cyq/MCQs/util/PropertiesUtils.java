/**
 * @Project: MCQs 
 * @File: PropertiesUtils.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: properties utilizers</p>
 */
package pers.cyq.MCQs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class PropertiesUtils.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 21, 2019
 * <p>Description: properties utilizers</p>
 */
public class PropertiesUtils {
	
	/** The properties utilizers. */
	private static PropertiesUtils propUtil;
	
	/** The properties. */
	private static Properties prop;
	
	/**
	 * Gets the properties utilizer.
	 *
	 * @param propfile the properties files
	 * @return the properties utilizers
	 */
	public static PropertiesUtils getProperUtil(String propfile) {
		if (propUtil == null) {
			propUtil = new PropertiesUtils();
			prop=getPropertiesFromUserDir(propfile);
		}
		return propUtil;
	}
	
	/**
	 * Gets the properties from user directory.
	 *
	 * @param propfile the properties files
	 * @return the properties from user directory
	 */
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
 	 * Gets the driver name.
 	 *
 	 * @return the driverName
 	 */
	public String getDriverName() {
		return prop.getProperty("DRIVER");
	}
	
	 /**
 	 * Gets the dabtabase url.
 	 *
 	 * @return the database url
 	 */
		public String getDbUrl() {
			return prop.getProperty("URL");
		}
		
		 /**
 		 * Gets the database user name.
 		 *
 		 * @return the database user name
 		 */
		public String getDbUsr() {
			return prop.getProperty("USER");
		}
		
		 /**
 		 * Gets the database password.
 		 *
 		 * @return the database password
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
