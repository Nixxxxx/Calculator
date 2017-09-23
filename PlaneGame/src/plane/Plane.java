package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import util.Constant;
import util.GameUtil;

public class Plane {
	Image img;
	double x,y;
	int speed=3;
	int width,height;
	boolean left,up,right,down;
	boolean live=true;
	
	public Rectangle getRect(){
		return new Rectangle((int)x,(int) y,width,height);
	}
	
	public void draw(Graphics g){
		if(live){
			g.drawImage(img,(int)x,(int)y,null);
			move();
		}
	}
	
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 37:left=true;break;
		case 38:up=true;break;
		case 39:right=true;break;
		case 40:down=true;break;
		default:break;
		}
	}
		
	public void minusDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 37:left=false;break;
		case 38:up=false;break;
		case 39:right=false;break;
		case 40:down=false;break;
		default:break;
        }
	}
	
	public void move(){
		if(left&&x>0){
			x-=speed;
		}
		if(right&&x<Constant.GAME_WIDTH-width){
			x+=speed;
		}
		if(up&&y>30){
			y-=speed;
		}
		if(down&&y<Constant.GAME_HEIGHT-height){
			y+=speed;
		}
	}
	
	public Plane(String imgpath, double x, double y) {
		super();
		this.img=GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	

	public Plane(){
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
