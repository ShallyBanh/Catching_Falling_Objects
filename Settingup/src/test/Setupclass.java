package test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Setupclass extends StateBasedGame {

	public Setupclass(String title) {
		super(title);
	}
	

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Setupclass("setup Test")); 
		//set the display size
		app.setDisplayMode(800, 600, false);
		app.start();
	}


	public void initStatesList(GameContainer container) throws SlickException {
		//set up my two game states
		this.addState(new GameState());
		this.addState(new GameOverState());
	}


}
