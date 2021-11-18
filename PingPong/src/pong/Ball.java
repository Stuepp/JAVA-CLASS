package pong;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball {
	//atributos
	public double x,y,dx,dy,speed=6;
	public int width,height;
	//construtor
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 5;
		
		int angle = new Random().nextInt((120-45) +45);
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	//metodos
	public void tick() {
		if(x + (dx*speed) + width >= Game.WIDTH || x+(dx*speed) < 0) {
			dx*=-1;
		}
		if(y >= Game.HEIGHT) {
			Game.scoreE++;
			new Game(Game.scoreE,Game.scoreP, false);
			return;
		}else if( y < 0) {
			Game.scoreP++;
			new Game(Game.scoreE,Game.scoreP, false);
			return;
		}
		
		Rectangle bounds = new Rectangle((int) (x+(dx*speed)),(int) (y+(dy*speed)),width,height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x,(int) Game.enemy.y,Game.enemy.width,Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt((120-45) +45);
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0) {
				dy*=-1;	
			}
		}else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt((120-45) +45);
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy < 0) {
				dy*=-1;
			}
		}
		
		x += dx*speed;
		y += dy*speed; 
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
	}
}
