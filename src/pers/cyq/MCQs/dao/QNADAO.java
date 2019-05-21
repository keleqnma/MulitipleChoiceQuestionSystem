/**
 * @Project: MCQs 
 * @File: QNADAO.java 
 * @Date: May 20, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
 */
package pers.cyq.MCQs.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import pers.cyq.MCQs.model.QNA;
import pers.cyq.MCQs.util.*;
import pers.cyq.MCQs.Constants;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 20, 2019
 * <p>Description: toolkits used to interfere with local databases</p>
 */
public class QNADAO {
	private DbUtil db=DbUtil.getDbUtil();
	private ResultSet rs;
	private static QNADAO qd=null;
	
	public static synchronized QNADAO getInstance() {
		if (qd == null) {
			qd = new QNADAO();
		}
		return qd;
	}
	
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
	 * add questions 
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	public boolean add(QNA qna,Constants.Level level)throws Exception{
		boolean result = false;
		if(qna==null) return result;
		String sql;
		switch(level){
		case EASY:
			sql="insert into easyquestions values(?,?,?,?)";
			break;
		case MEDI:
			sql="insert into mediquestions values(?,?,?,?)";
			break;
		case DIFF:
			sql="insert into diffquestions values(?,?,?,?)";
			break;
		default:
			throw new IllegalArgumentException();
		}
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, qna.getId());
		pstmt.setString(2, qna.getQuestion());
		pstmt.setString(3, qna.getAnswer());
		pstmt.setString(4, StringUtil.AtoS(qna.getOptions()));
		return result;
	}
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
	
	private void buildList(ResultSet rs, ArrayList<QNA> list, int i) throws SQLException {
		QNA qna = new QNA();
		qna.setId(rs.getInt("id"));
		qna.setQuestion(rs.getString("question"));
		qna.setAnswer(rs.getString("answer"));
		qna.setOptions(StringUtil.StoA(rs.getString("options")));
		list.add(qna);
	}
}
