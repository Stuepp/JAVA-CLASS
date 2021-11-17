package pong;

import java.awt.Graphics;
import java.awt.Color;

public class Player {
	//atributos
	public boolean left,right;
	public int x,y,width,height;
	//construtor
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	//metodos
	public void tick() {
		if(right) {
			x+=5;
		}else if(left) {
			x-=5;
		}
		if(x+width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}else if(x < 0) {
			x = 0;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x,y,width,height);
	}
}
