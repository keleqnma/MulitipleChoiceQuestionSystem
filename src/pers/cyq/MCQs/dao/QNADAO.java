/**
 * @Project: MCQs 
 * @File: QNADAO.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: Database Access Object, toolkits used to interfere with local databases</p>
 */
package pers.cyq.MCQs.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import pers.cyq.MCQs.model.QNA;
import pers.cyq.MCQs.util.*;
import pers.cyq.MCQs.Constants;

/**
 * The Class QNADAO.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 20, 2019
 * <p>Description: toolkits used to interfere with local databases</p>
 */
public class QNADAO {
	
	/** The database utilizers. */
	private DbUtil db=DbUtil.getDbUtil();
	
	/** The resultSet. */
	private ResultSet rs;
	
	/** The qna database access object. */
	private static QNADAO qd=null;
	
	/**
	 * Gets the single instance of QNADAO.
	 *
	 * @return single instance of QNADAO
	 */
	public static synchronized QNADAO getInstance() {
		if (qd == null) {
			qd = new QNADAO();
		}
		return qd;
	}
	
	/**
	 * Destroy.
	 */
	private void destroy() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	/**
	 * list questions .
	 *
	 * @param level the level
	 * @return the array list
	 */
	
	public ArrayList<QNA> list(Constants.Level level){
		String sql;
		switch(level){
			case EASY:
				sql="select * from easyquestions";
				break;
			case MEDI:
				sql="select * from mediquestions";
				break;
			case DIFF:
				sql="select * from diffquestions";
				break;
			default:
				throw new IllegalArgumentException();
		}
		
		ResultSet rs=db.executeQuery(sql);
		
		ArrayList<QNA> result=new ArrayList<QNA>();
		int i=0;
		try {
			while(rs.next()) {
				buildList(rs, result, i);
				i++;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
			return result;
	}
	
	/**
	 * Builds the array lists from the result set.
	 *
	 * @param rs the result set
	 * @param list the array lists
	 * @param i the index
	 * @throws SQLException the SQL exception
	 */
	private void buildList(ResultSet rs, ArrayList<QNA> list, int i) throws SQLException {
		QNA qna = new QNA();
		qna.setId(rs.getInt("id"));
		qna.setQuestion(rs.getString("question"));
		qna.setAnswer(rs.getString("answer"));
		qna.setOptions(StringUtil.StoA(rs.getString("options")));
		list.add(qna);
	}
}
