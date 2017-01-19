package Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class VerticallyFastEnemy extends GameObject{
	
	private Handler handler;
	private Color color;
	
	public VerticallyFastEnemy(float x, float y, ID id, Color color, Handler handler){
		super(x, y, id);
		
		this.handler = handler;
		this.color = color;
		
		velX = 3;
		velY = 10;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick(){
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 20) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g){
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	//handler.addObject(new VerticallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.cyan, handler));
}
