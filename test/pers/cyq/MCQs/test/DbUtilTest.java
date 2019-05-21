/**
 * @Project: MCQs 
 * @File: DbUtilTest.java 
 * @Date: May 21, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
 */
package pers.cyq.MCQs.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.jupiter.api.Test;
import pers.cyq.MCQs.util.DbUtil;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 21, 2019
 * <p>Description: [//todo] </p>
 */
class DbUtilTest {
	private DbUtil db=DbUtil.getDbUtil();

	/**
	 * Test method for {@link pers.cyq.MCQs.util.DbUtil#getDbUtil()}.
	 */
	@Test
	void testGetDbUtil() {
		DbUtil dbt = DbUtil.getDbUtil();
		assertEquals(dbt,db);
	}

	/**
	 * Test method for {@link pers.cyq.MCQs.util.DbUtil#executeQuery(java.lang.String)}.
	 */
	@Test
	void testExecuteQuery() {
		String sql="select * from easyquestions";
		db.executeQuery(sql);
	}

	/**
	 * Test method for {@link pers.cyq.MCQs.util.DbUtil#getCon()}.
	 */
	@Test
	void testGetCon() {
		Connection con1=db.getCon();
		Connection con2=db.getCon();
		assertEquals(con1,con2);
	}

	/**
	 * Test method for {@link pers.cyq.MCQs.util.DbUtil#closeCon()}.
	 */
	@Test
	void testCloseCon() {
		db.closeCon();
	}

}
