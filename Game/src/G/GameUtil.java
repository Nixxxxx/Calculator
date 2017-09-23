package G;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏工具类
 * @author JH
 *
 */

public class GameUtil {                                   //加载图片
	public static Image getImage(String path){
		URL u=GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img =null;
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
