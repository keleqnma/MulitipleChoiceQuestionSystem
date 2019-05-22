/**
 * @Project: MCQs 
 * @File: MainView.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: the main function to start.</p>
 */
package pers.cyq.MCQs.view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import pers.cyq.MCQs.util.DbUtil;


/**
 * The Class MainView.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 20, 2019
 * <p>Description: [//TODO] </p>
 */
public class MainView {
	
	/**
	 * Database init.
	 */
	static void dbinit(){
		DbUtil dbUtil=DbUtil.getDbUtil();
		
		//check whether the database initializes
		if(dbUtil.checkinit()) return;
		
		//initialize database
		//insert test data
		//easy
		dbUtil.execute("CREATE TABLE `easyquestions` if not exists (`id` int(255) NOT NULL, `question` varchar(255), `answer` varchar(255),`options` varchar(255))");
		dbUtil.execute("INSERT INTO `easyquestions` VALUES (1, 'What is the capital of France?', 'Paris', 'Paris,Beijing,London,Rio')");
		dbUtil.execute("INSERT INTO `easyquestions` VALUES (2, 'What nationality was Newton?', 'English', 'English,Japanese,French,Chinese')");
		dbUtil.execute("INSERT INTO `easyquestions` VALUES (3, 'What is the chemical symbol for hydrogen?', 'H', 'H,A,B,C');");
		dbUtil.execute("INSERT INTO `easyquestions` VALUES (4, 'When did man land on the moon?', '1969', '1969,1066,1215,2001')");
		dbUtil.execute("INSERT INTO `easyquestions` VALUES (5, 'Whats is the first name of Yuqi Chen?', 'Yuqi', 'Yuqi,Chen,Cen,Yui')");
		
		//medi
		dbUtil.execute("CREATE TABLE `mediquestions` if not exists (`id` int(255) NOT NULL, `question` varchar(255), `answer` varchar(255),`options` varchar(255))");
		dbUtil.execute("INSERT INTO `mediquestions` VALUES (1, 'What is the name of first dog Yuqi Chen?', 'Robber', 'Cola,Coco,Robber,Pesi')");
		dbUtil.execute("INSERT INTO `mediquestions` VALUES (2, 'Which is the biggest lake in China?', 'Dongting Lake', 'Qinghai Lake,Poyang Lake,Hongze Lake,Dongting Lake')");
		dbUtil.execute("INSERT INTO `mediquestions` VALUES (3, 'When is the World Water Day?', 'March 23rd', 'April 1st,March 23rd, June 22nd,July 1st')");
		dbUtil.execute("INSERT INTO `mediquestions` VALUES (4, 'What diseases does a low-salt diet help prevent?', 'hypertension', 'hepatitis B,diabetes mellitus,hypertension,anemia')");
		dbUtil.execute("INSERT INTO `mediquestions` VALUES (5, 'The shelf life of food refers to its:', 'Optimum consumption period', 'Date of production,Final consumption period,Optimum consumption period,Date of factory')");
		
		//difficult
		dbUtil.execute("CREATE TABLE `diffquestions` if not exists (`id` int(255) NOT NULL, `question` varchar(255), `answer` varchar(255),`options` varchar(255))");
		dbUtil.execute("INSERT INTO `diffquestions` VALUES (1, 'Whats's the last name of Yuqi Chen?', 'Chen', 'Yuqi,Chen,Yui,Cen')");
		dbUtil.execute("INSERT INTO `diffquestions` VALUES (2, 'Do not use any of the following foods for colds ', 'sea fish', 'soybean milk,sea fish,green vegetables,ginger')");
		dbUtil.execute("INSERT INTO `diffquestions` VALUES (3, 'What are the nutritional contents of lemon juice?', 'vitamin A and vitamin C', 'vitamin A and vitamin C,vitamin B1 and vitamin C,vitamin C,vitamin B6')");
		dbUtil.execute("INSERT INTO `diffquestions` VALUES (4, 'The trace elements in apples that enhance memory are', 'Zinc', 'Iron,Zinc,Calcium,Iodine')");
		dbUtil.execute("INSERT INTO `diffquestions` VALUES (5, 'In nature, the so-called \"intelligent element\" is', 'Iodine', 'Iron,Iodine,Calcium,Zinc')");
		
	}
	
	/**
	 * Show(package BeautyEye)init.
	 */
	static void showinit() {
		 try
		    {
		        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		        UIManager.put("RootPane.setupButtonVisible", false);
		        BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
		        
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    	//TODO exception
		    }
	}
	
	/**
	 * Check the environment for the package "BeautyEye" , which requires jdk1.6, jdk1.7 or jdk1.8.
	 *
	 * @return true, if successful
	 */
	static boolean checkenv() {
		String jdkVersion = System.getProperty("java.version");
		return (jdkVersion.matches("1.[678](.*)"));//1.8.0_112
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 * @Title£∫main 
	 * @Description: [π¶ƒ‹√Ë ˆ]
	 * @Param: @param args
	 * @Return: void
	 * @CreateDate: May 20, 2019 12:46:49 PM
	 */
	public static void main(String[] args) throws SQLException {
		if(checkenv()) showinit();
		dbinit();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttemptView frame = new AttemptView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		DbUtil.getDbUtil().closeCon();
		
	}

}
