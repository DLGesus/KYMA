package Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import Game.main.Game.STATE;

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private boolean[] mouseDown = new boolean[2];
	private Font MU;
	private FontMetrics MU_SIZE;
	private Font title;
	private Font mainMenu;
	
	private int counter = 0;
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
		
		mouseDown[0] = true;
		mouseDown[1] = false;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseDown[0] == true){
			//PLAY BUTTON
			if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 2/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
				game.gameState = STATE.GAME;
				
				Game.FPStrace = 1;
				
				handler.addObject(new Player(Game.WIDTH/2-30, Game.HEIGHT/2-30, ID.Player, handler));
				handler.addObject(new BasicEnemy(Game.WIDTH / 2 + 40, Game.HEIGHT / 2 - 30, ID.Enemy, Color.red, handler));
				
				mouseDown[0] = false;
				mouseDown[1] = true;
			}	
			
			//INFO BUTTON
			if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 3/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
				game.gameState = STATE.INFO;
				
				mouseDown[0] = false;
				mouseDown[1] = true;
			}
			
			//EXTRA BUTTON
			if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
				game.gameState = STATE.EXTRA;
				
				mouseDown[0] = false;
				mouseDown[1] = true;
			}
			
			//EXIT BUTTON
			if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
				System.exit(1);
				
				mouseDown[0] = false;
				mouseDown[1] = true;
			}
		}
		
		//BACK BUTTONS
		else if(mouseDown[1] == true){
			if(mouseOver(mx, my, Game.WIDTH/3, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH / 3, MU_SIZE.getHeight() + 20)){
				if(game.gameState == STATE.END){
					Game.gameOver = true;
				}else{
					game.gameState = STATE.MENU;
				}
				
				mouseDown[0] = true;
				mouseDown[1] = false;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx >= x && mx <= x + width){
			if(my >= y && my <= y + height){
				return true;
			} else return false; 
		} else return false;
	}
	
	public void tick(){
	}
	
	@SuppressWarnings("static-access")
	public void render(Graphics g){
		if(game.gameState == STATE.MENU){
			
			while(counter == 0){
				ParticleEffect particle = new ParticleEffect();
				particle.ParticleEffect();	
				counter = 1;
			}
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
			}
			catch(Exception e){}

			g.setColor(Color.white);
			title = MU.deriveFont(Font.BOLD, 100);
			mainMenu = MU.deriveFont(Font.PLAIN, 75);
			
			MU_SIZE = g.getFontMetrics(title);
			
			g.setFont(title);
			g.drawString("KYMA", Game.WIDTH/2 - MU_SIZE.stringWidth("KYMA") / 2, Game.HEIGHT/7);      //TITLE
			
			g.setFont(mainMenu);
			MU_SIZE = g.getFontMetrics(mainMenu); 
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 2/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);    //PLAY
			g.drawString("PLAY", Game.WIDTH/2 - MU_SIZE.stringWidth("PLAY") / 2,  Game.HEIGHT * 2/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 3/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);       //INFO
			g.drawString("INFO", Game.WIDTH/2 - MU_SIZE.stringWidth("INFO") / 2,  Game.HEIGHT * 3/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);       //EXTRA
			g.drawString("EXTRA", Game.WIDTH/2 - MU_SIZE.stringWidth("EXTRA") / 2,  Game.HEIGHT * 4/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("EXIT", Game.WIDTH/2 - MU_SIZE.stringWidth("EXIT") / 2,  Game.HEIGHT * 5/6);
		}
		
		if(game.gameState == STATE.INFO){
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
			}
			catch(Exception e){}
			
			//Font fnt = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 70);
			Font fnt = MU.deriveFont(Font.PLAIN, 85);
			//Font fnt2 = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 50);
			Font fnt2 = new Font("Papyrus", 1, 25);
			
			g.setColor(Color.white);
			
			MU_SIZE = g.getFontMetrics(fnt);
			g.setFont(fnt);
			//g.drawString("INFO", 270, 110);      //INFO
			g.drawString("INFO", Game.WIDTH/2 - MU_SIZE.stringWidth("INFO") / 2, Game.HEIGHT/7);
			
			MU_SIZE = g.getFontMetrics(mainMenu);      //BACK
			g.setFont(mainMenu);
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6);
			
			//INSTRUCTIONS & INFO TEXT
			g.setFont(fnt2);
			g.drawString("Use the WASD keys to move the player and evade all enemies", 60, 175);
			g.drawString("Each bullet trail does no damage, only the bullet point", 60, 205);
			g.drawString("Every 10th wave has a unique STAGE BOSS", 60, 235);
			g.drawString("Once you defeat a boss, a checkpoint will appear", 60, 265);
			g.drawString("The final wave is wave 100", 60, 295);
			g.drawString("Have Fun!", 340, 495);
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("aaron.ttf"));
			}
			catch(Exception e){}
			
			//Font fnt4 = new Font("aaronfaces", 1, 60);
			Font fnt3 = MU.deriveFont(Font.PLAIN, 60);
			
			//EMOJI
			g.setColor(Color.yellow);
			g.setFont(fnt3);
			g.drawString("flx", 480, 515);
		}
		
		if(game.gameState == STATE.EXTRA){
			Font fnt = MU.deriveFont(Font.PLAIN, 85);
			g.setColor(Color.white);
			
			g.setFont(fnt);
			g.drawString("EXTRA", Game.WIDTH/2 - MU_SIZE.stringWidth("EXTRA") / 2, Game.HEIGHT/7);      //EXTRA
			
			g.setFont(mainMenu);
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);     // BACK
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6);
		}
		
		if(game.gameState == STATE.END){
			handler.clear();
			
			g.setColor(Color.WHITE);
			
			MU_SIZE = g.getFontMetrics(title);
			
			g.setFont(title);
			g.drawString("END", Game.WIDTH/2 - MU_SIZE.stringWidth("END") / 2, Game.HEIGHT/7);
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Justo St.ttf"));
			}
			catch(Exception e){}
			
			Font score = MU.deriveFont(Font.PLAIN, 30);
			g.setFont(score);
			
			String tempStr = "Score: " + game.getScore();
			
			g.drawString(tempStr, Game.WIDTH / 7 , Game.HEIGHT * 2/7);
			
			tempStr = "Wave: " + game.getWave();
			
			g.drawString(tempStr, Game.WIDTH / 7, Game.HEIGHT * 3/7);
			
			MU_SIZE = g.getFontMetrics(mainMenu);
			g.setFont(mainMenu);
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6);
		}
	}
}
