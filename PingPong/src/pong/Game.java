package pong;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable,KeyListener{
	//atributos
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 160;
	public static int HEIGHT = 120;
	public static int SCALE = 3;
	public static int scoreE, scoreP;
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	public BufferedImage layer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	//Construtor
	public Game(int scoreE, int scoreP) {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		this.addKeyListener(this);
		player = new Player(100,HEIGHT-5);
		enemy = new Enemy(100,0);
		ball = new Ball(100,(HEIGHT/2) - 1);
		Game.scoreE = scoreE;
		Game.scoreP = scoreP;
	}
	//main
	public static void main(String[]args) {
		Game game = new Game(0,0);
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);//ficar depois de add(game) para ser criado no meio da tela
		frame.setVisible(true);
		
		new Thread(game).start();
	}
	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);
		g.setFont(new Font("Arial",Font.BOLD,10));
		g.setColor(Color.green);
		g.drawString("Enemy:"+Game.scoreE,WIDTH-105,HEIGHT-70);
		g.drawString("Player:"+Game.scoreP,WIDTH-105,HEIGHT-50);
		player.render(g);
		enemy.render(g);
		ball.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(layer,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		
		bs.show();
	}
	@Override
	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(280/10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		
	}
}
