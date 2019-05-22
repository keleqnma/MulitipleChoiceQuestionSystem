/**
 * @Project: MCQs 
 * @File: DbUtil.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: database utilizers </p>
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
 * The Class DbUtil.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 20, 2019
 * <p>Description: database utilizers</p>
 */
public class DbUtil {
	
	/** The database utilizers. */
	private static DbUtil db;
	
	/** The Properties utilizers. */
	private PropertiesUtils pu=PropertiesUtils.getProperUtil(Constants.CFG_NAME);
	
	/** The database connection. */
	private Connection conn;
	
	/** The PreparedStatement. */
	private PreparedStatement ps;
	
	/** The result set. */
	private ResultSet rs;

	/**
	 * Gets the database utilizers, avoid the overlap.
	 *
	 * @return the database utilizers
	 */
	public static DbUtil getDbUtil() {
		if (db == null) {
			db = new DbUtil(); 
		}
		return db;
	}
	
	/**
	 * Execute query.
	 *
	 * @param sql the SQL statement
	 * @return the result set
	 */
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
	
	/**
	 * Execute the SQL statement.
	 *
	 * @param sql the SQL statement
	 * @return true, if successful
	 */
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
	
	/**
	 * Check the database initialization.
	 *
	 * @return true, if successful
	 */
	public boolean checkinit(){
		return execute("select * from easyquestions");
	}
	
	/**
	 * get database connection.
	 *
	 * @return the con
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
	 * close database connection.
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
	
	//test connection
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
