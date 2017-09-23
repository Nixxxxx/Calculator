package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;

import util.GameUtil;
import util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane("images/plane.png",220,450);
	
	ArrayList bulletList=new ArrayList();
	Date startTime;
	Date endTime;
	Date nowTime;
	
	Explode bao;
	
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		p.draw(g);
		nowTime=new Date();

		double time = ((nowTime.getTime()-startTime.getTime())/1000);
		
		for(int i=0;i<bulletList.size();i++){
			Bullet b=(Bullet)bulletList.get(i);
			b.draw(g);
			
			//检测碰撞
			boolean peng=b.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);   //飞机死掉
				if(bao==null){
					endTime = new Date();
					bao =new Explode(p.x,p.y);
				}
				bao.draw(g);
				break;
			}
		}
		if(!p.isLive()){
			int period = (int)((endTime.getTime()-startTime.getTime())/1000);
			paintInfo(g,"傻叼好玩不",50,130,300,Color.WHITE);
			paintInfo(g,"时间："+period+"秒",30,180,350,Color.white);
			
		}
		paintInfo(g,"时间："+time+"秒",15,20,50,Color.yellow);
	}
	
	public void paintInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成子弹
		for(int i=0;i<30;i++){
			Bullet b=new Bullet();
			bulletList.add(b);
		}
		startTime=new Date();
	}
	
	
	//定义为内部类,可以方便使用外部类普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("按下"+e.getKeyCode());
			p.addDirection(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
            //System.out.println("释放"+e.getKeyCode());
            p.minusDirection(e);
		}	
	}
}
