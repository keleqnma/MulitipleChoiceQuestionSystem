/**
 * @Project: MCQs 
 * @File: Main.java 
 * @Date: May 20, 2019
 * @Author <a href="mail to: cyq65536@gmail.com" rel="nofollow">Yuqi Chen</a>
 * @Version v1.0
 * <p>Description: [//todo] </p>
 */
package pers.cyq.MCQs.view;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import pers.cyq.MCQs.util.DbUtil;
/**
 * @author cyq
 * @Project: MCQs 
 * @Date: May 20, 2019
 * <p>Description: [//TODO] </p>
 */
public class MainView {
	
	static void showinit() {
		 try
		    {
		        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		        UIManager.put("RootPane.setupButtonVisible", false);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    	//TODO exception
		    }
	}
	/**
	 * @Title£∫main
	 * @Description: [π¶ƒ‹√Ë ˆ]
	 * @Param: @param args
	 * @Return: void
	 * @CreateDate: May 20, 2019 12:46:49 PM
	 */
	public static void main(String[] args) {
		showinit();
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
