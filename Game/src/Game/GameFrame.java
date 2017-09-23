package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import G.Constant;
import G.GameUtil;

/**
 * 游戏窗口事例类
 * 
 * @author JH
 *
 */

public class GameFrame extends Frame {
	
	Image img=GameUtil.getImage("images/sun.jpg");
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);          //窗口大小
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
	
	

	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 300, 300);            //直线
		g.drawRect(100, 100, 200, 200);            //矩形
		g.drawOval(100, 100, 300, 200);            //圆、椭圆
		
		Font f=new Font("宋体",Font.BOLD,100);
		g.setFont(f);                              //设置字体
		g.drawString("DASA", 200, 200);            //字符串
		Color c=g.getColor();                      //获取画笔颜色
		g.setColor(Color.red);                     //更改画笔颜色
		
		g.fillRect(200, 200, 20, 20);		       //矩形填充
		g.fillOval(100, 100, 30, 30);              //圆填充
		
		g.setColor(c);                             //设置成原本颜色
		
		g.drawImage(img,350,350,null);             //加载图片
		
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



	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
