/**
 * @Project: MCQs 
 * @File: LevelView.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: The second view for user to choose their difficulty level. </p>
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
 * The Class LevelView.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 19, 2019
 * <p>Description: The second view to choose the level </p>
 */
public class LevelView extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -758905445128070716L;
	
	/** The frame has 2 panels. */
	private JPanel northPnl,centerPnl;
	
	/** The different buttons show different difficulty, and the different scores users get. */
	private JButton easyBtn,mediBtn,diffBtn;
	
	/** The label shows the choose informations. */
	private JLabel choseLbl;
	
	/**
	 * Instantiates a new level view.
	 *
	 * @param apt the apt
	 */
	public LevelView(Constants.Attempt apt) {
		init(apt);
	}
	
	/**
	 * private Init method.
	 *
	 * @param apt the attempt of one or two chances for users to answer.
	 */
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

