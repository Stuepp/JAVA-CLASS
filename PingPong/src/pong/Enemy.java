package pong;

import java.awt.Graphics;
import java.awt.Color;

public class Enemy {
	//atributos
	public double x,y;
	public int width,height;
	//construtor
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	//metodos
	public void tick() {
		x += (Game.ball.x - x);
		
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,width,height);
	}
}
