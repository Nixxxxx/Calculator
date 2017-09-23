package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口类
 * 
 * @author JH
 *
 */

public class MyFrame extends Frame {
	
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);   //窗口大小
		setLocation(100,100);      //窗口位置
		setVisible(true);          //窗口可见
		
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);          //窗口关闭
			}
			
		});
	}
	
	/**
	 * 双缓冲解决窗口闪烁
	 */
	
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();

		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author JH
	 *
	 */
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);       //1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
	}
}


