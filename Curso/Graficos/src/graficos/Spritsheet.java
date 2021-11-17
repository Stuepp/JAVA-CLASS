package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritsheet {
	private BufferedImage spritsheet;
	
	public Spritsheet(String path){
		try {
			spritsheet = ImageIO.read(getClass().getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int PosX, int PosY, int width, int height) {
		return spritsheet.getSubimage(PosX, PosY, width, height);
	}
}
