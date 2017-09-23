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
 * ��Ϸ����������
 * 
 * @author JH
 *
 */

public class GameFrame extends Frame {
	
	Image img=GameUtil.getImage("images/sun.jpg");
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);          //���ڴ�С
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
	
	

	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 300, 300);            //ֱ��
		g.drawRect(100, 100, 200, 200);            //����
		g.drawOval(100, 100, 300, 200);            //Բ����Բ
		
		Font f=new Font("����",Font.BOLD,100);
		g.setFont(f);                              //��������
		g.drawString("DASA", 200, 200);            //�ַ���
		Color c=g.getColor();                      //��ȡ������ɫ
		g.setColor(Color.red);                     //���Ļ�����ɫ
		
		g.fillRect(200, 200, 20, 20);		       //�������
		g.fillOval(100, 100, 30, 30);              //Բ���
		
		g.setColor(c);                             //���ó�ԭ����ɫ
		
		g.drawImage(img,350,350,null);             //����ͼƬ
		
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
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
