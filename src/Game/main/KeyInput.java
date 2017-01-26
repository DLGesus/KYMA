package Game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Game.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Game game;
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	boolean keyed;
	
	public KeyInput(Game game, Handler handler){
		this.handler = handler;
		this.game = game;
		keyDown[0] = false;           // W KEY
		keyDown[1] = false;           // S KEY
		keyDown[2] = false;           // D KEY
		keyDown[3] = false;           // A KEY
		keyed = false;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player && game.gameState == STATE.GAME){                 //All Key Events For Player 1
				
				if(key == KeyEvent.VK_W){ tempObject.setVelY(-6); keyDown[0] = true; }
				if(key == KeyEvent.VK_S){ tempObject.setVelY(+6); keyDown[1] = true; }
				if(key == KeyEvent.VK_D){ tempObject.setVelX(+6); keyDown[2] = true; }
				if(key == KeyEvent.VK_A){ tempObject.setVelX(-6); keyDown[3] = true; } 
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		if(key == KeyEvent.VK_P && (game.gameState == STATE.GAME || game.gameState == STATE.PAUSE)){
			if(keyed == false){
				keyed = true;
				game.gameState = STATE.PAUSE;
			} else if(keyed == true){
				keyed = false;
				game.gameState = STATE.REVERSEHIDE;
			}
			
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){                       //All Key Events For Player 1
				
				if(key == KeyEvent.VK_W) keyDown[0] = false;           //tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false;           //tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false;           //tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false;           //tempObject.setVelX(0);
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);  //Vertical Movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);  //Horizontal Movement
			}
		}
	}
}
