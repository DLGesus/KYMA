package Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(float x, float y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 40, 40);
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 46);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Enemy){ //tempObject is now BasicEnemy
				if(getBounds().intersects(tempObject.getBounds())){
					 //Collision Code
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.white);          /*if(id == ID.Player)*/ 
		g.fillRect((int)x, (int)y, 40, 40);
	}
}
