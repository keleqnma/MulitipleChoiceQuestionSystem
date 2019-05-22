/**
 * @Project: MCQs 
 * @File: QNAView.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: the view for user to answer given questions.</p>
 */
package pers.cyq.MCQs.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pers.cyq.MCQs.Constants;
import pers.cyq.MCQs.dao.QNADAO;
import pers.cyq.MCQs.model.QNA;

/**
 * The Class QNAView.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 20, 2019
 * <p>Description: show questions for user to answer </p>
 */
public class QNAView extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4913708280290665975L;
		
	/** The frame has 3 panels. */
	private JPanel northPnl,centerPnl,southPnl;
	
	/** The reset button. */
	private JButton rstBtn;
	
	/** 4 choose buttons. */
	private JButton[] chBtn;
	
	/** Those labels show current question, current score, and the answer of last question. */
	private JLabel curQuesLbl,scoreLbl,curAnsLbl;
	
	/** The qnalists stores all questions user need to answer. */
	private ArrayList<QNA> qnaLists;
	
	/** The score. */
	private static int score = 0;
	
	/** The question index. */
	private int index = 0;
	
	/** The increment is the score which users get when user hit the correct answer. */
	private final int increment;
	
	/** The qnalen is the size of the questions list. */
	private int qnalen;
	
	/**
	 * Instantiates a new QNA view.
	 *
	 * @param level the level
	 * @param apt the apt
	 */
	public QNAView(Constants.Level level, Constants.Attempt apt) {
		increment=level.ordinal()+1;
		init(level,apt);
	}
	
	/**
	 * private Init method.
	 *
	 * @param level easy, medium, difficult
	 * @param apt one answer, or two answer
	 */
	private void init(Constants.Level level, Constants.Attempt apt) {
		
		score=index=0;
		//north panel
		northPnl=new JPanel();
		curQuesLbl=new JLabel();		
		northPnl.add(curQuesLbl);
		
		//center panel
		centerPnl= new JPanel();
		centerPnl.setLayout(new GridLayout(4,1,0,15));
		centerPnl.setBorder(BorderFactory.createTitledBorder(Constants.QVIEW_JLABEL_TIP));
		
		qnaLists=QNADAO.getInstance().list(level);
		qnalen=qnaLists.size();
		
		chBtn=new JButton[4];
		for(int i=0;i<4;i++) {
			chBtn[i]=new JButton();
			centerPnl.add(chBtn[i]);
		}
		
		//south panel
		southPnl=new JPanel();
		scoreLbl=new JLabel();
		curAnsLbl=new JLabel();
		southPnl.add(scoreLbl);
		southPnl.add(curAnsLbl);
		rstBtn=new JButton(Constants.QVIEW_PARAM_RESET);
		rstBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				score=index=0;
				choose(apt);
			}});
		
		southPnl.add(rstBtn);
		
				
		Font font = new Font("Arial",1,20);
		for(int i=0;i<4;i++) chBtn[i].setFont(font);
		rstBtn.setFont(font);
		curQuesLbl.setFont(font);
		scoreLbl.setFont(font);
		curAnsLbl.setFont(font);
		
		add(BorderLayout.NORTH,northPnl);
		add(BorderLayout.CENTER,centerPnl);
		add(BorderLayout.SOUTH,southPnl);
		
		choose(apt);
		
		setTitle(Constants.TITLE); 
		setVisible(true);        
		setSize(Constants.FRM_SIZE, Constants.FRM_SIZE); 
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Choose.
	 *
	 * @param apt the apt
	 */
	private void choose(Constants.Attempt apt) {
		switch(apt) {
		case ONE:
			OneChoice(index);
			break;
		case TWO:
			TwoChoice(index,Constants.Turn.FIRST);
			break;
		}
	}
	
	/**
	 * Sets the layout.
	 *
	 * @param index the questions index which sets the new layout
	 */
	private void setQnaLayout(int index) {
		QNA curqna=qnaLists.get(index);
		String curAns=curqna.getAnswer();
		
		scoreLbl.setText(Constants.QVIEW_PARAM_SCORE+(score));
		curQuesLbl.setText(Constants.QVIEW_NUM_JLABEL_NO+(index+1)+" of " +qnalen+" : "+curqna.getQuestion());
		
		for(int i=0;i<4;i++) {
			String strBtn=curqna.getOptions()[i];
			chBtn[i].setText(strBtn);
		}
		
	}
	
	/**
	 * add score.
	 */
	private void scoreadd() {
		score+=increment;
	}
	
	/**
	 * add score.
	 *
	 * @param turn first time or second time to answer 
	 */
	private void scoreadd(Constants.Turn turn) {
		switch(turn) {
		case FIRST:
			score+=increment*2;
			break;
		case SECOND:
			score+=increment;
			break;
		}
	}

	/**
	 * One chance to answer.
	 *
	 * @param index the questions index
	 */
	private void OneChoice(int index) {
			setQnaLayout(index);
			
			QNA curqna=qnaLists.get(index);
			String curAns=curqna.getAnswer();
			
			for(int i=0;i<4;i++) {
				String strBtn=curqna.getOptions()[i];
				
				if(index>0)
					chBtn[i].removeActionListener(chBtn[i].getActionListeners()[0]);
				
				chBtn[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						curAnsLbl.setText(Constants.QVIEW_JLABEL_ANS+curAns);
						
						if(strBtn.equals(curAns)) scoreadd();
						if(index+1<qnalen) OneChoice(index+1);
						else finishQandA(Constants.Attempt.ONE);
					}
				});
			}
	}
	
	/**
	 * Two chances to answer.
	 *
	 * @param index the questions index
	 * @param turn first time or second time to answer 
	 */
	private void TwoChoice(int index,Constants.Turn turn) {
		setQnaLayout(index);
		
		QNA curqna=qnaLists.get(index);
		String curAns=curqna.getAnswer();
		
		for(int i=0;i<4;i++) { 
			String strBtn=curqna.getOptions()[i];
			
			if(chBtn[i].getActionListeners().length>0)
				chBtn[i].removeActionListener(chBtn[i].getActionListeners()[0]);
			
			chBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(strBtn.equals(curAns)) {
						curAnsLbl.setText(Constants.QVIEW_JLABEL_ANS+curAns);
						scoreadd(turn);
						if(index+1<qnalen) 
							TwoChoice(index+1, Constants.Turn.FIRST);
						else finishQandA(Constants.Attempt.TWO);
					}
					else if(turn == Constants.Turn.FIRST) {
						TwoChoice(index, Constants.Turn.SECOND);
					}
					else if(index+1<qnalen) {
						curAnsLbl.setText(Constants.QVIEW_JLABEL_ANS+curAns);
						TwoChoice(index+1, Constants.Turn.FIRST);
					}
					else finishQandA(Constants.Attempt.TWO);
				}
			});
		}
	}
	
	/**
	 * Finish the test.
	 *
	 * @param apt the apt
	 */
	private void finishQandA(Constants.Attempt apt) {
			if(apt == Constants.Attempt.TWO) new FinalView(score,increment*qnalen*2);
			else new FinalView(score,increment*qnalen);
			dispose();
	}
}
