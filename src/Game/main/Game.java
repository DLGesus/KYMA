package Game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -4201078827097160085L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int FPStrace = 20; // Modify to modify FPS
	
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler;                                       //UPDATES AND RENDERS EVERY SINGLE GAME OBJECT
	
	private HUD hud;
	private Spawn spawner;
	
	public Menu menu;
	
	public enum STATE{
		MENU,
		INFO,
		EXTRA,
		END,
		GAME
	};
	
	public STATE gameState;
	
	public Game(){
		handler = new Handler();
		menu = new Menu(this, handler);
		gameState = STATE.MENU;
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "Kyma 1.1.0", this);
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		r = new Random();
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			 while(delta >= 1){
				 tick();
				 delta--;
			 }
			 if(running)
				 render();
			 frames++;
			 
			 if(System.currentTimeMillis() - timer > 1000){
				 timer += 1000;
				 System.out.println("FPS: " + frames);
				 frames = 0;
			 }
			 try{
				 Thread.sleep(FPStrace);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		 stop();
	}
	
	private void tick(){
		handler.tick();
		
		if(gameState == STATE.MENU) menu.tick();
		
		else if(gameState == STATE.GAME){
			hud.tick();
			spawner.tick();
		}
	}
	
	private void render(){                              //BACKGROUND
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(gameState == STATE.MENU || gameState == STATE.INFO || gameState == STATE.EXTRA){
			menu.render(g);
		}
		if(gameState == STATE.GAME) hud.render(g);	
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max){
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}
	
	public static void main(String args[]){
		new Game();
	}
	
}
