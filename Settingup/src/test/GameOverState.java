package test;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		//draw gameover
		g.drawString("GAME OVER", 300, 300);
	}


	public int getID() {
		//signals that we are at the gameover state
		return 1;
	}

}

