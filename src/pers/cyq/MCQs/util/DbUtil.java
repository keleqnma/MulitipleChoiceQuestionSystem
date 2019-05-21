/**
 * @Project: MCQs 
 * @File: DbUtil.java 
 * @Date: May 20, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description:databse tools</p>
 */
package pers.cyq.MCQs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pers.cyq.MCQs.Constants;


/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 20, 2019
 * <p>Description: database utilizers</p>
 */
public class DbUtil {
	private static DbUtil db;
	private PropertiesUtils pu=PropertiesUtils.getProperUtil(Constants.CFG_NAME);
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public static DbUtil getDbUtil() {
		if (db == null) {
			db = new DbUtil(); 
		}
		return db;
	}
	
	public ResultSet executeQuery(String sql)  {
		if (getCon() == null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean execute(String sql) {
		if (getCon() == null) {
			return false;
		}
		try {
			Statement statement = conn.createStatement();
			statement.execute(sql);
			statement.close();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
	}
	
	public boolean checkinit(){
		return execute("select * from easyquestions");
	}
	/**
	 * get database connection
	 * @return
	 * @throws Exception
	 */
	public Connection getCon(){
		try{
			if (conn == null || conn.isClosed()){
				Class.forName(pu.getDriverName());
				conn=DriverManager.getConnection(pu.getDbUrl(),pu.getDbUsr(),pu.getDbPassWord());
			}
		}catch (ClassNotFoundException e) {
			System.out.println("jdbc driver is not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * close database connection
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(){
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public static void main(String[] args) {
		DbUtil dbUtil=getDbUtil();
		try {
			dbUtil.getCon();
			System.out.println("Connection successed£¡");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed£¡");
		}
	}*/
}
