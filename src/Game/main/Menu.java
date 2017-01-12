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
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
		
		mouseDown[0] = true;
		mouseDown[1] = false;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		/*if(mouseDown[0] == true){
			//PLAY BUTTON
			if(mouseOver(mx, my, 200, 160, 300, 74)){
				game.gameState = STATE.GAME;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, Color.red, handler));
				
				mouseDown[0] = false;
			}	
			
			//INFO BUTTON
			if(mouseOver(mx, my, 200, 260, 300, 74)){
				game.gameState = STATE.INFO;
				
				mouseDown[0] = false;
				mouseDown[1] = true;
			}
			
			//EXTRA BUTTON
			if(mouseOver(mx, my, 200, 360, 300, 74)){
				game.gameState = STATE.EXTRA;
				
				mouseDown[0] = false;
				mouseDown[1] = true;
			}
		}
		
		//BACK BUTTONS
		else if(mouseDown[1] == true){
			if(mouseOver(mx, my, 200, 400, 300, 74)){
				game.gameState = STATE.MENU;
				
				mouseDown[0] = true;
				mouseDown[1] = false;
			}
		} */
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
	
	public void render(Graphics g){
		
		try{
			MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
			}
			catch(Exception e){
			}
		
		if(game.gameState == STATE.MENU){
			Font title = MU.deriveFont(Font.BOLD, 100);
			Font mainMenu = MU.deriveFont(Font.PLAIN, 75);
			
			FontMetrics MU_SIZE = g.getFontMetrics(title);

			g.setColor(Color.white);
			
			g.setFont(title);
			g.drawString("KYMA", Game.WIDTH/2 - MU_SIZE.stringWidth("KYMA") / 2, Game.HEIGHT/7);      //TITLE
			
			g.setFont(mainMenu);
			MU_SIZE = g.getFontMetrics(mainMenu); 
			
			g.drawRect(Game.WIDTH/2 - (MU_SIZE.stringWidth("PLAY") / 2) - 40,  Game.HEIGHT * 2/6 - (MU_SIZE.getHeight() / 2) - 40, MU_SIZE.stringWidth("PLAY") + 80, MU_SIZE.getHeight() + 20);       //PLAY
			g.drawString("PLAY", Game.WIDTH/2 - MU_SIZE.stringWidth("PLAY") / 2,  Game.HEIGHT * 2/6);
			
			g.drawRect(Game.WIDTH/2 - (MU_SIZE.stringWidth("INFO") / 2) - 40,  Game.HEIGHT * 3/6 - (MU_SIZE.getHeight() / 2) - 40, MU_SIZE.stringWidth("INFO") + 80, MU_SIZE.getHeight() + 20);       //INFO
			g.drawString("INFO", Game.WIDTH/2 - MU_SIZE.stringWidth("INFO") / 2,  Game.HEIGHT * 3/6);
			
			g.drawRect(Game.WIDTH/2 - (MU_SIZE.stringWidth("EXTRA") / 2) - 40,  Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, MU_SIZE.stringWidth("EXTRA") + 80, MU_SIZE.getHeight() + 20);       //EXTRA
			g.drawString("EXTRA", Game.WIDTH/2 - MU_SIZE.stringWidth("EXTRA") / 2,  Game.HEIGHT * 4/6);
			
			g.drawRect(Game.WIDTH/2 - (MU_SIZE.stringWidth("EXIT") / 2) - 40,  Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, MU_SIZE.stringWidth("EXIT") + 80, MU_SIZE.getHeight() + 20);
			g.drawString("EXIT", Game.WIDTH/2 - MU_SIZE.stringWidth("EXIT") / 2,  Game.HEIGHT * 5/6);
		}
		
		if(game.gameState == STATE.INFO){
			Font fnt = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 70);
			Font fnt2 = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 50);
			Font fnt3 = new Font("Papyrus", 1, 18);
			Font fnt4 = new Font("aaronfaces", 1, 60);
			g.setColor(Color.white);
			
			g.setFont(fnt);
			g.drawString("INFO", 270, 110);      //INFO
			
			g.setFont(fnt2);
			g.drawRect(200, 400, 300, 74);       //BACK
			g.drawString("BACK", 283, 455);
			
			//INSTRUCTIONS & INFO TEXT
			g.setFont(fnt3);
			g.drawString("Use the WASD keys to move the player and evade all enemies", 60, 175);
			g.drawString("Each bullet trail does no damage, only the bullet point", 60, 205);
			g.drawString("Every 10th wave has a unique STAGE BOSS", 60, 235);
			g.drawString("Once you defeat a boss, a checkpoint will appear", 60, 265);
			g.drawString("The final wave is wave 100", 60, 295);
			g.drawString("Have Fun!", 200, 365);
			
			//EMOJI
			g.setColor(Color.yellow);
			g.setFont(fnt4);
			g.drawString("flx", 310, 385);
		}
		
		if(game.gameState == STATE.EXTRA){
			Font fnt = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 70);
			Font fnt2 = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 50);
			g.setColor(Color.white);
			
			g.setFont(fnt);
			g.drawString("EXTRA", 240, 110);      //EXTRA
			
			g.setFont(fnt2);
			g.drawRect(200, 400, 300, 74);        //BACK
			g.drawString("BACK", 283, 455);
		}
	}
}
