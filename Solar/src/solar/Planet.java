package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Planet extends Star {

	double longAxis;   // Õ÷‘≤≥§÷·
	double shortAxis;  // Õ÷‘≤∂Ã÷·
	double speed;      // ∑…––ÀŸ∂»
	double degree; 
	Star center;
	boolean satellite;
	
	public void draw(Graphics g){
		super.draw(g);
		if(satellite){
		drawTrace(g);
		}
		move();
		
	}
	
	public void drawTrace(Graphics g){
		double _x,_y,_width,_height;
		_width=longAxis*2;
		_height=shortAxis*2;
		_x=center.x+center.width/2-longAxis;
		_y=center.y+center.height/2-shortAxis;
		
		Color c=g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int) _x, (int) _y,(int) _width, (int) _height);
		g.setColor(c);
	}
	
	public void move(){
		//—ÿ◊≈Õ÷‘≤πÏº£∑…––
				x=center.x+center.width/2+longAxis*Math.cos(degree);
				y=center.y+center.height/2+shortAxis*Math.sin(degree);
				
				degree+=speed;
	}

	
	
	public Planet(Star center,String imgpath, double longAxis,
			double shortAxis, double speed ,boolean satellite){
		this.satellite=satellite;
		this.center=center;
		this.x=center.x+longAxis;
		this.y=center.y;
		this.img=GameUtil.getImage(imgpath);
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}

	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
}
