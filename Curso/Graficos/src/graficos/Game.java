package graficos;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Graphics2D;

public class Game extends Canvas implements Runnable{
	//Atributos
	public static JFrame frame;
	private final int WIDTH = 240;
	private final int HEIGHT = 160;
	private final int SCALE = 3;
	private Thread thread;
	private boolean isRunning = true;
	private BufferedImage image;
	private Spritsheet sheet;
	private BufferedImage[] player;
	private int frames = 0;
	private int maxFrames = 20;
	private int curAnimation = 0, maxAnimation = 3;
	//Construtor
	public Game() {
		sheet = new Spritsheet("/spritsheet.png");
		player = new BufferedImage[3];
		player[0] = sheet.getSprite(0, 0, 16, 16);
		player[1] = sheet.getSprite(16, 0, 16, 16);
		player[2] = sheet.getSprite(32, 0, 16, 16);
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		image = new BufferedImage(160, 120, BufferedImage.TYPE_INT_RGB);//width, height, image type
	}
	//Métodos
	public void initFrame() {
		frame = new JFrame("Game #1");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);//janela fica no centro
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try{
			thread.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	public void tick() {//update
		frames++;
		if(frames > maxFrames) {
			frames = 0;
			curAnimation++;
			if(curAnimation >= maxAnimation) {
				curAnimation = 0;
			}
		}
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		//fundo de tela (retangulo)
		g.setColor(new Color(19,19,40));
		g.fillRect(0, 0, WIDTH, HEIGHT);// Posx, Posy, width,height
		//retangulo
		g.setColor(Color.CYAN);
		g.fillRect(3, 40, 10/3, 80/3);//o scale está multiplicando por 3 então para ser 80 temos que dividir por 3
		//retangulo
		g.setColor(Color.GRAY);
		g.fillRect(154, 40, 10/3, 80/3);
		//Bola
		g.setColor(Color.WHITE);
		g.fillOval(70, 40, 50/3, 50/3);
		//String
		g.setFont(new Font("Arial", Font.BOLD, 10));//font, font type, size
		g.setColor(Color.WHITE);
		g.drawString("Olá mundo", 90, 90);
		//"Player" --- Rendarização do jogo
		/*Graphics2D g2 = (Graphics2D) g;
		g2.rotate(Math.toRadians(90), 20+8, 20+8);*/
		g.drawImage(player[curAnimation], 20, 20, null);
		//
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		}
		stop();
	}
	//main
	public static void main(String[]args) {
		Game game = new Game();
		game.start();
	}

}
