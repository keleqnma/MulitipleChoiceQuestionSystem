/**
 * @Project: MCQs 
 * @File: QuestionView.java 
 * @Date: May 20, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
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
 * @author cyq
 * @Project: MCQs 
 * @Date: May 20, 2019
 * <p>Description: show questions for user to answer </p>
 */
public class QNAView extends JFrame{
	
	private static final long serialVersionUID = -4913708280290665975L;
		
	private JPanel northPnl,centerPnl,southPnl;
	private JButton rstBtn;
	private JButton[] chBtn;
	private JLabel curQuesLbl,scoreLbl,curAnsLbl;
	private ArrayList<QNA> qnaLists;
	private static int score = 0;
	private int index = 0;
	private final int increment;
	private int qnalen;
	
	public QNAView(Constants.Level level, Constants.Attempt apt) {
		increment=level.ordinal()+1;
		init(level,apt);
	}
	
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
	
	private void scoreadd() {
		score+=increment;
	}
	
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
	
	private void finishQandA(Constants.Attempt apt) {
			if(apt == Constants.Attempt.TWO) new FinalView(score,increment*qnalen*2);
			else new FinalView(score,increment*qnalen);
			dispose();
	}
}
