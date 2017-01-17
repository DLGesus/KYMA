package Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicBullet extends GameObject{
	
	private Handler handler;
	private Random r = new Random();
	private Color color;
	
	public BasicBullet(float x, float y, ID id, Color color, Handler handler){
		super(x, y, id);
		
		this.handler = handler;
		this.color = color;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 7;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick(){
		x += velX;
		y += velY;
		
		if(y >= Game.HEIGHT + 16) handler.removeObject(this);
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.06f, handler));
	}

	public void render(Graphics g){
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
	}
}
