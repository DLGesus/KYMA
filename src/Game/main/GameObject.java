package Game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x;
	protected float y;
	
	protected float velX;
	protected float velY;
	
	protected ID id;
	
	public GameObject(float x, float y, ID id){    //CONSTRUCTOR (MAKER)
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(float x){                   //MUTATOR (SETTER)
		this.x = x;
	}
	
	public void setY(float y){                   //MUTATOR (SETTER)
		this.y = y;
	}
	
	public float getX(){                         //ACCESSOR (GETTER)   
		return x;
	}
	
	public float getY(){                         //ACCESSOR (GETTER)
		return y;
	}
	
	public void setID(ID id){                  //MUTATOR (SETTER)
		this.id = id;
	}
	
	public ID getID(){                         //ACCESSOR (GETTER)
		return id;
	}
	
	public void setVelX(float velX){             //MUTATOR (SETTER)
		this.velX = velX;
	}
	
	public void setVelY(int velY){             //MUTATOR (SETTER)
		this.velY = velY;
	}
	
	public float getVelX(){                      //ACCESSOR (GETTER)
		return velX;
	}
	
	public float getVelY(){                      //ACCESSOR (GETTER)
		return velY;
	}
}
