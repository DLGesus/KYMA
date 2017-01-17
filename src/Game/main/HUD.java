package Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	public static float HEALTH = 100;
	private float greenValue = 255;
	
	private int score = 0;
	private int wave = 1;
	
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH * 2;
		score++;
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH * 3, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 300, 32);
		
		Font fnt = new Font("Justo St", Font.PLAIN, 13);
		g.setFont(fnt);
		
		g.drawString("Score: " + score, 18, 64);
		g.drawString("Wave: " + wave, 19, 80);
	}	
	
	public void setScore(int score){                       //MUTATOR (SETTER)
		this.score = score;
	}
	
	public int getScore(){                                 //ACCESSOR (GETTER)
		return score;
	}
	
	public void setWave(int level){                       //MUTATOR (SETTER)
		this.wave = level;
	}
	
	public int getWave(){                                 //ACCESSOR (GETTER)
		return wave;
	}
}
