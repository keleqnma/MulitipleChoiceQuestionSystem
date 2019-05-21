/**
 * @Project: MCQs 
 * @File: AppConstants.java 
 * @Date: May 19, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow"> Yuqi Chen</a>
 * @Version v1.0
 */
package pers.cyq.MCQs;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 19, 2019
 * <p>Description: constants interface</p>
 */
public interface Constants {
	
	//all view
	int FRM_SIZE=1000;
	String TITLE = " Multiple Choice Question ";
	
	//JDBC
	String CFG_NAME="MCQcfg.properties";
	
	/*
	 * 
	String DB_URL="jdbc:mysql://localhost:3306/qna?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false"; 
		//prevent unrecognizable characters.
	String DB_USERNAME="root"; 
	String DB_PASSWORD="Cyq@65536"; 
	String DB_DRIVER="com.mysql.cj.jdbc.Driver"; 
	*/
	
	
	//level view
	String LEVELVIEW_JLABEL_CH = "Please choose the level of the questions.";
	String LEVELVIEW_EASY = "Easy";
	String LEVELVIEW_MEDI = "Medium";
	String LEVELVIEW_DIFF = "Difficult";
	
	//level view & QNADAO
	public enum Level{
		EASY,MEDI,DIFF
	}
	
	//attempt view
	String APTVIEW_JLABEL_CH = "Answer once or answer twice?";
	String APTVIEW_ONCE = "Answer once";
	String APTVIEW_TWICE = "Answer twice";
	public enum Attempt{
		ONE,TWO
	}
	
	//question view
	String QVIEW_NUM_JLABEL_NO="Question ";
	String QVIEW_NUM_JLABEL_SUM=" of ";
	String QVIEW_JLABEL_TIP="Possible Answers:click one";
	String QVIEW_JLABEL_ANS="Answer of last question: ";
	String QVIEW_PARAM_RESET="reset score";
	String QVIEW_PARAM_SCORE="score= ";
	public enum Turn{
		FIRST,SECOND
	}
	
	//final view
	String FVIEW_CON_JLABEL="Congratulations! You have finished all the questions.";
	String FVIEW_SCO_JLABEL="You had got: ";
	String FVIEW_PARAM_AGAIN="Another Game.";
	String FVIEW_PARAM_FIN="Game Over.";
}
