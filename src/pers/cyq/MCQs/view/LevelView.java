/**
 * @Project: MCQs 
 * @File: MainView.java 
 * @Date: May 19, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
 */
package pers.cyq.MCQs.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pers.cyq.MCQs.Constants;

/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 19, 2019
 * <p>Description: The first view to choose the level </p>
 */
public class LevelView extends JFrame{
	
	private static final long serialVersionUID = -758905445128070716L;
	
	private JPanel northPnl,centerPnl;
	private JButton easyBtn,mediBtn,diffBtn;
	private JLabel choseLbl;
	
	public LevelView(Constants.Attempt apt) {
		init(apt);
	}
	
	private void init(Constants.Attempt apt) {
				
		//north panel
		northPnl=new JPanel();
		choseLbl=new JLabel(Constants.LEVELVIEW_JLABEL_CH);
		northPnl.add(choseLbl);
		
		//center panel
		centerPnl= new JPanel();
		centerPnl.setLayout(new GridLayout(3,1,0,15));
		
		easyBtn=new JButton(Constants.LEVELVIEW_EASY);
		easyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new QNAView(Constants.Level.EASY, apt);
			}
		});
		
		mediBtn=new JButton(Constants.LEVELVIEW_MEDI);
		mediBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new QNAView(Constants.Level.MEDI, apt);
			}
		});
		
		diffBtn=new JButton(Constants.LEVELVIEW_DIFF);
		diffBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new QNAView(Constants.Level.DIFF, apt);
			}
		});		
		
		centerPnl.add(easyBtn);
		centerPnl.add(mediBtn);
		centerPnl.add(diffBtn);
		
		//overall layout
		add(BorderLayout.NORTH,northPnl);
		add(BorderLayout.CENTER,centerPnl);
		
		setTitle(Constants.TITLE); 
		setVisible(true);        
		setSize(Constants.FRM_SIZE, Constants.FRM_SIZE); 
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}

