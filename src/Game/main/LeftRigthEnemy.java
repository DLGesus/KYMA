package Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class LeftRigthEnemy extends GameObject{
	
	private Handler handler;
	private Color color;
	
	public LeftRigthEnemy(float x, float y, ID id, Color color, Handler handler){
		super(x, y, id);
		
		this.handler = handler;
		this.color = color;
		
		velX = 5;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick(){
		x += velX;
		
		if(x <= 0) velX *= -1;
		if(x >= Game.WIDTH - 22) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.05f, handler));
	}

	public void render(Graphics g){
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	//BOTOM: handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), Game.HEIGHT - 44, ID.LeftRigthEnemy, Color.orange, handler));
	//TOP:   handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), 0, ID.LeftRigthEnemy, Color.orange, handler));
}
