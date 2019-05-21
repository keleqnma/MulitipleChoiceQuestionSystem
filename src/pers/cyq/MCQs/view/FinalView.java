/**
 * @Project: MCQs 
 * @File: FinalView.java 
 * @Date: May 21, 2019
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pers.cyq.MCQs.Constants;
/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 21, 2019
 * <p>Description: [//todo] </p>
 */
public class FinalView extends JFrame{
	
	private JPanel centerPnl,northPnl;
	private JButton finishBtn,againBtn;
	private JLabel ConLbl,ScoreLbl;
	private int usrMark,fullMark;
	
	public FinalView(int usrMark,int fullMark) {
		this.usrMark=usrMark;
		this.fullMark=fullMark;
		init();
	}
	
	private void init() {
		
		northPnl=new JPanel();
		ConLbl=new JLabel(Constants.FVIEW_CON_JLABEL);
		ScoreLbl=new JLabel(Constants.FVIEW_SCO_JLABEL+usrMark+"/"+fullMark);
		northPnl.add(ConLbl);
		northPnl.add(ScoreLbl);
		
		centerPnl=new JPanel();
		centerPnl.setLayout(new GridLayout(1,2,2,10));
		
		finishBtn=new JButton(Constants.FVIEW_PARAM_FIN);
		finishBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});
		
		againBtn=new JButton(Constants.FVIEW_PARAM_AGAIN);
		againBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AttemptView();
			}});
		centerPnl.add(finishBtn);
		centerPnl.add(againBtn);
		
		Font font = new Font("Arial",1,20);
		finishBtn.setFont(font);
		againBtn.setFont(font);
		ScoreLbl.setFont(font);
		ConLbl.setFont(font);
		
		add(BorderLayout.CENTER,centerPnl);
		add(BorderLayout.NORTH,northPnl);
		
		setTitle(Constants.TITLE); 
		setVisible(true);        
		setSize(Constants.FRM_SIZE, Constants.FRM_SIZE); 
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
