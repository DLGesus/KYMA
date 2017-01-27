package Game.main;

import java.awt.event.KeyEvent;

public class CheatCode {

	private boolean [] ATTARI = new boolean [8]; //UP UP DOWN DOWN LEFT RIGHT ENTER . <- resets code
	CheatCode(){
		resetATTARI();
		}
	
	
	public void resetATTARI(){
		ATTARI = KeyInput.memset(ATTARI, 8, false);
	}
	public void checkCode(int key){
		if(key == KeyEvent.VK_UP){
			ATTARI[0] = true;
		}
		else if(ATTARI[0]){
			if(ATTARI[1]){
				
			}
			else if(key == KeyEvent.VK_UP){
				
			}
			else{
				resetATTARI();
			}
		}
		
		
	}
	
}
