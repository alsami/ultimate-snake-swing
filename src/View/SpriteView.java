package View;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ViewInterface.IDrawable;
import ViewInterface.IMoveable;

@SuppressWarnings("serial")
public class SpriteView extends Rectangle2D.Double implements IDrawable, IMoveable {
	private GamePanelView gamePanelView;
	private BufferedImage bufferedImage;

	public SpriteView(String path, double x, double y, GamePanelView gamePanelView) {
		bufferedImage = loadImage(path);
		this.x = x;
		this.y = y;
		this.gamePanelView = gamePanelView;
	}

	protected BufferedImage loadImage(String path){
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}

	/* (non-Javadoc)
	 * @see ViewInterface.IMoveable#move(java.awt.Point)
	 */
	@Override
	public void move(Point point) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ViewInterface.IDrawable#drawObjects(java.awt.Graphics)
	 */
	@Override
	public void drawObjects(Graphics graphics) {
		graphics.drawImage(bufferedImage, (int) x, (int) y, null);
	}

	public void doLogic() {

	}
}
