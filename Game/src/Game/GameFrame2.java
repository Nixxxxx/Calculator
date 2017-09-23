package Game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import G.GameUtil;

/**
 * ̨��
 * 
 * @author JH
 *
 */

public class GameFrame2 extends Frame {
	
	Image img=GameUtil.getImage("images/sun.jpg");
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(500,500);          //���ڴ�С
		setLocation(100,100);      //����λ��
		setVisible(true);          //���ڿɼ�
		
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);          //���ڹر�
			}
			
		});
	}

   private double x=100,y=100;
   private double degree=3.14/3;
   private double speed=13;

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img,(int)x,(int)y,null);
		
		if(speed>0) {
			speed-=0.05;
		}
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>=500-100||y<0){
			degree=-degree;
		}
		if(x>=500-100||x<0){
			degree=Math.PI-degree;
		}
		
		
	}
	
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
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
		GameFrame2 gf = new GameFrame2();
		gf.launchFrame();
	}
}
