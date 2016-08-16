package test;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameState extends BasicGameState {
	
	private ArrayList<Circle> balls;
	private ArrayList<Circle> bombs;
	private Circle mouseBall;
	private int timePassed;
	private Random random;
	private int life;
	private int points;
	private int counter;
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		balls = new ArrayList<Circle>();
		bombs = new ArrayList<Circle>();
		mouseBall = new Circle(0,0,20);
		timePassed = 0;
		points = 0;
		life = 5;
		counter = 0;
		random = new Random();
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_1)){
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
		mouseBall.setCenterX(container.getInput().getMouseX());
		mouseBall.setCenterY(container.getInput().getMouseY());
		
		timePassed += delta;
		//spawn balls every 200 milisecs
		if(timePassed>200){
			timePassed = 0;
			balls.add(new Circle(10 + random.nextInt(700),0,20));
			if(counter==5){
				bombs.add(new Circle(10 + random.nextInt(700),0,20));
				counter = 0;
			}
			counter +=1;
		}
		//for the regular balls
		for(Circle c: balls){
			c.setCenterY(c.getCenterY() + (delta)/5f);
		}
		for(int i = balls.size()-1; i>=0; i--){
			Circle c = balls.get(i);
			if(c.getCenterY() > 610){
				balls.remove(i);
				life -= 1;
			}
			else if(c.intersects(mouseBall)){
				balls.remove(i);
				points += 1;
			}
		}
		//for the bombs
		for(Circle c: bombs){
			c.setCenterY(c.getCenterY() + (delta)/5f);
		}
		for(int i = bombs.size()-1; i>=0; i--){
			Circle c = bombs.get(i);
			if(c.intersects(mouseBall)){
				bombs.remove(i);
				life -= 1;
			}
		}
		if(life==0){
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
		
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setColor(Color.yellow);
		g.fill(mouseBall);
		
		g.setColor(Color.red);
		for(Circle c: bombs){
			g.fill(c);
		}
		g.setColor(Color.cyan);
		for(Circle c: balls){
			g.fill(c);
		}
		g.drawString("Score:" + points, 20, 50);
		g.drawString("Lives:" + life, 20, 70);
	}


	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
