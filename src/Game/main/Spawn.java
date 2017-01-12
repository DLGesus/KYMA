package Game.main;

import java.awt.Color;
import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	
	private int scoreKeep = 0;
	private Random r = new Random();
	
	private int looper;
	
	public Spawn(Handler handler, HUD hud){
		this. handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
			
			if(scoreKeep == 500){
				hud.setWave(2);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 46), ID.BasicEnemy, Color.yellow, handler));                                  //BasicEnemy
			}
			
			if(scoreKeep == 1000){
				hud.setWave(3);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Color.magenta, handler));                                 //BasicEnemy
			}
			
			if(scoreKeep == 1500){
				hud.setWave(4);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 55), ID.BasicEnemy, Color.pink, handler));                                    //BasicEnemy
			}
			
			if(scoreKeep == 2000){
				hud.setWave(5);
				handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), Game.HEIGHT - 44, ID.LeftRigthEnemy, Color.orange, handler));                                     //LeftRightEnemy (BOTTOM)
				handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), 0, ID.LeftRigthEnemy, Color.orange, handler));                                                    //LeftRightEnemy (TOP)
			}
			
			if(scoreKeep == 2500){
				hud.setWave(6);
				handler.addObject(new UpDownEnemy(0, r.nextInt(Game.HEIGHT - 45), ID.UpDownEnemy, Color.orange, handler));                                                         //UpDownEnemy (LEFT)
				handler.addObject(new UpDownEnemy(Game.WIDTH - 22, r.nextInt(Game.HEIGHT - 45), ID.UpDownEnemy, Color.orange,  handler));                                          //UpDownEnemy (Right)
			}
			
			if(scoreKeep == 3000){
				hud.setWave(7); 
				handler.addObject(new VerticallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.VerticallyFastEnemy, Color.cyan, handler));                  //VerticallyFastEnemy
			}
				
			if(scoreKeep == 3500){
				hud.setWave(8);  
				handler.addObject(new HorizontallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.HorizontallyFastEnemy, Color.green, handler));             //HorizontallyFastEnemy
			}
				
			if(scoreKeep == 4000){
				hud.setWave(9);   
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.SmartEnemy, Color.lightGray, handler));                               //SmartEnemy
			}
			
			if(scoreKeep == 4350){
				hud.setWave(10);  
				handler.clearEnemies();
				handler.addObject(new EnemyBoss1(Game.WIDTH / 2 + 38, -155, ID.EnemyBoss1, handler));                                                                              //EnemyBoss1
			}
	}
}
