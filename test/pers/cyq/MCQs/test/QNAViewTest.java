/**
 * @Project: MCQs 
 * @File: QNAViewTest.java 
 * @Date: May 21, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
 */
package pers.cyq.MCQs.test;

import pers.cyq.MCQs.view.QNAView;
import pers.cyq.MCQs.Constants;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 21, 2019
 * <p>Description: [//todo] </p>
 */
class QNAViewTest {

	/**
	 * Test method for {@link pers.cyq.MCQs.view.QNAView#QNAView(pers.cyq.MCQs.Constants.Level, pers.cyq.MCQs.Constants.Attempt)}.
	 */
	@Test
	void testQNAView() {
		new QNAView(Constants.Level.EASY,Constants.Attempt.TWO);
		new QNAView(Constants.Level.EASY,Constants.Attempt.ONE);
		new QNAView(Constants.Level.MEDI,Constants.Attempt.ONE);
	}

}
