package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

/**
 * Ì«ÑôÏµÖ÷´°¿Ú
 * @author JH
 *
 */


public class SolarFrame extends MyFrame {
		Image bg=GameUtil.getImage("images/bg.jpg");
		Star sun=new Star("images/sun.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
		Planet earth=new Planet(sun,"images/Earth.jpg",150,100,0.1,true);
		Planet mars=new Planet(sun,"images/mars.jpg",200,140,0.2,true);
		Planet moon=new Planet(earth,"images/moon.jpg",40,30,0.1,false);
		
		public void paint(Graphics g){
			g.drawImage(bg,0,0,null);
			sun.draw(g);
			earth.draw(g);
			mars.draw(g);
			moon.draw(g);
		}
		
		public static void main(String[] args) {
			new SolarFrame().launchFrame();
		}
}
