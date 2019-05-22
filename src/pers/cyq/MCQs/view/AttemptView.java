/**
 * @Project: MCQs 
 * @File: AttemptView.java 
 * @Date: May 22, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: The first view for user to choose their attempt.</p>
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
 * The Class AttemptView.
 *
 * @author cyq
 * @Project: MCQs
 * @Date: May 20, 2019
 * <p>Description: to choose attempt </p>
 */
public class AttemptView extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5311268218862568386L;
	
	/** The frame has 2 panels. */
	private JPanel northPnl,centerPnl;
	
	/** The button shows that one or two chances for users to answer. */
	private JButton oneBtn,twoBtn;
	
	/** The label shows the choose informations. */
	private JLabel choseLbl;
	
	/**
	 * Instantiates a new attempt view.
	 */
	public AttemptView() {
		init();
	}
	
	/**
	 * private Init method.
	 */
	private void init() {
		//north panel
		northPnl=new JPanel();
		choseLbl=new JLabel(Constants.APTVIEW_JLABEL_CH);
		northPnl.add(choseLbl);
		
		//center panel
		centerPnl= new JPanel();
		centerPnl.setLayout(new GridLayout(1,2,2,10));
		
		oneBtn=new JButton(Constants.APTVIEW_ONCE);
		oneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LevelView(Constants.Attempt.ONE);
			}
		});
		twoBtn=new JButton(Constants.APTVIEW_TWICE);
		twoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LevelView(Constants.Attempt.TWO);
			}
		});
		centerPnl.add(oneBtn);
		centerPnl.add(twoBtn);
		
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
