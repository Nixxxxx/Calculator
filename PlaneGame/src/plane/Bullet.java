package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.Constant;

public class Bullet {
	double x=Constant.GAME_WIDTH/2,y=Constant.GAME_HEIGHT/2;
	int speed=3;
	double degree;
	int width=10,height=10;
	
	
	public Bullet(){
		degree=Math.random()*Math.PI*2;
	}
	
	public Rectangle getRect(){
		return new Rectangle((int)x,(int) y,width,height);
	}
	
	public void draw(Graphics g){
		Color c=g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(x>Constant.GAME_WIDTH-width||x<width){
			degree=Math.PI-degree;
		}
		if(y>Constant.GAME_HEIGHT-height||y<height){
			degree=-degree;
		}
		
		g.setColor(c);
	}
}
